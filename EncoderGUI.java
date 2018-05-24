import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EncoderGUI implements ActionListener
{
	private JFrame window;
	private JButton generate;
	private JButton retrieve;
	
	public EncoderGUI()
	{
		display();
	}
	
	public void display()
	{
		window = new JFrame();
		window.setTitle("Natalie's Awesome Password Manager");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 250);
		window.setLocation(500, 150);
		window.setLayout(new GridLayout(2,1));
		
		JLabel choose = new JLabel("What would you like to do?");
		choose.setHorizontalAlignment(JLabel.CENTER);
		Font myfont = new Font("Candara", Font.BOLD, 30);
		choose.setFont(myfont);
		window.add(choose);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(1,2));
		
		generate = new JButton("Generate");
		generate.setFont(myfont);
		generate.addActionListener(this);
		lowerPanel.add(generate);
		
		retrieve = new JButton("Retrieve");
		retrieve.setFont(myfont);
		retrieve.addActionListener(this);
		lowerPanel.add(retrieve);
		
		window.add(lowerPanel);
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent click)
	{
		JButton source = (JButton)click.getSource();
		if (source == generate)
		{
			new PGGUI();	
		}
		else
		{
			String key = JOptionPane.showInputDialog("Password:");
			HashMap<String, String> mappy = (new PWTextFileManager(key)).read();
		}
	}
}
