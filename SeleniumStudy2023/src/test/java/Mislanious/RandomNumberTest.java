package Mislanious;

import java.util.Random;

public class RandomNumberTest {

	public static void main(String[] args) {
		int min = 1;
		int max = 10;

		for (int i = 0; i < 10; i++) 
		{
			Random rand = new Random();
			int randomNumber = rand.nextInt(max - min + 1) + min;
			System.out.println("Random number between 1 and 10: " + randomNumber);

		}




	}






}
