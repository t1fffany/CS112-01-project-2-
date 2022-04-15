import java.util.Scanner;
import java.util.Random;
public class TicTacToeGame //Driver 
{
    public static void main(String[] args)
    {

        int winPlr1;
        int winPlr2;
        int otherNumber;
        int total = (int) (Math.random()*(1-0)) + 0; //make total randomly 0 or 1 to determine who goes first in line 54/59
        int row;
        int col;
        Random rand = new Random();
        Scanner scnr= new Scanner(System.in);
        int wantPlay=0; 
        XOPiece nothingInside=new XOPiece (XOPiece.XO.values()[2]);
        XOPiece xPiece=new XOPiece (XOPiece.XO.values()[0]);
        XOPiece oPiece=new XOPiece (XOPiece.XO.values()[1]);

        System.out.println("Welcome to the regular game of TicTacToe");
        System.out.println("---------------------------");
        System.out.println("You and a partner will be randomly given a Game Piece.");
        System.out.println("You will select your position on the 3x3 with row and colum indexed");
        System.out.println("When prompted, please enter a ROW and COLUMN index between 0 and 2. THANKS <3");


        int rNumber=rand.nextInt(1);
        if (rNumber==0){
            otherNumber=1;
            //System.out.println("other Number ==1");
        }
        else{
            otherNumber=0;
            //System.out.println("other Number ==0");
        }
        System.out.println("What is player1's name?");
        String player1Name= scnr.next();

        System.out.println("What is player2's name?");
        String player2Name= scnr.next();

        Player player1= new Player(player1Name, new XOPiece (XOPiece.XO.values()[rNumber])); //Later update with rNumber 
        Player player2= new Player(player2Name, new XOPiece (XOPiece.XO.values()[otherNumber])); //Update with otherNumber    

       


        while (wantPlay== 0) {
        //Prints Board with Coordinates and Empty board 
        Board board = new Board(3, new XOPiece());
        board.printBoardCoordinates();
        System.out.println(board);
            while (board.isWinner().match(nothingInside)){
            //Taking turns 
                if (total%2==0){
                System.out.println("Which ROW do you want to place your game Piece, "+ player1.getPlayerName()+"? (Enter 0,1, or 2)");
                row=scnr.nextInt();
                System.out.println("Which COLUMN do you want to place your game Piece, "+ player1.getPlayerName()+"?(Enter 0,1, or 2)");
                col=scnr.nextInt();
                // while (board.getPiece(row,col)== XOPiece.XO.X || board.getPiece(row,col)==XOPiece.XO.O){ //Something in that place 
                //         System.out.println("There is already a game piece in that place");
                //         System.out.println("Which ROW do you want to place your game Piece "+ player1.getPlayerName()+"? (Enter 0,1, or 2)");
                //         row=scnr.nextInt();
                //         System.out.println("Which COLUMN do you want to place your game Piece "+ player1.getPlayerName()+"?(Enter 0,1, or 2)");
                //         col=scnr.nextInt();
                // }
                    while (row <0 || row>2 || col<0 || col>2){
                        System.out.println("The row and column are out of bounds"); 
                        System.out.println("**************");
                        System.out.println();
                        System.out.println("Which ROW do you want to place your game Piece, "+ player1.getPlayerName()+"? (Enter 0,1, or 2)");
                        row=scnr.nextInt();
                        System.out.println("Which COLUMN do you want to place your game Piece, "+ player1.getPlayerName()+"?(Enter 0,1, or 2)");
                        col=scnr.nextInt();
                    }
                    board.isValid(row,col);
                while (board.isValid(row, col)==false){
                        System.out.println("There is a game piece at this index"); 
                        System.out.println("**************");
                        System.out.println();
                        System.out.println("Which ROW do you want to place your game Piece, "+ player1.getPlayerName()+"? (Enter 0,1, or 2)");
                        row=scnr.nextInt();
                        System.out.println("Which COLUMN do you want to place your game Piece, "+ player1.getPlayerName()+"?(Enter 0,1, or 2)");
                        col=scnr.nextInt();
                }
                //Before changing values, you need to make sure there is nothing in that index 
                board.setPiece(player1.getGamePiece(), row, col); //update values ///You need to make sure there is nothing in the set 
                System.out.println(board);
                //System.out.println("GETPIECE METHOD"+board.getPiece(row, col));
                //System.out.print(board.isWinner());
                total+=1; //switch who is being played 
                board.isWinner();
                }
                else{
                System.out.println("Which ROW do you want to place your game Piece, "+ player2.getPlayerName()+"? (0,1, or 2)");
                row=scnr.nextInt();
                System.out.println("Which COLUMN do you want to place your game Piece, "+ player2.getPlayerName()+"?(0,1, or 2)");
                col=scnr.nextInt();

                while (row <0 || row>2 || col<0 || col>2){
                        System.out.println("The row and column are out of bounds"); 
                        System.out.println("**************");
                        System.out.println();
                        System.out.println("Which ROW do you want to place your game Piece, "+ player2.getPlayerName()+"? (Enter 0,1, or 2)");
                        row=scnr.nextInt();
                        System.out.println("Which COLUMN do you want to place your game Piece, "+ player2.getPlayerName()+"?(Enter 0,1, or 2)");
                        col=scnr.nextInt();
                    }
                    board.isValid(row,col);
                while (board.isValid(row, col)==false){
                        System.out.println("There is a game piece at this index"); 
                        System.out.println("**************");
                        System.out.println();
                        System.out.println("Which ROW do you want to place your game Piece, "+ player2.getPlayerName()+"? (Enter 0,1, or 2)");
                        row=scnr.nextInt();
                        System.out.println("Which COLUMN do you want to place your game Piece, "+ player2.getPlayerName()+"?(Enter 0,1, or 2)");
                        col=scnr.nextInt();
                }
                board.printBoardCoordinates();
                board.setPiece(player2.getGamePiece(), row, col);
                System.out.println(board);
                //System.out.print(board.isWinner());
                total+=1;
                board.isWinner();
                }
                if (board.isWinner()==nothingInside){
                    if (total==10){
                        System.out.println("There is a tie. No winner");
                    }
                }
        }
            if (board.isWinner()==xPiece || board.isWinner()==oPiece)
            {
            System.out.println("Person with "+board.isWinner()+ "game piece is the winner");
            
            }
            System.out.println("Do you want to play again? enter 0");
            wantPlay= scnr.nextInt();
            }
            //board.getTimesPlayed();

        }

    }




/* Here is the output for printBoardCoordinates
 * and an empty board 
 * followed by a sample outcome of a finished game
 * FEEL FREE TO CHANGE HOW YOUR OUTPUT LOOKS
 */