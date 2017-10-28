//Kiana cox
//150346658
//08/05/2017

//----This class creates the history JFrame----
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class HistoryDisplay extends JFrame{
//----HistoryDisplay constructor
	public HistoryDisplay(HistoryBox historyBox) {
		pack();
		setSize(640,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(historyBox), BorderLayout.CENTER);
	}
}
