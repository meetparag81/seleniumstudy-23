package testNGPriorities;

import org.testng.annotations.Test;

public class dependsOnTest 
{
	@Test
	public void Test1() 
	{
		System.out.println("test1is primart test");
	}
	@Test(dependsOnMethods = {"Test1"})
	public void Test2() 
	{
		System.out.println("test2 is depends on test1");
	}
	/*
	 * @Test("dependsOnMethods = Test1") public void Test3() {
	 * System.out.println("test is depends on test1"); }
	 */
	
	public class DependentTests {
	    @Test(dependsOnMethods = {"openBrowser"})
	    public void signIn() {
	        System.out.println("This will execute second (SignIn)");
	    }

	    @Test
	    public void openBrowser() {
	        System.out.println("This will execute first (Open Browser)");
	    }
	}



}
