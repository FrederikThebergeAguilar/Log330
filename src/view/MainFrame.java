package view;



import java.awt.BorderLayout;

import javax.swing.JFrame;



public class MainFrame extends JFrame implements Runnable{

	
	private static final long serialVersionUID = 1L;
	private Menu menu;	
	private OutputView oView;

	public MainFrame() {
		
		initComp();
		setJMenuBar(menu);
		setLayout(new BorderLayout());
		add(oView);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);	
	}
	
	private void initComp(){
		
		oView = new OutputView();
		menu = new Menu(oView);
				
	}



	@Override
	public void run() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);		
		this.setVisible(true);
		
	}
}
