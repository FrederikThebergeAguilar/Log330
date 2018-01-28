package view;


import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MENU_FICHIER_TITRE = "Outils";
	private static final String MENU_FICHIER_CHARGER = "Charger";
	private static final String MENU_FICHIER_VARIANCE = "Variance";
	
	private OutputView panel;
	private File file;
	private FileChoser fc;
	private DataReader dr;
	 
	
	private JMenu outils;
	private JMenuItem charger;
	private JMenuItem variance;

	public Menu(OutputView panel) {
		
		this.panel = panel;
		fc = new FileChoser();
		
		
		outils = new JMenu(MENU_FICHIER_TITRE);
		charger = new JMenuItem(MENU_FICHIER_CHARGER);
		variance = new JMenuItem(MENU_FICHIER_VARIANCE);

		charger.addActionListener((ActionEvent e) -> {
			
			file = fc.getFile();
			System.out.println("fichier charger");
				
		});
		
		variance.addActionListener((ActionEvent e) -> {
				
			if(file!= null) {
				
				dr = new DataReader(file);
				panel.showOnScreen(dr.variance());
			}
			
			else {
				
				 JOptionPane.showMessageDialog(null, "Aucun fichier selectione", "Error ", JOptionPane.ERROR_MESSAGE);					
			}
		});

		outils.add(charger);
		outils.add(variance);

		this.add(outils);
		
	}

}
