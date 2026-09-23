import java.io.PushbackInputStream;


public class Test {

    /**
     * Testing of classes Physical, Scenary and World to contruct sinple map
     * @param args
    */
    public static void main(String args[]){
        
        Physical physicals[] = new Physical[35];        
        int counter = 0;

        int i = 0;
        while( i < 9){
            if(i < 2 || i == 4|| i == 6 || i == 8){
                int j = 0;
                if(i == 4 || i == 6){
                    while (j < 3) {
                        Physical put = new Physical(i, j, '#');    
                        physicals[counter] = put; 
                        counter++;
                        j++;
                    }
                }
                else{
                    while (j < 5) {
                        Physical put = new Physical(i, j, '#');    
                        physicals[counter] = put; 
                        counter++;
                        j++;
                    }
                }
            }
            i++;
        }
 
        for(int k = 0; k < 9; k++ ){
            Physical wall = new Physical(k, 5, '#');
            physicals[counter] = wall;
            counter++;
        }


        Physical detail =  new Physical(5, 0, '#');
        physicals[counter] = detail;
        counter++;

        //at moment objects are rpresented for characters


        Physical potion = new Physical(5, 1, '*'); //the potion its represented for *
        physicals[counter] = potion; 
        counter++;

        Physical second_potion = new Physical(2, 4, '*');
        physicals[counter] = second_potion; 
        counter++;



        Physical enemy =new Physical(7, 4, '@');
        physicals[counter] = enemy; //at the moments its represented for @;
        counter++;
      
        Physical character =  new Physical(2, 0, 'o');
        physicals[counter] = character; //at the moments its represented for o;

        World world = new World(physicals, 6, 9);   
        world.update();     
        Scenery scenary = new Scenery(world);

        System.out.println("Print a simple map\n");
        scenary.show();
        System.out.println("\n");




        
        // Prove movement


                   
        System.out.println("YOU EXIT SUCCESFULLY");

        

    }


    
}
