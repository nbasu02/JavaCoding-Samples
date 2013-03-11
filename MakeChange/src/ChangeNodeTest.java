import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ChangeNodeTest {
	ChangeNode changeNode;
	
//	@Before
//	public void setUp() throws Exception {
//		changeNode =
//	}

	@Test
	public void testMakeChangeOnePenny() {
		int coins[] = {0,0,0,1};
		changeNode = new ChangeNode(coins);
		assert(changeNode.makeChange().compareTo(changeNode.toString()+"\n") == 0);
	}
	
	@Test
	public void testMakeChangeOneNickel() {
		int coins[] = {0,0,1,0};
		int coins2[] = {0,0,0,5};
		changeNode = new ChangeNode(coins);
		ChangeNode changeNode2 = new ChangeNode(coins2);
		assert(changeNode.makeChange().compareTo(changeNode.toString()+"\n" +
		changeNode2.toString()+"\n") == 0);
	}


}
