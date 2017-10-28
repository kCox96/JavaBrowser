//Kiana cox
//150346658
//08/05/2017

//----This class reads the history text file----
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class HistoryBox extends JComboBox{
	
	public Scanner doc;
//----HistoryBox constructor----
	public HistoryBox() {
		open();
		read();
	}
//----opens history text file----
	public void open() {
		try {
			FileReader source = new FileReader("history.txt");
			doc = new Scanner(source);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(getRootPane(), "File Invalid.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}
	}
//----reads history text file----	
	public void read() {
		while(doc.hasNext()) {
			addItem(doc.nextLine());
		}
	}
}
