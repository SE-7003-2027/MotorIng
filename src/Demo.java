package src;
import java.util.Vector;
import src.Physicals.Physical;
import src.World.World;


public class Demo {
    public static void main(String[] args) {
        Vector<Physical> physicals = new Vector<>();

        for (int i = 0; i < 31; i++) {
                if(i!= 12)
                physicals.add(new Physical(i, 4, '#'));
            }
        for (int i : new int[]{0,30}) {
            for (int j = 5; j < 20; j++) {
                physicals.add(new Physical(i, j, '#'));
            }
        }
        for (int i = 0; i < 31; i++) {
                if(i!= 20)
                physicals.add(new Physical(i, 19, '#'));
            }
        for (int i : new int[]{8, 15}) {
            for (int j = 5; j < 10; j++) {
                physicals.add(new Physical(i, j, '#'));
            }
        }
        for (int i = 8; i < 15; i++) {
                if(i!= 10)
                physicals.add(new Physical(i, 9, '#'));
            }


        Physical enemy =new Physical(10, 6, '@');
        physicals.add(enemy);
      
        Physical character =  new Physical(10, 11, 'o');
        physicals.add(character); //at the moments its represented for o;

        World world = new World(physicals.toArray(Physical[]::new), 21, 40);   
        world.addController(character);
        world.update();     
        Scenery scenary = new Scenery(world);
        Input input = new Input();

        System.out.println("START?");
        scenary.update(input);
    }
}
