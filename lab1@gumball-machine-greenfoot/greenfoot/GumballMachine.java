import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
   
    int hasCoin=0;
    static int num_Gumballs=5;
    private ArrayList<Coin> coins=new ArrayList<Coin>();  // to store the inserted coins
    boolean clear=true;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 250, 300 ) ; 
    }

    protected void showMessage( Message ms, String msg, int x, int y ) 
    {   
        ms.setText( msg ) ;       
        World world = getWorld();
        List<Message> oldms = world.getObjectsAt(x, y, Message.class);
        if (oldms != null )
        {
            world.removeObjects(oldms) ;
        }
        world.addObject(ms, x, y) ;
    }
    
    public void act() 
    {
  
        
        Actor coin;
        coin = getOneObjectAtOffset(0, 0, Coin.class);
        if ( coin != null )
        {
            insertCoin(coin,coins);
        } 
        
        if(Greenfoot.mousePressed(this)) {  
          if (clear==true) { 
            World world = getWorld();  //execetion
            List<Inspector> inspectors=world.getObjects(Inspector.class);
            Inspector inspector=inspectors.remove(0);
            int mouseX=getX();
            int mouseY=getY();
            inspector.moveto(mouseX+100, mouseY-100);
            inspector.moved=true;
            if(turnCrank (coins,inspector)==true) { // if the coin is a real quater
              
               //inspect gumball number
              if(num_Gumballs<=0) 
              {
                Message m=new Message(); 
                showMessage(m, "Have no gumball left", mouseX, mouseY+200);
              }
              
              else{// select a picker
              int whichPicker=Greenfoot.getRandomNumber( 2) ;
              Picker selectedpicker=new Picker();
              if(whichPicker==0) 
              {
                  List<Picker> pickers=world.getObjects(RandomPicker.class);
                  selectedpicker=pickers.remove(0);
                  Message m=new Message(); 
                  showMessage(m, "RandomPicker got a gumball for you!", mouseX, mouseY+200);
                }
              else
              {
                 List<Picker> pickers=world.getObjects(GreenPicker.class);
                 selectedpicker=pickers.remove(0);
                 Message m=new Message(); 
                 showMessage(m, "GreenPicker got a gumball for you!", mouseX, mouseY+200);
                }
              // picker pick gumball
              selectedpicker.moveto (mouseX+100, mouseY+100);
              selectedpicker.pickto (mouseX+100, mouseY+250);
              clear=false;
              num_Gumballs--;  
              }
            }
          }  
          
        }
    }
    
    private void insertCoin(Actor coin, ArrayList<Coin> coins)
    {
            System.out.println( coin.toString() ) ;
           
            Coin addcoin = (Coin) coin;
            coins.add (addcoin);
            int number=coins.size();
            int mouseX=getX();
            int mouseY=getY();
            Message m=new Message(); 
            showMessage(m, "Have " + number + " Coins", mouseX, mouseY-200);
            World world = getWorld() ;
            world.removeObject( coin ) ;
        }
    
    private boolean turnCrank(ArrayList<Coin> coins, Inspector inspector) 
    {
      int mouseX=getX();
      int mouseY=getY();
      int number=coins.size();
      
      if ( number== 0 ){
                Message m=new Message();  
                showMessage( m, "Has No Coin!", mouseX, mouseY-200) ;
                if(inspector.moved==true) inspector.moveback(); 
                return false;
	                          
            }
      else
      {
          Coin inspectcoin = coins.remove (coins.size()-1);
           number--;
           Message m=new Message(); 
           if(inspectcoin.getClass() != Quarter.class) {
                showMessage (m, "Crank turned! Not a quarter! " + number + " Coins Left" , mouseX, mouseY-200);
                //if (number==0) inspector.moveback();
                return false;
         
           }
           else {
               showMessage (m, "Crank turned! It's a quarter! " + number + " Coins Left", mouseX, mouseY-200);
               //if (number==0) inspector.moveback();
               return true;
            }
               
            }
    }
}  
    
    
    
    
