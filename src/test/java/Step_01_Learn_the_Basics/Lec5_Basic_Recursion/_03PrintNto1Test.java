package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

import org.junit.Test;

public class _03PrintNto1Test {

	@Test
	public void testcase1() {
		_03PrintNto1 p = new _03PrintNto1();
		p.print(5);
	}
	
	@Test
	public void testcase2() {
		_03PrintNto1 p = new _03PrintNto1();
		p.print(15);
	}
	
	@Test
	public void testcase3() {
		_03PrintNto1 p = new _03PrintNto1();
		p.print(10);
	}
	
	@Test
	public void testcase4() {
		_03PrintNto1 p = new _03PrintNto1();
		p.print(-1);
	}
}
