package testNGPriorities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HightoLowPriorityTest {
  
	 @BeforeMethod
	  public void beforeMethod() 
	  {
	  }
	 @Test() 
	  public void c_metnod()
	  {
		 System.out.println("c_metnod has second highest priority");
	  }
	 @Test() 
	  public void b_metnod()
	  {
		 System.out.println("b_metnod has highest priority");
		 
	  }
	 @Test(priority=0) 
     public void e_metnod()
     {
		 System.out.println("e_metnod has thrid highest priority");
     }

  @Test(priority=6) 
	  public void a_metnod()
	  {
	  System.out.println("a_metnod has  fourth highest priority");
	  }
  @Test(priority=6) 
  public void d_metnod()
  {
	  System.out.println("d_metnod has fifth highest priority");
	  
  }

 

  @AfterMethod
  public void afterMethod() {
  }

}
