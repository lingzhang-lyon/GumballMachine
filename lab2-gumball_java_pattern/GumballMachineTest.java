

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    private GumballMachine gumballM1;

    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gumballM1 = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testTurnCrankWithMoreThan50Cent()
    {   
        System.out.println("start test turn crank with more thant 50 cents:----------------");
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.insertDime();
        gumballM1.insertNickel();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        assertEquals(1, gumballM1.gumballInSlot);
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
    @Test
    public void testTurnCrankWithNoCoin()
    {   
        System.out.println("start test trun crank with no coins:---------------- ");
        gumballM1.turnCrank();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
    @Test
    public void testTurnCrankWithNotEnoughCoin()
    {   
        System.out.println("start test turn crank with not enough coins:---------------- ");
        gumballM1.insertQuarter();
        gumballM1.insertDime();
        gumballM1.insertNickel();
        gumballM1.turnCrank();
        assertEquals(false, gumballM1.isGumballInSlot());
        assertEquals(40, gumballM1.getCoins());
    }
   
    @Test
    public void testTakeGumballWithNoCoin()
    {   
        System.out.println("start test taking gumball with no coins:---------------- ");
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
    @Test
    public void testTakeGumballAfterTrunCrankTwice()
    {   
        System.out.println("start test taking gumball after truned crank twice:---------------- ");
        int value=4;
        for(int i=0; i<value; i++)
            gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        assertEquals(2, gumballM1.gumballInSlot);
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
    @Test
    public void testInsertAnother50CentsBeforeTakeGumball()
    {   
        System.out.println("start test insert another 50cents before taken the gumball:---------------- ");
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        assertEquals(1, gumballM1.gumballInSlot);
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        assertEquals(2, gumballM1.gumballInSlot);
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
    }
    
     @Test
    public void testOutOfGumball()
    {   
        System.out.println("start test out of gumball:---------------- ");
        int n=12;
        for(int i=0; i< n; i++)
            gumballM1.insertQuarter();
        
        int m=5;
        for(int i=0; i< m; i++)
            gumballM1.turnCrank();
            
        assertEquals(true, gumballM1.isGumballInSlot());
        assertEquals(5, gumballM1.gumballInSlot);
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
        
        gumballM1.turnCrank();
        assertEquals(false, gumballM1.isGumballInSlot());
        assertEquals(50, gumballM1.getCoins());
        
    }
    
    
}
