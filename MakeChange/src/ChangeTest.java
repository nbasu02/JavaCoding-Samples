import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class ChangeTest {

	@Test
	public void testMakeBestChange() {
		int expectedOutcome[] = {5,1,1,4};
		int[] output = Change.makeBestChange(1.44);
		
		assert(output == expectedOutcome);
	}

	//Tests to make sure a not-previously expanded node is in hash
	@Test
	public void testChangeComboExists() {
		int input[] = {1, 1, 1, 1};
		ChangeNode testNode = new ChangeNode(input);
		testNode.makeChange();
		
		assert(Change.changeComboExists(testNode));
	}
	
	//Tests to make sure a not-previously expanded node is not in hash
	@Test
	public void testChangeComboDoesNotExist() {
		int input[] = {1, 1, 1, 1};
		ChangeNode testNode = new ChangeNode(input);
		
		assert(!Change.changeComboExists(testNode));
	}


	//Tests to make sure adding change combos works correctly
	@Test
	public void testAddCombo() {
		int input[] = {1, 1, 1, 1};
		ChangeNode testNode = new ChangeNode(input);
		Change.addCombo(testNode);
		
		assert(Change.changeComboExists(testNode));		
	}

	//Makes sure resetting change's hash works correctly
	@Test
	public void testReset() {
		int input[] = {1, 1, 1, 1};
		ChangeNode testNode = new ChangeNode(input);
		Change.addCombo(testNode);
		Change.reset();
		
		assert(Change.numCombos() == 0);		
	}

	//Makes sure keeps count of number of elements in hash
	@Test
	public void testnumCombos() {
		int input[] = {1, 1, 1, 1};
		ChangeNode testNode = new ChangeNode(input);
		Change.addCombo(testNode);

		assert(Change.numCombos() == 1);		
	}

}
