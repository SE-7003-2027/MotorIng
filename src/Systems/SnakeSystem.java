package src.Systems;

import src.Audio.AudioPlayer;
import src.Physical.Physical;
import src.Physical.Potion;
import src.World.CollisionInfo;
import src.World.World;
import src.Draw;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of a system for the "Snake" game that generates the tail as new items are added.
 * 
 */
public class SnakeSystem implements GameSystem{

    private final Physical head;
    private final Potion potion;
    private final Draw draw;
    private final GameStateSystem gameState;

    private final List<Physical> body = new ArrayList<>();
    
    // Lista exacta de celdas ocupadas por la serpiente:
    // positions.get(0) -> Cabeza
    // positions.get(1..N) -> Segmentos del cuerpo
    private final List<int[]> positions = new ArrayList<>();

    public SnakeSystem(Physical head, Potion potion, Draw draw, GameStateSystem gameState){
        this.head = head;
        this.potion = potion;
        this.draw = draw;
        this.gameState = gameState;
        
        // Registrar posición inicial de la cabeza
        this.positions.add(new int[]{head.getX(), head.getY()});
    }

    @Override
    public void update(World world){
        if(gameState.isGameOver()) return;

        // 1. Detección de colisiones mortales (Muros '#' o cuerpo 'o')
        CollisionInfo collisions = head.getTrackCollision();
        if(collisions != null){
            if(collisions.getTouchedTiles().contains('#')){
                triggerGameOver("¡Chocaste contra la pared!");
                return;
            }
            for(Physical physical : collisions.getTouchedPhysicals()){
                if(body.contains(physical)){
                    triggerGameOver("¡Te mordiste la cola!");
                    return;
                }
            }
        }

        // 2. Verificar si la cabeza cambió de celda en este tick
        int[] currentHeadPos = positions.get(0);
        boolean headMoved = (head.getX() != currentHeadPos[0] || head.getY() != currentHeadPos[1]);

        if(headMoved){
            // A. Insertar las nuevas coordenadas de la cabeza al frente de la lista
            positions.add(0, new int[]{head.getX(), head.getY()});

            // B. Evaluar si consumió la poción (World la remueve automáticamente)
            boolean atePotion = !world.getPhysicals().contains(potion);

            if(atePotion){
                // Registrar puntaje y sonido
                gameState.addScore(10);
                /*Por ahora no implementamos el sonido */
                //AudioPlayer.play("audio/eat.wav");

                // CRECIMIENTO SIN DELAY: Se crea el nuevo segmento exactamente en la posición
                // donde estaba la cola antes del avance (último elemento de 'positions')
                int[] tailPos = positions.get(positions.size() - 1);
                Physical newSegment = new Physical(tailPos[0], tailPos[1], 'o');
                
                body.add(newSegment);
                world.getPhysicals().add(newSegment);

                // Reubicar la poción y reincorporarla al mundo
                world.getPhysicals().add(potion);
                EntitySpawner.spawnInFreeCell(world, potion);
            }else{
                // Si NO comió, eliminar el último elemento de la lista para liberar la celda
                positions.remove(positions.size() - 1);
            }

            // C. Sincronizar las coordenadas físicas de todos los segmentos del cuerpo
            for (int i = 0; i < body.size(); i++){
                int[] pos = positions.get(i + 1);
                body.get(i).updatePos(pos[0], pos[1]);
            }
        }
    }

    private void triggerGameOver(String reason){
        gameState.setGameOver();
        //AudioPlayer.play("audio/gameover.wav");
        draw.showMessage(reason + " Score: " + gameState.getScore());
        System.out.println("--- GAME OVER --- " + reason + " | Score: " + gameState.getScore());
    }
}