import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PGGUI implements ActionListener
{
	private JFrame window;
	private JTextField pwfield;
	private JPanel bottom;
	private JButton savepw;
	private JButton newpw;
	private PasswordGenerator pwg;
	private String password;
	
	PGGUI()
	{
		pwg = new PasswordGenerator();
		password = pwg.generate();
		display();
	}
	
	public void display()
	{
		window = new JFrame();
		window.setTitle("Password Generator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(300, 200);
		window.setLocation(500, 150);
		window.setLayout(new GridLayout(2, 1));
		
		pwfield = new JTextField();
		pwfield.setText(password);
		pwfield.setEditable(false);
		window.add(pwfield);
		
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 2));
		
		savepw = new JButton();
		savepw.setText("Save Password");
		savepw.addActionListener(this);
		
		newpw = new JButton();
		newpw.setText("New Password");
		newpw.addActionListener(this);
		
		bottom.add(newpw);
		bottom.add(savepw);
		
		window.add(bottom);
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent click)
	{
		JButton source = (JButton)click.getSource();
		if (source == newpw)
		{
			password = pwg.generate();
			pwfield.setText(password);
		}
	}
	
	

}
