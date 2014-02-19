import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Gumball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gumball extends Actor
{

    public Gumball()
    {
        GreenfootImage image = getImage() ;
        image.scale( 50, 50 ) ; 
    }

    public void act() 
    {
       if(Greenfoot.mousePressed(this)) {
            World world = getWorld();
            int x=getX();
            int y=getY();
            //find the picker above the gumball
            List<Picker> pickers=world.getObjectsAt(x,y-150,Picker.class); 
            Picker selectedpicker=pickers.remove(0);
            selectedpicker.moveback();
            //find the message around the gumball and then remove it
            List<Message> ms=world.getObjectsAt(x-100,y-50,Message.class); 
            Message m=ms.remove(0);
            world.removeObject(m);
            //remove the gumball
            world.removeObject( this ) ;
            List<GumballMachine> gms=world.getObjects(GumballMachine.class); 
            GumballMachine gm=gms.remove(0);
            gm.clear=true;
        } // Add your action code here.
    }    
}
