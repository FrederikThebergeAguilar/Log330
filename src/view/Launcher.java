package view;


public class Launcher {

public static void main(String[] args) {
		
		Thread  t = new Thread(new MainFrame());
		
		t.start();
	}
}
