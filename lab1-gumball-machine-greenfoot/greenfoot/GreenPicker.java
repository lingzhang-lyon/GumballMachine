import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPicker extends Picker
{
    /**
     * Act - do whatever the GreenPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void pickto(int x, int y) 
    {
        Gumball gm=new GreenGumball();
        World world=getWorld();
        world.addObject(gm, x, y);
    } 
    
    public void moveback()
    {
        setLocation(669,456);  //the position of GreenPicker could be found in GumballWorld.java
    }
}
