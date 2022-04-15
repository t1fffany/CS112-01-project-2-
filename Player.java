import java.util.Scanner;
public class Player{
	private String name;
	private int timesPlayed;
	private XOPiece gamePiece;



	public Player(String pName, XOPiece pGamePiece){
		this.name= pName;
		this.gamePiece= pGamePiece; 
		timesPlayed+=1;
	}

	public XOPiece getGamePiece(){

 	return this.gamePiece;
	}
	public String getPlayerName(){
	return this.name;
	}
	



}