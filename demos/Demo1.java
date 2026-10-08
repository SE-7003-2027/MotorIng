import java.io.IOException;
import java.util.Vector;
import src.World.MapReader;
import src.World.World;
import src.World.Map;
import src.Physical.ClusterPhysical;
import src.Physical.Physical;
import src.Draw;
import src.MapPanel;
import src.Inputs.JframeInput;
import src.Controller.*;

public class Demo1 {

        public static void main(String[] args) throws IOException{
                System.out.println("Hola mundo");
                
                Map demo1 = MapReader.read("maps/label.txt");
                Physical character = new Physical(2,2, '@');
                Physical obstacle = new Physical(9, 5, 'X');

                ClusterPhysical caja = new ClusterPhysical(10,5,"###", "###");

                Vector<Physical> lines = new Vector<>();
                lines.add(character);
                lines.add(obstacle);
                lines.add(caja);

                World map1 = new World(demo1, lines);
                JframeInput lopo = new JframeInput();
                
                //will draw teh map
                Draw drawi = new Draw(map1, lopo);
                drawi.drawMap();

                UserController controllerCharacter = new UserController(character, lopo); 
                Vector<Controller> controllers = new Vector<>();
                controllers.add(controllerCharacter);
                
                map1.update(controllers);

                while (true) {
                        
                        map1.update(controllers);
                        drawi.show();

                        try {
                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                                break;
                        }
                }


                System.out.println(
                "Jugador: (" + character.getX() + ", " + character.getY() + ")"
                );


                

        }

        
        
}