import static org.junit.Assert.*;

import org.junit.Test;


public class JumbleSorterTest {

	//Tests entries are being inserted
	@Test
	public void testInsert() {
		JumbleSorter testJumble = new JumbleSorter();
		testJumble.insert("a");
		testJumble.insert("1");
		
		assert(testJumble.getDataHash().size() == 2);
	}
	
	//Tests integer strings result in the word "Integer" being stored in sorter
	@Test
	public void testInsertInteger() {
		JumbleSorter testJumble = new JumbleSorter();
		testJumble.insert("1");
		
		assert(((String)testJumble.getTypeOrder().get(0)).compareTo("Integer") == 0);
	}

	//Tests other strings result in the word "String" being stored in sorter
		@Test
		public void testInsertString() {
			JumbleSorter testJumble = new JumbleSorter();
			testJumble.insert("a");
			
			assert(((String)testJumble.getTypeOrder().get(0)).compareTo("String") == 0);
		}
	
	//Tests that the sorting actually works correctly
	@Test
	public void testSort() {
		JumbleSorter testJumble = new JumbleSorter();
		testJumble.insert("1");
		testJumble.insert("b");
		testJumble.insert("a");
		testJumble.insert("0");
		
		String expectedOutcome[] = {"0", "a", "b", "1"};
		
		assert(testJumble.sort() == expectedOutcome);
	}

}
