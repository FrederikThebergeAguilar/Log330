package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import mathresources.MathModule;

public class DataReader {

	private File file;
	private MathModule mm;
	private ArrayList<Integer>  list;
	
	public DataReader(File file) {
		
		this.file = file;
		mm = new MathModule();
		
		list = new ArrayList<Integer>();
		
		System.out.println("start parsing");
		parse();
		System.out.println("end parsing");
	}

	private void parse() {
		
		
		try {
			
			Scanner input = new Scanner(file);
			System.out.println("file in");
			
			String nextLine = input.nextLine();
			while(input.hasNext()){
				
				nextLine = input.nextLine();	
				
				System.out.println(nextLine);
				
				list.add(Integer.parseInt(nextLine));
				
			}
			
			input.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String variance() {
		
		String variance = String.valueOf(mm.variance(list));
				
		String moyenne = String.valueOf(mm.average(list));
		
		String standardDeviation = String.valueOf(mm.standardDeviation(list));
	
		return ("Variance: " +variance +"\n"+"Moyenn: "+moyenne+"\n"+"Standard deviation: "+standardDeviation);
	}
	
	public String showData() {
		
		String str="";
		
		for(int i =0;i<list.size();i++ ) {
			
			str = (str+"\n" + String.valueOf(list.get(i)));
		}
		
		return str;
	}

}
