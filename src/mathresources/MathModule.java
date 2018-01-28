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
	
	public double add (double x ,double y) {
		
		int decimals = add(regularExpression(getBelowUnit(x)),regularExpression(getBelowUnit(y)));
		
		int aboveDecimals = add(getAboveUnit(x),getAboveUnit(y));
		
		if(decimals >= 1000) {
			
			decimals = regularExpression(decimals);
			
			aboveDecimals = add(aboveDecimals,1);
		}
		
		String number = (""+aboveDecimals+"."+decimals); 
		
		return Double.parseDouble(number);
	}
	
	public double subtract(double x ,double y) {
		
		int decimals = subtract(regularExpression(getBelowUnit(x)),regularExpression(getBelowUnit(y)));
		
		int aboveDecimals = subtract(getAboveUnit(x),getAboveUnit(y));
		
		if(decimals < 0) {
			
			decimals = subtract(1000, decimals);
			
			aboveDecimals = subtract(aboveDecimals,1);
		}
		
		String number = (""+aboveDecimals+"."+regularExpression(decimals)); 
		
		return Double.parseDouble(number);
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
	
	public double multiply(double x, double y) {
		
		double sum = 0;
		double sumDecimal = 0;
		int sign = 1;
		
		int nbOfTime = getAboveUnit(y);
		int decimals  = regularExpression(getBelowUnit(y));
	
		if(nbOfTime<0) {
			
			nbOfTime = reverse(nbOfTime);
		}
		
		if(decimals<100 && decimals !=0) {
			
			String number = Integer.toString(decimals);
			
			while(number.length()<3) {
				
				number = (number+"0");
			}
			
			decimals = Integer.parseInt(number);
		}
		
		if(x < 0){
	    	
	        x = absolute(x);
	        sign = reverse(sign);
	    }
		
		if (y < 0) {
	    	
	        y = absolute(y);
	        sign = reverse(sign);
	    }

		
		
		for(int i = 0; i < nbOfTime ; i++){
			
			sum = add(sum,x);			
		}
		

		for(int i = 0; i < decimals ; i++){
			
			sumDecimal = add(sum,x);	
			
		}

		sumDecimal = division(decimals, 1000);
		
		sum = add(sum,sumDecimal);
		
		return (sign>0)?sum:absolute(sum);
				
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
	
	public double division(double x, double y) {
		
	    if(y == 0){
	    	
	        throw new ArithmeticException("Division by 0 equals Infinity");
	    }
	    
	    int sign = 1;    
	    int result = 0;
	    double anwser = 0;
	    
	    if(x < 0){
	    	
	        x = absolute(x);
	        sign = reverse(sign);
	    }
	    
	    if (y < 0) {
	    	
	        y = absolute(y);
	        sign = reverse(sign);
	    }
	           
	    while(x >= y){
	    	
	        x = subtract(x, y);
	        
	        result = add(result,1);
	    }
	    
	    if( x != 0) {
	    	
	    	int decimals = 0;
	    	
	    	x = multiply(1000, x);
	    	
	    	while(x >= y){
		    	
		        x = subtract(x, y);
		        
		        decimals = add(result,1);
		        	        
		    }
	    	
	    	anwser = Double.parseDouble((""+result+"."+rgDivision(decimals)));
	    }
	    
	    else {
	    	
	    	anwser = result;
	    }
	    
	    return (sign>0)?anwser:absolute(anwser);
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
	
	public double square(double x) {
		
		return multiply(x, x);
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

	public double standardDeviation(ArrayList<Integer> list) {
			
		return Math.sqrt(variance(list));
	}
	
	public int reverse(int number) {
		
		return (~(number - 1));
	}
	
	public int getAboveUnit(double x) {
		
		String number = Double.toString(x);
		
		String[] parts = number.split("[.]");
		
		return Integer.parseInt(parts[0]);
	}
	
	public int getBelowUnit(double x) {
		
		String number = Double.toString(x);
		
		String[] parts = number.split("[.]");
		
		String decimal = parts[1];
		
		if(decimal.length()>3) {
			
			decimal = decimal.substring(0, 3);
			
		}
		
		return Integer.parseInt(decimal);
	}
	
	public int getFirstNumber(int x) {
		
		String number= Integer.toString(x) ;
		
		return Integer.parseInt(number.substring(0, 1));
			
	}
	
	public double absolute(double x) {
		
		return Double.parseDouble(Double.toString(x).substring(1));
	}
	
	public int regularExpression(int decimals) {
		
		
		if(decimals<100 && decimals !=0) {
			
			String number = Integer.toString(decimals);
			
			while(number.length()<3) {
				
				number = (number+"0");
			}
			
			decimals = Integer.parseInt(number);
		}
		
		else if(decimals>999) {
			
			String number = Integer.toString(decimals);
			
			while(number.length()>3) {
				
				number = number.substring(1);
			}
			
			decimals = Integer.parseInt(number);
			
		}
		
		return decimals;
		
	}
	
	public int rgDivision(int decimals) {
		
		String number = Integer.toString(decimals);
		
		if(decimals<100 && decimals !=0) {
				
			while(number.length()<3) {
				
				number = ("0"+number);
			}
			
		}
		
		return Integer.parseInt(number);
	} 
	
	public int nbDigit(double x) {
		
		
		return (Integer.toString(getBelowUnit(x))).length();
	}
}



















