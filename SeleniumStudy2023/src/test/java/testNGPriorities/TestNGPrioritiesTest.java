package testNGPriorities;

import org.testng.annotations.Test;

public class TestNGPrioritiesTest {
	 @Test()
		public void method1(){
		 System.out.println("No priorty  will be executed second if menthodnames are same as per alphnumeric order");
		}
		 @Test(priority=0)
		public void method2(){
			 System.out.println("priority=0   will be executed thrid");
		}
		 @Test(priority=1)
			public void method3(){
			 System.out.println("priority=1   will be executed fourth");
			
			 }
		 @Test(priority=-1)
		public void method4(){
			 System.out.println("Priority-1 will be executed first");
		
		 }
}
