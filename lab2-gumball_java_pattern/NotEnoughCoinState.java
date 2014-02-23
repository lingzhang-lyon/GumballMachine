

public class NotEnoughCoinState implements State {
    GumballMachine gumballMachine;
 
    public NotEnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int value) {
		if (value==25)
        System.out.println("You inserted a quarter");
        else if (value==10)
         System.out.println("You inserted a dime");
        else if (value==5)
         System.out.println("You inserted a nickel");
        else 
          System.out.println("Error! You need to insert quarter, dime or nickel");
          
	    gumballMachine.setCoins(gumballMachine.getCoins()+ value);
		
		if (gumballMachine.getCoins()>=50)
		gumballMachine.setState(gumballMachine.getEnoughCoinState());
		else 
		System.out.println("You need to inserted more coin");
	}
	
	   
	public void ejectCoin() {
	    int number=gumballMachine.getCoins();
		if (number>0){
		System.out.println("All your money "+ number+ "cents have been returned" );
	    gumballMachine.setCoins(0);
	    } 
	    else {
	    System.out.println("You haven't inserted a coin");
	    }
	}
 
	public void turnCrank() {
	    int number=gumballMachine.getCoins();
		System.out.println("You turned, but there's only " + number +" cents, you need at least 50 cents");
	 }
 
	public void dispense() {
		System.out.println("You need to pay enough coins first");
	} 
 
	public String toString() {
		return "waiting for more coins";
	}
}
