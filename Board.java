public class Board {
    private int size;
    private XOPiece[][] board;
    private int timesPlayed=0;
    private XOPiece pieces= new XOPiece(XOPiece.XO.values()[2]);
    private XOPiece xPiece= new XOPiece(XOPiece.XO.values()[0]);
    private XOPiece oPiece= new XOPiece(XOPiece.XO.values()[1]);
    private XOPiece empty= new XOPiece(XOPiece.XO.values()[2]);
    //private XOPiece blank= "   ";

    /**
      * Constructor that creates an n x n board of
      * XOPieces and each XOPiece is set to an initial Token
      */ 
    public Board(int n, XOPiece e) 
    {
        size=n;
        board= new XOPiece [size][size];

          for (int i=0; i<board.length; i++) 
        {
            for (int j=0; j<board[i].length; j++)
            {
                board[i][j]= empty;
            }
        }
        System.out.println();
        timesPlayed+=1;
    }

   /**
     * String representation of the board 
     * showing the contents of each space 
     */
    public String toString()
    {
        String printBoard="";
        for (int i=0; i<board.length; i++) 
        {
            for (int j=0; j<board[i].length; j++)
            {
                if (board[i][j]== empty)
                printBoard+= ("[" + empty + "]");
            else{
                printBoard+= ("["+board[i][j]+"]");
            }
            }
            printBoard+='\n';
        }
        printBoard+='\n';
         return printBoard;
    }

    /**
      * Method that prints out the board with
      * the coordinates of each slot
      * to show the users how to identify each slot
      */
    public void printBoardCoordinates()
    {
        for (int i=0; i<board.length; i++) 
        {
            for (int j=0; j<board[i].length; j++)
            {
                System.out.print("["+i+","+j+"] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // public String updatedBoard()
    // {
    //    for (int i=0; i<board.length; i++) 
    //     {
    //         for (int j=0; j<board[i].length; j++)
    //         {
    //             if (board[i][j]!= empty)
    //                 printBoard+= ("[" + pieces + "]");
    //             else
    //             printBoard+= ("[" + empty + "]");
    //         }
    //         printBoard+='\n';
    //     }
    //     printBoard+='\n';
    //      return printBoard;
    // }

    /**
      * Sets a Token on the board with coordinates (i,j)
      */
    public void setPiece(XOPiece t, int i, int j)
    {
        int row=i;
        int col=j;
        pieces= t;
        XOPiece empty= new XOPiece (XOPiece.XO.values()[2]);
         for (int k=0; k<board.length; k++) 
        {
            for (int l=0; l<board[k].length; l++)
            {
                if (k==row && l==col){
                    board[k][l]= t;
                }
            }
        }
        
    }
        public boolean isValid(int i, int j)
        {
        int row=i;
        int col=j;
        //XOPiece pieces= t;
        //XOPiece empty= new XOPiece (XOPiece.XO.values()[2]);
        boolean canDo=true;
        for (int k=0; k<board.length; k++) 
        {
            for (int l=0; l<board[k].length; l++)
            {
                if (board[i][j]== board[k][l]){
                   if (board[k][l]== empty)
                       {
                        canDo=true;
                        System.out.println("False");
                        break;
                       }
                    else{
                        canDo=false;
                    }
                }
            }
        }
        return canDo;
    }

    /**
      * Gets an item on the board with coordinates (i,j)
      */  
    public XOPiece getPiece(int i, int j)
    {
        XOPiece getPiece=empty;
        int row=i;
        int col=j;

         for (int k=0; k<board.length; k++) 
        {
            for (int l=0; l<board[k].length; l++)
            {
               if (board[i][j]== board[k][l])
               {
                getPiece= board[i][j];
               }
            //    else {
            //     board[k][l]= new XOPiece(XOPiece.XO.values()[2]);
            //     //System.out.println("Boo");
            // }
            }
        }
         return getPiece;
    }

    public int getTimesPlayed(){
        return timesPlayed;
    }



    public XOPiece isWinner(){
        int counter=0;
        XOPiece returnPiece = empty;
        for(int j=0; j<3; j++){ //column
            if (board[0][j]==board[1][j] && board[1][j]== board[2][j] && board[0][j]==xPiece||
                board[0][j]==board[1][j] && board[1][j]== board[2][j]&& board[0][j]==oPiece)
                counter+=1;
            if (counter==3)
             returnPiece= board[0][j];
        }
        counter=0;
        for(int i=0; i<3; i++){//rows
            if (board[i][0]== board[i][1] && board[i][1]== board[i][2] && board[1][0]== xPiece || board[i][0]== 
                board[i][1] && board[i][1]== board[i][2] && board[1][0]== oPiece)
                counter+=1;
            if (counter==3)
                returnPiece= board[i][0];
        }

        if (board[0][0]== board[1][1] && board[1][1]== board[2][2]&& board[0][0]== xPiece || 
            board[0][0]== board[1][1] && board[1][1]== board[2][2]&& board[0][0]== oPiece)
        {
            returnPiece= board[0][0];
        }

        if (board[2][0]== board[1][1] && board[1][1]== board[0][2]&& board[2][0]== xPiece || 
            board[2][0]== board[1][1] && board[1][1]== board[0][2]&& board[2][0]== oPiece)
        {
           returnPiece= board[2][0];
        }

        System.out.println(">>" + returnPiece);
        return returnPiece; 
        
        
// //rows
//         for (i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[i].length - 1; j++) {
//                 matches = (board[i][j].match(board[i][j + 1]) && !(board[i][j].toString().equals("   ")));
//                 if (matches) {
//                     counter++;
//                 }
//                 if (counter == board.length-1) {
//                     return true;
//                 }
//             }
//         counter = 0;
//         }
    }
}

