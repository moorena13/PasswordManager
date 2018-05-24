import java.util.ArrayList;


public class Encoder
{
	public ArrayList<Character> ascii = new ArrayList<Character>(94);
	public ArrayList<Character> newascii = new ArrayList<Character>(94);
	
	Encoder(String s)
	{
		asciiArray();
		newAscii(s);
	}
	
	public void asciiArray()
	{
		for (int i = 33; i < 127; i++)
		{
			ascii.add(new Character((char) i));
		}
	}
	
	public void newAscii(String s)
	{
		for (int i = 0; i < 94; i++)
		{
			newascii.add(ascii.get(i)); 
		}
		
		for (int i = s.length(); i > 0; i--)
		{
			newascii.remove(new Character (s.charAt(i-1)));
			newascii.add(0, s.charAt(i-1));
		}
	}
	
	public String encode(String s)
	{
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			output.append(newascii.get(ascii.indexOf(new Character(s.charAt(i)))));
		}
		return output.toString();
	}
	
	public String decode(String s)
	{
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			output.append(ascii.get(newascii.indexOf(new Character(s.charAt(i)))));
		}
		return output.toString();
	}
	
}
