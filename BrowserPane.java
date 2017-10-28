//Kiana cox
//150346658
//08/05/2017

//----This class creates the browser pane and contains all the methods the action listeners in Toolbar call----
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
//import javax.swing.ScrollPaneConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BrowserPane extends JFrame {
	// ----pane variable----
	private JEditorPane browserPane;
	// ----homepage variable----
	private URL home;
	// ----backList variable----
	private List<String> backPageList = new ArrayList<String>();
	// ----forwardList variable----
	private List<String> forwardPageList = new ArrayList<String>();

	// ----address bar variable----
	public JTextField address;

	// ----browserPane constructor----
	public BrowserPane() {
		// super();

		// ----add homepage to history----
		try {

			home = new URL("http://google.com");
			setHistory(home.toString());
		} catch (MalformedURLException e2) {
			// ----shows this message if URL is invalid----
			JOptionPane.showMessageDialog(rootPane, "Invalid URL.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			// ----sets homepage to google----
			setBrowserPane(new JEditorPane(home));

			// ----adds homepage to backList----
			backPageList.add(home.toString());
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		// ----makes hyperlinks displayed in browserPane clickable----
		getBrowserPane().setEditable(false);
		getBrowserPane().addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					// ----load method----
					loadContent(e.getURL().toString());
				}
			}
		});

		try {
			// ----wraps BrowserPane in scroll pane----
			getContentPane().add(new JScrollPane(getBrowserPane()), BorderLayout.CENTER);

			setSize(640, 480);
			setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "There's been an error.", "Loading error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// ----writes history to a text file----
	public void setHistory(String url) {
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream("history.txt", true));
			// ----prints URL to history file----
			output.println(url);
			output.close();
		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(rootPane, "No URLs to be found.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ----displays url history in a JFrame----
	public void getHistory() {
		HistoryBox historyBox = new HistoryBox();

		HistoryDisplay display = new HistoryDisplay(historyBox);
		display.setVisible(true);
	}

	// ----loads URL typed in by user----
	public void loadContent(String userText) {
		try {
			// ----adds user URL to backList and history file----
			backPageList.add(userText);
			setHistory(userText);
			// ----sets browserPane to user URL----
			getBrowserPane().setPage(userText);
			address.setText(userText);
			String x = "";
			int s = 0;
			for (int i = 0; i < backPageList.size(); i++) {
				x += backPageList.get(i);
				s = i;
			}
			//System.out.println("iteration " + s + "list " + x);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Invalid URL.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ----refreshes current page by reloading the current URL----
	public void refresh() {
		URL currentPage = getBrowserPane().getPage();
		String pageString = currentPage.toString();
		loadContent(pageString);

	}

	// ----takes user back to previous page----
	public void actionBack() {
		forwardPageList.add(backPageList.get(backPageList.size() - 1));
		backPageList.remove(backPageList.size() - 1);
		try {
			// ----loads second last entry in backPageList into browserPane and
			// address bar. Also adds this URL to history file----
			getBrowserPane().setPage(backPageList.get(backPageList.size() - 1));
			address.setText(backPageList.get(backPageList.size() - 1));
			setHistory(backPageList.get(backPageList.size() - 1));
		} catch (IOException e) {

			JOptionPane.showMessageDialog(rootPane, "No urls to be found.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ----takes user forward by one page----
	public void actionForward() {
		// ----creates string from second last entry in forwardList----
		String url = forwardPageList.get(forwardPageList.size() - 1);

		System.out.println("forward " + url);
		System.out.println(url);
		forwardPageList.remove(forwardPageList.size() - 1);
		backPageList.add(url);
		try {
			// ----loads url string into browser pane and address bar. Also adds
			// this URL to history file----
			getBrowserPane().setPage(url);
			address.setText(url);
			setHistory(url);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(rootPane, "No urls to be found.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ----takes user to homepage----
	void homePage() {
		try {
			// ----sets home url to google and loads this into browserPane and
			// address bar when user clicks homebutton----
			home = new URL("https://www.google.co.uk");
			getBrowserPane().setPage(home);
			address.setText("https://www.google.co.uk");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(rootPane, "Invalid URL.", "Loading error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ----getters and setters for browserPane----
	public JEditorPane getBrowserPane() {
		return browserPane;
	}

	public void setBrowserPane(JEditorPane browserPane) {
		this.browserPane = browserPane;
	}
}
