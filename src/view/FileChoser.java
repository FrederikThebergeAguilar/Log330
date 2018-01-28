package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChoser {

	public File getFile() {
		
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Sélectionnez un fichier a parser");
		fileChooser.setAcceptAllFileFilterUsed(false);

		int returnValue = fileChooser.showOpenDialog(null);
		
		return (returnValue == JFileChooser.APPROVE_OPTION)?fileChooser.getSelectedFile():null;
		
	}
}
