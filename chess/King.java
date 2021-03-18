package chess;

public class King extends Piece
{
	King(PieceColour p)
	{
		if(p.name() == "BLACK")
		{
      		this.setSymbol("♚");
  			this.setColour(PieceColour.BLACK);
  		}
    	else
    	{
      		this.setSymbol("♔");
      		this.setColour(PieceColour.WHITE);
      	}
	}

	public boolean isLegitMove(int i, int j, int k, int l)
	{
		if(Board.hasPiece(k,l) == true)
		{
			if(this.getColour() != Board.getPiece(k,l).getColour())
			{
				if(k - i == 1 || i - k == 1)
					return true;
				else if(l - j == 1 || j - l == 1)
					return true;
				else if((k - i == 1 || i - k == 1) && (l - j == 1 || j - l == 1))
					return true;
				else
					return false;
			}
			else
				return false;
		} 
		else
		{
			if(k - i == 1 || i - k == 1)
				return true;
			else if(l - j == 1 || j - l == 1)
				return true;
			else if((k - i == 1 || i - k == 1) && (l - j == 1 || j - l == 1))
				return true;
			else
				return false;
		}

	}
}
