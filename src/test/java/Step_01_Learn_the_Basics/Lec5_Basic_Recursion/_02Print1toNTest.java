package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

import org.junit.Test;

public class _02Print1toNTest {

	@Test
	public void testcase1() {
		_02Print1toN p = new _02Print1toN();
		p.print1toN(5);
	}
	
	@Test
	public void testcase2() {
		_02Print1toN p = new _02Print1toN();
		p.print1toN(15);
	}
	
	@Test
	public void testcase3() {
		_02Print1toN p = new _02Print1toN();
		p.print1toN(10);
	}
	
	@Test
	public void testcase4() {
		_02Print1toN p = new _02Print1toN();
		p.print1toN(-1);
	}
}
