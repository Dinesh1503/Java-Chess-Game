package chess;

public class Bishop extends Piece
{
  
  public Bishop(PieceColour p)
  {
    if(p.name() == "BLACK")
    {
      this.setSymbol("♝");
      this.setColour(PieceColour.BLACK);
    }
    else
    {
      this.setSymbol("♗");
      this.setColour(PieceColour.WHITE);
    }
  }

 public boolean checkcross(int i, int j, int k,int l)
 {
   boolean val = false;
   //up to left
   if(i>k && j>l)
   {
     for(int x = 1;x<i-k; x++)
     {
       if(Board.hasPiece(i-x,j-x) == true)
         return false;
       else
         val = true;
     }
     return val;
   }
   //up to right
   else if(i>k && j<l)
   {
     for(int x = 1;x<i-k; x++)
     {
       if(Board.hasPiece(i-x,j+x) == true)
         return false;
       else
         val = true;
     }
     return val;
   }
   //down to left
   else if(k>i && j>l)
   {
     for(int x = 1;x<k-i; x++)
     {
       if(Board.hasPiece(i+x,j-x) == true)
         return false;
       else
         val = true;
     }
     return val;
   }
   //down to right
   else if(k>i && j<l)
   {
     for(int x = 1;x<k-i; x++)
     {
       if(Board.hasPiece(i+x,j+x) == true)
         return false;
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
        if((i-k == 1 || k-i == 1) && (j-l == 1 || l-j == 1))
          return true;
        // To check if there is any piece on the trajectory of the piece (when bishop moves crossways)
        else if(i-k == j-l|| i-k==l-j || k-i==j-l || k-i==l-j) 
          return checkcross(i, j, k, l);
          
        else
          return false;
      }
      else
        return false;
    }
    else if((i-k == 1 || k-i == 1) && (j-l == 1 || l-j == 1))
      return true;
    else if(i-k == j-l || i-k==l-j || k-i==j-l || k-i==l-j)
      return checkcross(i, j, k, l);
    else
      return false;
  }
}
