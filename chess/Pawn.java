package chess;

public class Pawn extends Piece
{
	
	public Pawn(PieceColour p)
	{
		if(p.name() == "BLACK")
		{
			this.setSymbol("♟︎");
			this.setColour(PieceColour.BLACK);
		}
		else
		{
			this.setSymbol("♙");
			this.setColour(PieceColour.WHITE);
		}
	}
	
	public boolean isLegitMove(int i, int j, int k, int l)
	{
		if(Board.hasPiece(k,l) == true)
		{
			if(Board.getPiece(i,j).getColour() != Board.getPiece(k,l).getColour())
			{
				if(this.getColour().name() == "WHITE" && i - k == 1 && (l - j == 1 || j - l == 1))
					return true;
				else if (this.getColour().name() == "BLACK" && k - i == 1 && (l - j == 1 || j - l == 1))
					return true;		
				else
					return false;
			}
			else
				return false;
		}
		else if(this.getColour().name() == "WHITE")
		{
			if(i - k == 1 && (j-l == 0 || l-j == 0))
				return true;
			else if(i-k == 2 && i == 6 && (j-l == 0 || l-j == 0))
				return true;
			else
				return false;
		}
		else 
		{
			if(k - i == 1 && (j-l == 0 || l-j == 0))
				return true;
			else if(k - i == 2 && i == 1 && (j-l == 0 || l-j == 0))
				return true;
			else
				return false;
		}
	}
}
