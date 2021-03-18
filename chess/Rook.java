package chess;

public class Rook extends Piece
{
  
  public Rook(PieceColour p)
  {
    if(p.name() == "BLACK")
    {
      this.setSymbol("♜");
      this.setColour(PieceColour.BLACK);
    }
    else
    {
      this.setSymbol("♖");
      this.setColour(PieceColour.WHITE);
    }
  }
  public boolean checksideways(int i,int j, int k, int l)
  {
    boolean val = false;
    //up 
    if(i>k && j==l)
    {
      for(int x = 1;x<i; x++)
      {
        if(Board.hasPiece(i-x,j) == true)
        {  
          val = false;
          break;
        }
        else
          val = true;
      }
      return val;
    }
    //down
    else if(i<k && j==l)
    {
      for(int x = 1;x<i; x++)
      {
        if(Board.hasPiece(i+x,j) == true)
        {  
          val = false;
          break;
        }
        else
          val = true;
      }
      return val;
    }
    //left
    else if(i==k && j>l)
    {
      for(int x = 1;x<j; x++)
      {
        if(Board.hasPiece(i,j-x) == true)
        {  
          val = false;
          break;
        }
        else
          val = true;
      }
      return val;
    }
    //right
    else if(i==k && j<l)
    {
      for(int x = 1;x<l; x++)
      {
        if(Board.hasPiece(i,j+x) == true)
        {  
          val = false;
          break;
        }
        else
          val = true;
      }
      return val;
    }
    else
      return false;
  }
  
  public boolean isLegitMove(int i, int j, int k, int l)
	{
    if(Board.hasPiece(k,l) == true)
    {
      if(this.getColour() != Board.getPiece(k,l).getColour())
      {
        if((i-k == 1 && j == l) || (k-i == 1 && j == l) || (j-l == 1 && i == k) || (l-j == 1 && i == k))
          return true;

        else if(j==l || k==i)
          return checksideways(i,j,k,l);
    
        else
          return false;
      }
      else
        return false;
	  }
    else
    {
      if((i-k == 1 && j == l) || (k-i == 1 && j == l) || (j-l == 1 && i == k) || (l-j == 1 && i == k))
          return true;
      
      if(j==l || k==i)
          return checksideways(i, j, k, l);

        else
          return false;
    }

  }
}
