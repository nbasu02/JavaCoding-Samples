import static org.junit.Assert.*;

import org.junit.Test;


public class HeapListTest {

	//Tests to make sure list is automatically sorted
	@Test
	public void testInsertSorted() {
		HeapList<Integer> testList = new HeapList<Integer>();
		testList.add(1);
		testList.add(0);
		testList.add(2);
		
		Integer expectedOutcome[] = {0, 1, 2};
		
		assert(testList.toArray() == expectedOutcome);
	}

	//Tests for string case, which is different from other comparables since it ignore cases
	@Test
	public void testInsertSortedStrings() {
		HeapList<String> testList = new HeapList<String>();
		
		testList.add("abc");
		testList.add("Aa");
		testList.add("Acc");
		
		String expectedOutcome[] = {"Aa", "abc", "Acc"};
		
		assert(testList.toArray() == expectedOutcome);
	}
	
	//Tests to make sure pop() returns the smallest value, and removes it from the list
	@Test
	public void testPop() {
		HeapList<Integer> testList = new HeapList<Integer>();
		testList.add(1);
		testList.add(0);
		testList.add(2);
		
		assert(testList.pop() == 0 && testList.size() == 2 && testList.pop() == 1);
	}

}
