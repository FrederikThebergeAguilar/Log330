package mathresources;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MathModuleTest {

	@Test
	void addTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.add(5, 34) == 39);
	}

	@Test
	void subtractTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.subtract(34,5) == 29);
		
		assert(mm.subtract(5,39) == -34);
	}
	
	@Test
	void multiplyTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.multiply(62,534) == 33108);
	
	}
	
	@Test
	void divisionTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.division(20,5) == 4);
		
	}
	
	@Test
	void squareTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.square(34) == 1156);
		
		assert(mm.square(-34) == 1156);

		
	}
	
	@Test
	void AverageTest() {
		
		MathModule mm = new MathModule();
		
		ArrayList <Integer> list = new ArrayList<Integer>();
		
		int[] numbers = {29,34,56,654,354,2346,345,65,23,4};
		
		for(int i = 0;i<10;i++) {
			
			list.add(numbers[i]);
			
		}
		
		assert(mm.average(list) == 391);

		
	}
	
	@Test
	void distanceSquareTest() {
		
		MathModule mm = new MathModule();
		
		assert(mm.distanceSquared(201, 391) == 36100);
		
		assert(mm.distanceSquared(402, 391) == 121);

		
	}
	
	@Test
	void varianceTest() {
		
		MathModule mm = new MathModule();
		
		ArrayList <Integer> list = new ArrayList<Integer>();
		
		int[] numbers = {29,34,56,654,354,2346,345,65,23,4};
		
		for(int i = 0;i<10;i++) {
			
			list.add(numbers[i]);
			
		}
		
		System.out.println(""+mm.variance(list));
		assert(mm.variance(list) == 517429);

	}
	
	@Test
	void standardDeviationTest() {
		
		MathModule mm = new MathModule();
		
		ArrayList <Integer> list = new ArrayList<Integer>();
		
		int[] numbers = {29,34,56,654,354,2346,345,65,23,4};
		
		for(int i = 0;i<10;i++) {
			
			list.add(numbers[i]);
			
		}
		
		double sd = mm.standardDeviation(list);
		assert(719<sd && sd<720 );

	}
	
}
