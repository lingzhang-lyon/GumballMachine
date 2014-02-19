import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballWorld extends World
{

    /**
     * Constructor for objects of class GumballWorld.
     * 
     */
    public GumballWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        GumballMachine gumballmachine = new GumballMachine();
        addObject(gumballmachine, 367, 237);
        addObject( new Penny(), 57, 71 ) ;
        addObject( new Quarter(), 68, 156 ) ;
        addObject( new FakeQuarter(), 66, 248 ) ;

        Inspector inspector = new Inspector();
        addObject(inspector, 533, 291);
        RandomPicker randompicker = new RandomPicker();
        addObject(randompicker, 643, 104);
        randompicker.setLocation(655, 94);
        GreenPicker greenpicker = new GreenPicker();
        addObject(greenpicker, 686, 454);
        greenpicker.setLocation(669, 456);
        Quarter quarter2 = new Quarter();
        addObject(quarter2, 157, 432);
        Quarter quarter3 = new Quarter();
        addObject(quarter3, 157, 432);
        Quarter quarter4 = new Quarter();
        addObject(quarter4, 299, 462);
        Quarter quarter5 = new Quarter();
        addObject(quarter5, 299, 462);
        Quarter quarter6 = new Quarter();
        addObject(quarter6, 133, 351);
        quarter6.setLocation(80, 349);
        quarter3.setLocation(97, 441);
        quarter5.setLocation(90, 535);
        quarter2.setLocation(193, 526);
        quarter4.setLocation(197, 434);
        quarter3.setLocation(80, 440);
        quarter5.setLocation(80, 528);
        quarter4.setLocation(190, 436);
        quarter6.setLocation(65, 347);
        quarter3.setLocation(67, 437);
        quarter5.setLocation(73, 528);
    }
}
