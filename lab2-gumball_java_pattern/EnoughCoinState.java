

import java.util.Random;

public class EnoughCoinState implements State {
	GumballMachine gumballMachine;
 
	public EnoughCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
    public void insertCoin(int value){
        if (value==25)
        System.out.println("You inserted a quarter");
        else if (value==10)
         System.out.println("You inserted a dime");
        else if (value==5)
         System.out.println("You inserted a nickel");
        else 
          System.out.println("Error! You need to insert quarter, dime or nickel");
          
        gumballMachine.setCoins(gumballMachine.getCoins()+ value);
          
    }
    
    
	public void ejectCoin() {
        int number=gumballMachine.getCoins();
		System.out.println("All your money "+ number+ "cents have been returned" );
	    gumballMachine.setCoins(0);
		gumballMachine.setState(gumballMachine.getNotEnoughCoinState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
