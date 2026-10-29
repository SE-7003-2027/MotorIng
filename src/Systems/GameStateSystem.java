package src.Systems;

import src.World.World;

/**
 * Manages the global state of the game, including the current game state
 * (playing, game over, victory) and the player's score.
 *
 * @author 1IsaacJR
 * @version 0.1
 */
public class GameStateSystem implements GameSystem{

    /**
     * Represents the possible states of the game.
     */
    public enum State{
        PLAYING,
        GAME_OVER,
        VICTORY
    }

    private State currentState;
    private int score;

    /**
     * Creates a new {@code GameStateSystem} initialized in the {@link State#PLAYING}
     * state with a score of zero.
     */
    public GameStateSystem(){
        this.currentState = State.PLAYING;
        this.score = 0;
    }

    /**
     * Adds points to the total score if the game is currently active.
     *
     * @param points the number of points to add
     */
    public void addScore(int points){
        if (currentState == State.PLAYING){
            this.score += points;
        }
    }

    /**
     * Changes the current game state to {@link State#GAME_OVER}.
     */
    public void setGameOver(){
        this.currentState = State.GAME_OVER;
    }

    /**
     * Returns the current state of the game.
     *
     * @return the current {@link State}
     */
    public State getCurrentState(){
        return currentState;
    }

    /**
     * Returns the total accumulated score.
     *
     * @return the current score
     */
    public int getScore(){
        return score;
    }

    /**
     * Checks whether the game has reached the game over state.
     *
     * @return {@code true} if the game is over, {@code false} otherwise
     */
    public boolean isGameOver(){
        return currentState == State.GAME_OVER;
    }

    /**
     * Updates global state logic during each game tick.
     *
     * @param world the world in which the state logic is evaluated
     */
    @Override
    public void update(World world){
        // Global state updates per tick can be handled here.
    }
}