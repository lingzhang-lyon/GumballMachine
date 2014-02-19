import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    boolean moved=false;
    public void moveto(int x, int y)
    {
      setLocation(x, y);
    }
    
    public void moveback()
    {
       setLocation(533,291);  //could find this position in GumballWorld.java
    }
    

}
