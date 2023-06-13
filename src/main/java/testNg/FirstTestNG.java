package testNg;

import org.testng.annotations.Test;

public class FirstTestNG {

	@Test(priority=3,enabled =false)
	public void firstTestCase() {
		System.out.println("My 1 Test Case");
	}
	@Test(priority=2)
	public void secondTestCase() {
		System.out.println("My 2 Test Case");
	}
	@Test(priority=1)
	public void thirdTestCase() {
		System.out.println("My 3 Test Case");
	}
	@Test(priority=0)
	public void fourthTestCase() {
		System.out.println("My 4 Test Case");
	}

}
