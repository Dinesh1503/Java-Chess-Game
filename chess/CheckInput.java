package chess;

public class CheckInput {

	//This method requires your input
	public boolean checkCoordinateValidity(String input)
	{
		String check0,check1;
		if(input.length() != 2)
		{
			return false;
		}
		else if(input == "")
		{
			return false;
		}
		else
		{
			switch(input.charAt(1))
			{
				case 'a': check0 = "true";
									break;
				case 'b':	check0 = "true";
									break;
				case 'c':	check0 = "true";
									break;
				case 'd':	check0 = "true";
									break;
				case 'e':	check0 = "true";
									break;
				case 'f':	check0 = "true";
									break;
				case 'g': check0 = "true";
									break;
				case 'h': check0 = "true";
									break;
				default: check0 = "false";
								break;
			}
			switch(input.charAt(0))
			{
				case '1': check1 = "true";
									break;
				case '2':	check1 = "true";
									break;
				case '3':	check1 = "true";
									break;
				case '4':	check1 = "true";
									break;
				case '5':	check1 = "true";
									break;
				case '6':	check1 = "true";
									break;
				case '7': check1 = "true";
									break;
				case '8':	check1 = "true";
									break;
				default: check1 = "false";
								break;
			}
			if(check0 == "true" && check1 == "true")
				return true;
			else
				return false;
		}	
	}
}
