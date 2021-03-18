package chess;

import java.io.Console;

import javax.print.DocFlavor.STRING;

public class Game {
	private static boolean gameEnd = false;
	private static String next = "BLACK";
	private static String cur = "WHITE";
	private static int error = 0;

	// For changing turns
	public static void checkturn() 
	{
		if (error == 0) 
		{
			if (cur == "BLACK")
				next = "WHITE";
			else
				next = "BLACK";
		} 
		else 
			next = cur;
	}
 	//For displaying the turns 
	public static void errturn() 
	{
		if (error == 1) 
		{
			System.out.print(" " + cur + "'s TURN");
			play();
		} else
		{
			System.out.println(" " + next + "'s TURN");
		}
	}

	// This method requires your input
	public static void play(){
		while (!gameEnd){
			Console con = System.console();
			String input,move;
			CheckInput p = new CheckInput();
			int pi = 0;
			int pj = 0;
			int mi = 0;
			int mj = 0;
			input = con.readLine("\n Select Piece(eg: 7c): ");
			move = con.readLine(" Enter Move(eg: 5c): ");
			System.out.println("");
			// To check if the coords are valid
			if(p.checkCoordinateValidity(input) == true && p.checkCoordinateValidity(move) == true)
			{
				switch(input.charAt(1))
				{
					case 'a': pj = 0;
										break;
					case 'b':	pj = 1;
										break;
					case 'c':	pj = 2;
										break;
					case 'd':	pj = 3;
										break;
					case 'e': pj = 4;
										break;
					case 'f':	pj = 5;
										break;
					case 'g': pj = 6;
										break;
					case 'h':	pj = 7;
										break;
					default: break;
				}
				switch(input.charAt(0))
				{
					case '1': pi = 0;
										break;
					case '2':	pi = 1;
										break;
					case '3':	pi = 2;
										break;
					case '4':	pi = 3;
										break;
					case '5':	pi = 4;
										break;
					case '6':	pi = 5;
										break;
					case '7': pi = 6;
										break;
					case '8':	pi = 7;
										break;
					default: break;
				}
				switch(move.charAt(1))
				{
					case 'a': mj = 0;
										break;
					case 'b':	mj = 1;
										break;
					case 'c':	mj = 2;
										break;
					case 'd':	mj = 3;
										break;
					case 'e': mj = 4;
										break;
					case 'f':	mj = 5;
										break;
					case 'g': mj = 6;
										break;
					case 'h':	mj = 7;
										break;
					default: break;
				}
				switch(move.charAt(0))
				{
					case '1': mi = 0;
										break;
					case '2':	mi = 1;
										break;
					case '3':	mi = 2;
										break;
					case '4':	mi = 3;
										break;
					case '5':	mi = 4;
										break;
					case '6':	mi = 5;
										break;
					case '7': mi = 6;
										break;
					case '8':	mi = 7;
										break;
					default: break;
				}

				// To check if there is a piece on coords entered by user
				if(Board.hasPiece(pi,pj) == true)
				{
					// To check if the move is legitimet move
					if(Board.getPiece(pi,pj).isLegitMove(pi,pj,mi,mj) == true)
					{
						// To check if any king has been captured/killed to end the game
						if(Board.movePiece(pi,pj,mi,mj,Board.getPiece(pi,pj)) == true)
						{
							Board.printBoard();
							gameEnd = true;
							error = 0;
							checkturn();
							errturn();
						}
						// To print the board otherwise 
						else
						{
							Board.printBoard();
							error = 0;
							checkturn();
							errturn();
						}
					}
					// False since the move is not legitimate
					else
					{
						System.out.println("Invalid Move");
						error = 1;
						checkturn();
						errturn();
					}

				}
				// False since there is no piece on the coords entered by the user 
				else
				{
					System.out.println(" Invalid Piece");
					error = 1;
					checkturn();
					errturn();
				}			
			}
			// wrong coords enterd by the user for piece and move
			else if(p.checkCoordinateValidity(input) == false && p.checkCoordinateValidity(move) == false)
			{
				System.out.println(" Invalid Piece or Invalid Move");
				error = 1;
				checkturn();
				errturn();
			}	
			// wrong coords enterd by the user for piece 
			else if(p.checkCoordinateValidity(input) == false)
			{
				
				System.out.println(" Invalid Piece");
				error = 1;
				checkturn();
				errturn();
			}
			// wrong coords enterd by the user for move
			else
			{
				System.out.println(" Invalid Move");
				error = 1;
				checkturn();
				errturn();
			}

		}
			
	}

	// This method should not be edited
	public static void main(String args[]) {
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();
	}
}
