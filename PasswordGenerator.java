import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator
{
	private ArrayList<Character> symbols = new ArrayList<Character>(189);
	private Random random = new Random();
	
	@SuppressWarnings("deprecation")
	PasswordGenerator()
	{
		//likes 33 to 126, 161 to 265
		//included whole range because why not
		//length of symbols is 189, so indices from 0 to 188
		for(int i = 33; i < 266; i++)
		{
			if (((i >= 33) & (i <= 126)) || ((i >= 161) && (i <= 255)))
			{
				symbols.add(new Character((char) i));
			}
		}
	}
	
	public String generate()
	{
		String password = "";
		for (int i = 0; i < 15; i++)
		{
			//nextInt is not inclusive, so 189 is safe (won't throw outofbounds exception)
			password = password + symbols.get(random.nextInt(189)).toString();
		}
		
		return password;
	}
}
