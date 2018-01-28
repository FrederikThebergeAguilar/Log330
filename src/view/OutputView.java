package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JPanel;

public class OutputView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private TextField text;
	
	public OutputView() {
		
		this.setLayout(new BorderLayout());
		text = new TextField();
		text.setEditable(false);	
		this.add(text,BorderLayout.CENTER);

		String number = Integer.toString(1234);
		
		int pos =2;
		double c = Double.parseDouble(number.substring(0,number.length()-pos)+"."+number.substring(pos));
		
		text.setText(""+c);
	}
	
	
	public void showOnScreen(String variance) {
		
		text.setText(variance);
	}

	
}
