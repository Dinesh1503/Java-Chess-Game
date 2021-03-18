package chess;

public class Queen extends Piece
{
  public Queen(PieceColour p)
  {
    if(p.name() == "BLACK")
    {
      this.setSymbol("♛");
      this.setColour(PieceColour.BLACK);
    }
    else
    {
      this.setSymbol("♕");
      this.setColour(PieceColour.WHITE);
    }
  }

  // To check if there is any piece on the trajectory of the piece (when queen moves crossways)
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

  // To check if there is any piece on the trajectory of the piece (when queen moves up/down/left/right)
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
    // If there is a piece on the destination coords entered by the user
    if(Board.hasPiece(k,l) == true)
    {
      // If the queen wants to kill another piece it should not be of the same colour as the queen
      if(this.getColour() != Board.getPiece(k,l).getColour())
      {
        //  valid if queen wants to move one step sideways(up/down/left/right)
        if((i-k == 1 && j == l) || (k-i == 1 && j == l) || (j-l == 1 && i == k) || (l-j == 1 && i == k))
          return true;

        // valid if queen wants to only one step crossways
        else if((i-k == 1 || k-i == 1 ) && (j-l == 1 || l-j == 1))
          return true;

        // valid if queen wants to move sideways(up/down/left/right)
        else if(j==l || k==i)
          return checksideways(i, j, k, l);
        
        // valid if queen wants to move crossways(like bishop)
        else if((i-k == j-l) || (k-i == l-j) || (k-i == j-l) || (i-k == l-j))
          return checkcross(i, j, k, l);

        // False if all the above conditions do not satisfy
        else
          return false;
      }
      // Fasle since the pieces are of same colour
      else
        return false;

    }
    else
    {
      // valid if queen wants to move sideways(up/down/left/right)
      if(j==l || k==i)
        return checksideways(i, j, k, l);
      // valid if queen wants to move crossways(like bishop)
      else if((i-k == j-l) || (k-i == l-j) || (k-i == j-l) || (i-k == l-j))
        return checkcross(i, j, k, l);
      // False since the above condtions do not satisfy
      else
        return false;

    }
	}
}
