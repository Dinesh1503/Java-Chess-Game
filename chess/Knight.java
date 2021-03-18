package chess;

public class Knight extends Piece
{
  // public String nextcol;
  // public Boolean nextbool;
  // public Piece nextpiece;
  public Knight(PieceColour p)
  {
    if(p.name() == "BLACK")
    {
      this.setSymbol("♞");
      this.setColour(PieceColour.BLACK);
    }
    else
    {
      this.setSymbol("♘");
      this.setColour(PieceColour.WHITE);
    }
  }
  // public void passcolourvalue(String col)
  // {
  //   nextcol = col;
  // }
  // public void passbool(Boolean bool)
  // {
  //   nextbool = bool;
  // }
  // public void passpiece(Piece p)
  // {
  //   if(nextbool == true)
  //   {
  //     nextpiece = p;
  //   }
  // }
  public boolean isLegitMove(int i, int j, int k, int l)
	{
    if(Board.hasPiece(k,l) == true)
    {
      if(this.getColour() != Board.getPiece(k,l).getColour())
      {
        if((k-i == 1 || i-k == 1) && (j-l == 2 || l-j == 2))
        {
          return true;
        }
        else if((k-i == 2 || i-k == 2) && (j-l == 1 || l-j == 1 ))
        {
          return true;
        }
        else
        {
          return false;
        }
      }
      else
        return false;
    }
    else
    {
      if((k-i == 1 || i-k == 1) && (j-l == 2 || l-j == 2))
      {
        return true;
      }
      else if((k-i == 2 || i-k == 2) && (j-l == 1 || l-j == 1 ))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
  }
}
