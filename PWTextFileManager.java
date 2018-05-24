import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PWTextFileManager
{
	private String filename;
	private FileWriter fw;
	private BufferedWriter bw;
	private Encoder encoder;
	private FileReader fr;
	private BufferedReader br;
	private HashMap<String, String> mappy;
	private String key;
	
	PWTextFileManager(String input)
	{
		filename = "nataliepw.txt";
		key = input;
		encoder = new Encoder(key);
	}
	
	public HashMap<String, String> getMap()
	{
		return mappy;
	}
	
	public void write(String pw, String ws)
	{
		try
		{
			fw = new FileWriter(filename, true);
			bw = new BufferedWriter(fw);
			bw.append("Website: " + ws + "\n" + "Password: " + encoder.encode(pw) + "\n");
			bw.close();
			fw.close();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public HashMap<String, String> read()
	{
		mappy = new HashMap<String, String>();
		try
		{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			Pattern p = Pattern.compile("^.*: (.*)$");
			String line1;
			String line2;
			while (((line1 = br.readLine()) != null) && ((line2 = br.readLine()) != null))
			{
				Matcher m = p.matcher(line1);
				m.find();
				String website = m.group(1);
				m = p.matcher(line2);
				m.find();
				String password = encoder.decode(m.group(1));
				mappy.put(website, password);
			}
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return mappy;
		
	}
	
}