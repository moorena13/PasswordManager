import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FetchGUI implements ActionListener
{
	private JFrame window;
	private JTextField pwfield;
	private JComboBox<String> choices;
	private PWTextFileManager pwtfm;
	private HashMap<String, String> mappy;
	private String[] passwords;
	
	FetchGUI(String key)
	{
		pwtfm = new PWTextFileManager(key);
		mappy = pwtfm.read();
		passwords = (mappy.keySet()).toArray(new String[0]);
		display();
	}
	
	public void display()
	{
		window = new JFrame();
		window.setTitle("Retrieve Password");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(300, 200);
		window.setLocation(500, 250);
		window.setLayout(new GridLayout(2, 1));
		
		choices = new JComboBox<String>(passwords);
		choices.addActionListener(this);
		window.add(choices);
		
		pwfield = new JTextField();
		pwfield.setEditable(false);
		window.add(pwfield);	
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent click)
	{
		String choice = choices.getSelectedItem().toString();
		String result = mappy.get(choice);
		pwfield.setText(result);
	}
}

