//Kiana cox
//150346658
//08/05/2017


//----This class creates the toolbar and adds the button components to it----





import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.JFrame;
public class Toolbar extends JFrame{
	
	
	//----button variables----
	
	private JButton backButton = new JButton("<"), forwardButton = new JButton(">"), homeButton = new JButton("Home"),
			refreshButton = new JButton("Refresh"), history = new JButton("History");
	// public JTextField address;
	// private URL home;

	// ----toolbar constructor----
	public Toolbar() {
		JPanel toolbar = new JPanel();

		// ----create brower pane----
		BrowserPane test = new BrowserPane();

		// ----create action listeners for all components and add said
		// components to toolbar----
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ----call method to take user to homepage when home button is
				// clicked----
				test.homePage();

			}
		});

		toolbar.add(homeButton);

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ----call method to refresh page when refresh button is
				// clicked----
				test.refresh();

			}
		});

		toolbar.add(refreshButton);

		// add(address, BorderLayout.NORTH);

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			// ----call method to take user back to previous page----
			{
				test.actionBack();

			}

		});

		toolbar.add(backButton);
		forwardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ----call method to take user forward----
				test.actionForward();
			}
		});

		toolbar.add(forwardButton);

		test.address = new JTextField("URL goes here", 40);
		test.address.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ----calls method to load address typed into address bar----
				test.loadContent(e.getActionCommand());

			}

		});

		toolbar.add(test.address);
		history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ----calls method to display url history----
				test.getHistory();

			}
		});
		toolbar.add(history);

		// ----add toolbar to top of browser frame----
		test.add(toolbar, BorderLayout.NORTH);

	}
		
	


/* public static void main (String [] args) {
	 Toolbar test1 = new Toolbar();
	 test1.setVisible(true);
 }*/ 
 }
 


