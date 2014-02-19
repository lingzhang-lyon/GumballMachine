import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void pickto(int x, int y) 
    {
        int randomnumber=Greenfoot.getRandomNumber(3);
        switch (randomnumber) {
        case 0:
        Gumball ggb=new GreenGumball();
        World gworld=getWorld();
        gworld.addObject(ggb, x, y);
        break;
        case 1:
        Gumball bgb=new BlueGumball();
        World bworld=getWorld();
        bworld.addObject(bgb, x, y);
        break;
        case 2:
        Gumball rgb=new RedGumball();
        World rworld=getWorld();
        rworld.addObject(rgb, x, y);
        break;
        }
    } 
    
    public void moveback()
    {
        setLocation(655,94);  //the position of randomPicker could be found in GumballWorld.java
    }
}
