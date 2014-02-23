
public class GumballMachine implements IGumballMachine {
 
	State soldOutState;
	State enoughCoinState;
	State notEnoughCoinState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;
	int coins = 0 ;
	int gumballInSlot = 0;
 
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		notEnoughCoinState = new NotEnoughCoinState(this);
		enoughCoinState = new EnoughCoinState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = notEnoughCoinState;
		} 
	}
 
	public void insertQuarter() {
		state.insertCoin(25);
	}
	
    public void insertDime(){
        state.insertCoin(10);
    }
    
    public void insertNickel(){
        state.insertCoin(5);
    }
    
	public void ejectCoin() {
		state.ejectCoin();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
			gumballInSlot += 1;
			coins = coins - 50;
		}
		System.out.println("There are totally " + gumballInSlot +" gumballs in the slot now");  
	}  
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = notEnoughCoinState;
	}

    public State  getState() {
        return state;
    }

    public State  getSoldOutState() {
        return soldOutState;
    }

    public State  getNotEnoughCoinState() {
        return notEnoughCoinState;
    }

    public State  getEnoughCoinState() {
        return enoughCoinState;
    }

    public State  getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
	
	public void setCoins(int value){
	    coins=value;
	}
	
    public int getCoins() {
        return coins;
    }
    
    public boolean isGumballInSlot(){
        if (gumballInSlot>0) return true;
        else return false;
    }
    
	public void takeGumballFromSlot(){
	   if(isGumballInSlot()){
	       System.out.println("You have taken all the "+ gumballInSlot + " gumballs in the slot");
	       gumballInSlot = 0; 
	   }
	   else 
	       System.out.println("There is no gumball in the slot");
    }
	 
}
