package mathresources;

import java.util.ArrayList;

public class MathModule {
	
	public  int add(int x, int y){
		
        if(y == 0) { 
        	
        	return x;
        }	
    
        return add( (x ^ y), ((x & y) << 1));
	}

	public int subtract(int x, int y){
		
	    if (y == 0) {
	    	
	        return x;    
	    }
	    
	    return subtract(x ^ y, (~x & y) << 1);
	}
	
	public int multiply(int x, int y) {
		
		int sum = 0;
		int sign = 1;
		
		if(x < 0){
	    	
			x = reverse(x);
	        sign = reverse(sign);
	    }
		
		if (y < 0) {
	    	
			y = reverse(y);
	        sign = reverse(sign);
	    }

	    while (y != 0) {
	    	
            if ((y & 01) != 0) {
            	
                sum = add(sum,x); 
            }
            
            x <<= 1;             
            y >>= 1;             
        }
		
		return (sign>0)?sum:reverse(sum);
	}
	
	public int division(int dividend, int divisor) {
		
	    if(divisor == 0){
	    	
	        throw new ArithmeticException("Division by 0 equals Infinity");
	    }
	    
	    int sign = 1;    
	    
	    if(dividend < 0){
	    	
	    	dividend = reverse(dividend);
	        sign = reverse(sign);
	    }
	    
	    if (divisor < 0) {
	    	
	    	divisor = reverse(divisor);
	        sign = reverse(sign);
	    }
	           
	    int quotient = 0;
	    long r;
	    for (int i = 30; i >= 0; i = subtract(i, 1)) {
	    	r = (divisor << i);
	    
	    	if (r < Integer.MAX_VALUE && r >= 0) { 
	    		if (r <= dividend) { 
	    			
	    			quotient |= (1 << i);    
	    			dividend = subtract(dividend, (int) r);
	    			
	                }
	            }
	        }
	    
	    return (sign == 1)?quotient:reverse(quotient);
	}
	
	public int modulo(int x, int y) {
		
	    if(y == 0){
	    	
	        throw new ArithmeticException("Division by 0 equals Infinity");
	    }
  
	    int result = 0;
	    
	    if(x < 0){
	    	
	        x = reverse(x);
	    }
	    
	    if (y < 0) {
	    	
	        y = reverse(y);
	    }
	           
	    while(x >= y){
	    	
	        x = subtract(x, y);
	        
	        result = add(result,1);
	    }
	     
	    return x;
	}
	
	public int square(int x) {
			
		return (x>=0)?multiply(x, x):multiply(reverse(x), reverse(x));
	}
	
	public int average(ArrayList<Integer> list) {
		
		int sum = 0;
		
		int size = list.size();
		
		for(int i = 0; i < size ; i++){
			
			sum = add(sum,list.get(i));
			
		}
		
		return division(sum,size);	
		
	}
		
	public int distanceSquared (int x , int avg) {
			
		
		return square(subtract(x, avg));
	}
	
	public int variance(ArrayList<Integer> list) {
				
		int size = list.size();
		
		int avg = average(list);
		
		int sumDistance = 0;
		
		for(int i = 0; i < size; i++){
						
			sumDistance = add(sumDistance, distanceSquared(list.get(i), avg));
		}
		
		return division(sumDistance, subtract(size, 1));
	}

	public int reverse(int number) {
		
		return (~(number - 1));
	}
	
	public double standardDeviation(ArrayList<Integer> list) {
		
		return Math.sqrt(variance(list));
	}
}



















