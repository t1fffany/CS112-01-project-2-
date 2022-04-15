public class XOPiece
{
    /** enumerated type that dictates the two values of 
      * tic tac toe
      */
    public static enum XO {X, O, Z}
    private XO myXO;
    private String returnString;

    /** Constructor to hold an empty piece 
      * that is neither X or O. An empty 
      * piece should just display 3 spaces
      */
    public XOPiece() 
    {
        myXO =XO.values()[2];
    }

    /** Constructor that creates a piece for 
      * the TicTacToe board -- either an X or O
      * See sample output.
      */
    public XOPiece(XO choice)
    {
        this.myXO=choice;
    }

    public String toString()
    {
        returnString="";
        /* What should your output String look like? */
        returnString+=this.myXO;
        return returnString;
    }

    /** Method that checks if one XOPiece has the same XO value.
      * If the calling object has the same internal XO value as the
      * object sent as a formal parameter.
      */
    public boolean match (XOPiece piece)
    {
        if(this.myXO == piece.myXO)
            return true;
        return false; 
    }
}