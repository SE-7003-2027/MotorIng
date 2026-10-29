package src;

import src.Inputs.Input;
import src.Inputs.JframeInput;
import src.Physical.Interactuable;
import src.Physical.Physical;
import src.Systems.GameLoop;
import src.Systems.GameSystem;
import src.World.Map;
import src.World.MapReader;
import src.World.World;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Dodge the falling rocks, built on the engine and structured like Test.java.
 * Everything lives in this single file: the game, the rocks and the rules.
 *
 * <p>Controls: A/D (or left/right arrows) to move, SPACE to restart.</p>
 *
 * @version 0.2
 */
public class DodgeGame {

    public static void main(String[] args) throws IOException {

        // Load the map.
        Map map = MapReader.read("maps/dodge.txt");

        // Falling rocks, staggered so they do not all arrive together.
        List<Rock> rocks = new ArrayList<>();
        rocks.add(new Rock(2, 1));
        rocks.add(new Rock(5, 4));
        rocks.add(new Rock(8, 2));
        rocks.add(new Rock(11, 6));
        rocks.add(new Rock(13, 3));
        rocks.add(new Rock(4, 8));

        Physical player = new Physical(7, 10, 'o');

        Vector<Physical> physicals = new Vector<>(rocks);
        physicals.add(player); // Added last so it is drawn on top.

        // Keyboard input and world.
        JframeInput input = new JframeInput();
        World world = new World(map, physicals);

        // Window.
        Draw draw = new Draw(world, input);
        draw.drawMap();

        System.out.println("Esquiva las rocas (V): A/D o flechas, SPACE reinicia.");

        // Game loop with a single system containing the rules.
        GameLoop game = new GameLoop(world, draw);
        game.addSystem(new DodgeSystem(player, rocks, input, draw));
        game.start();
    }

    /**
     * A falling rock. It is {@link Interactuable} so the player can walk
     * into it without being blocked; the hit itself is detected by
     * {@link DodgeSystem}.
     */
    static class Rock extends Interactuable {

        Rock(int x, int y) {
            super(x, y, 'V');
        }

        @Override
        public void interact(Physical other, World world) {
            // Nothing to do here: DodgeSystem checks for hits every tick.
        }
    }

    /**
     * Rules of the game.
     *
     * <p>A fixed pool of rocks falls one cell at a time. When a rock reaches
     * the floor it is dodged: the score goes up and the rock reappears at the
     * top in a random column. The fall speed increases with the score. If a
     * rock and the player share a cell, the game ends.</p>
     */
    static class DodgeSystem implements GameSystem {

        private static final int START_TICKS_PER_FALL = 10;
        private static final int MIN_TICKS_PER_FALL = 3;
        private static final int TICKS_BETWEEN_MOVES = 5;
        private static final int SPAWN_ROW = 1;

        private final Physical player;
        private final List<Rock> rocks;
        private final Input input;
        private final Scenery scenery;
        private final Random random = new Random();

        private final int startPlayerX;
        private final int startPlayerY;
        private final int[][] startRocks;

        private int fallCounter = 0;
        private int moveCooldown = 0;
        private int score = 0;
        private boolean gameOver = false;

        DodgeSystem(Physical player, List<Rock> rocks,
                    Input input, Scenery scenery) {
            this.player = player;
            this.rocks = rocks;
            this.input = input;
            this.scenery = scenery;

            this.startPlayerX = player.getX();
            this.startPlayerY = player.getY();
            this.startRocks = new int[rocks.size()][];
            for (int i = 0; i < rocks.size(); i++) {
                startRocks[i] = new int[]{
                        rocks.get(i).getX(), rocks.get(i).getY()
                };
            }
        }

        @Override
        public void update(World world) {
            String command = input.getInput();
            if (command == null) {
                command = "";
            }

            if (gameOver) {
                if (command.equals("SPACE")) {
                    restart();
                }
                return;
            }

            movePlayer(world, command);
            if (playerIsHit()) {
                endGame();
                return;
            }

            fallCounter++;
            if (fallCounter < ticksPerFall()) {
                return;
            }
            fallCounter = 0;

            fallRocks(world);
            if (playerIsHit()) {
                endGame();
            }
        }

        /** Rocks fall faster as the score increases. */
        private int ticksPerFall() {
            return Math.max(MIN_TICKS_PER_FALL,
                    START_TICKS_PER_FALL - score / 5);
        }

        private void movePlayer(World world, String command) {
            if (moveCooldown > 0) {
                moveCooldown--;
                return;
            }

            if (command.equals("A")) {
                world.move(player, -1, 0);
                moveCooldown = TICKS_BETWEEN_MOVES - 1;
            } else if (command.equals("D")) {
                world.move(player, 1, 0);
                moveCooldown = TICKS_BETWEEN_MOVES - 1;
            }
        }

        private void fallRocks(World world) {
            for (Rock rock : rocks) {
                int x = rock.getX();
                int y = rock.getY();

                if (!world.inBounds(x, y + 1) || world.isWall(x, y + 1)) {
                    score++;
                    respawn(world, rock);
                } else {
                    rock.updatePos(x, y + 1);
                }
            }
        }

        /** Puts a rock back at the top, in a random non-wall column. */
        private void respawn(World world, Rock rock) {
            int width = world.getMap().getWidth();
            int x;

            do {
                x = random.nextInt(width);
            } while (!world.inBounds(x, SPAWN_ROW)
                    || world.isWall(x, SPAWN_ROW));

            rock.updatePos(x, SPAWN_ROW);
        }

        private boolean playerIsHit() {
            for (Rock rock : rocks) {
                if (rock.getX() == player.getX()
                        && rock.getY() == player.getY()) {
                    return true;
                }
            }
            return false;
        }

        private void endGame() {
            gameOver = true;
            System.out.println("Puntos: " + score);
            scenery.showMessage("Fin del juego: " + score + " pts | SPACE");
        }

        private void restart() {
            player.updatePos(startPlayerX, startPlayerY);

            for (int i = 0; i < rocks.size(); i++) {
                rocks.get(i).updatePos(startRocks[i][0], startRocks[i][1]);
            }

            score = 0;
            fallCounter = 0;
            moveCooldown = 0;
            gameOver = false;
            scenery.clearMessage();
        }
    }
}
