package game_Manager;

import java.util.ArrayList;

public class GameManager {

	//ArrayList<User> players = ArrayList<User>();
	//GameServer server = new GameServer();
	private int CurrentRound = 0;
	private  final int MaxRounds = 7;
	private ArrayList<Integer> PlayerScores;
	private String FirstPlayerMove = new String();
	private String SecondPlayerMove = new String();
	private Integer FirstPlayerBet = null;
	private Integer SecondPlayerBet = null;
	private Integer player1Score = null; // these are the overall scores
	private Integer player2Score = null;
	
	//below are the turn scores, AKA: how many bids are won
	private Integer player1turnscore = null;
	private Integer player2turnscore = null;
	
	
	
	private ArrayList<Integer> TurnScores = new ArrayList<Integer>();
	private final Integer maxTurns = 13;
	private Integer currentTurn = 0;	
	
	public GameManager(/*User player1, User player2, GameServer server*/)
	{
		//Basic constructor that allows for the game manager to know the players and the server
		// while setting up the basic information needed for containing a round
		
		//players.add(player1);
		//players.add(player2);
		//this.server = server;
		CurrentRound = 0;
		PlayerScores = new ArrayList<Integer>();
		currentTurn = 0; 
	}
	
	public void ReceiveMove(/*User player, BoardGameData data*/)
	{
		
		//Essentially a two way setter for the moves of the players,
		// at the beginning of a turn both moves will be set to null,
		// if firstplayermove is null and this is called then obviously 
		// it is the first players move and if not null, then it is obviously the second players 
		
		if(FirstPlayerMove == null)
		{
			//FirstPlayerMove = data.ChosenMove;
			System.out.println("First Player's Move Received");
			
		}else if(FirstPlayerMove != null)
		{
			//SecondPlayerMove = data.ChosenMove;
			System.out.println("Second Player's Move Received");
		}
	}
	
	public String SendMove()
	{
		
		//Sends a move to the Server communication, So what it will determine when called is it
		// will check to ensure what move is to be sent, if there is no received move it will 
		// send an error instead, it should return a string either way.
		
		if(FirstPlayerMove != null && SecondPlayerMove == null)
		{
			return FirstPlayerMove;
		} else if(SecondPlayerMove != null)
		{
			return SecondPlayerMove;
		}else
			return "ERROR: NO PLAYER MOVES HAVE BEEN STORED!!!";
	}
	
	public void receiveBet(/*BoardGameData data*/)
	{
		//Similar to the receiving of a move, the boardGameData will hold the players current
		//bet regardless of whose turn it is. However, due to the fact that a new round has a new
		// bet each time, it will be null before this is called. And we can set the FirstPlayer to play
		// at the beginning of each round and associate the first player bet with that player
	
		if(FirstPlayerBet == null)
	{
		//FirstPlayerBet = data.currentBet;
		System.out.println("First Player's Bet Received");
		
	}else if(FirstPlayerMove != null)
	{
		//SecondPlayerBet = data.currentBet;
		System.out.println("Second Player's Bet Received");
	}
	}
	
	
	public Integer sendBet() 
	{
		//Sends a Bet to the Server communication, So what it will determine when called is it
		// will check to ensure what bet is to be sent. Similar to the move being sent 
		
		if(FirstPlayerBet != null && SecondPlayerBet == null)
		{
			return FirstPlayerBet;
		} else if(SecondPlayerBet != null)
		{
			return SecondPlayerBet;
		}else
			 return null;
	}
	
	//WE HAVE RECEIVE PLAYERS HERE, BUT I FIGURE THAT WE CAN JUST HAVE A CONSTRUCTOR THAT INTAKES
	// PLAYERS AS IT WOULD MAKE MORE SENSE, SINCE IT WOULD NOT BE A GAMEMANAGER BUT SERVER WHO WOULD DO MATCHMAKING? 
	
	/*public String SendScoreRoundEnd()
	{
		return players[0] + " 's Score: " + player1Score + ", " + players[1] + "'s Score: " + player2Score;
	}*/
	
	public void StartRound()
	{
		CurrentRound++;
		FirstPlayerBet = null;
		FirstPlayerMove = null;
		player1turnscore = null;
		SecondPlayerBet = null;
		SecondPlayerMove = null;
		player2turnscore = null;
		
		
		//Here is where we would reques the 
		// bet from first player1, and then player2
		
		
	}
	
	private void calculateTurnEnd()
	{
		//calculate that the current turn has come to an end and increment
		currentTurn++;
		
		//This is where it gets tricky because I need to know how we are storing moves,
		// if we are storing it in a comma delimited string then i know that i can go ahead
		// and parse it to where play[0] is the suit and play[1] is the numeric value
	
		
		if(FirstPlayerMove != null && SecondPlayerMove != null)
		{
			String firstSuit = "suit of first player";
			String firstValue = "value of first player";
			String secondSuit = "suit of second player";
			String secondValue = "value of second player";
			
			if(firstSuit.contentEquals(secondSuit))
			{
				//If they are both the same suit, high card
				if(Integer.parseInt(firstValue) > Integer.parseInt(secondValue))
				{
					player1turnscore++;
				}else
					player2turnscore++;
			}else if(!firstSuit.contentEquals(secondSuit))
			{ // This is the not so tricky part. if there is a spade in the values of the suit then i must determine who played the spade
				
				if(secondSuit.contentEquals("spade"))
				{
					player2turnscore++;
				}else
					player1turnscore++;
				
			}
			
			
			
			
		}
		//at the end of each turn we reset the moves to null; 
		FirstPlayerMove = null;
		SecondPlayerMove = null;
		
		if(currentTurn == maxTurns)
		{
		
			StartRound();
		}
		
	}
	
	
	public void calculateRoundScore()
	{
		
		
		//if the first player ends up overbidding, they lose the difference in their actual score and bet
		if(player1turnscore < FirstPlayerBet)
		{
			player1Score += (player1turnscore - FirstPlayerBet) * 10;
		}else //however if the first player bets equal to or over their total turnscore, then they gain their bet
		{
			player1Score += FirstPlayerBet * 10;
		}
		
		if(player2turnscore < SecondPlayerBet)
		{
			player2Score += (player1turnscore - SecondPlayerBet) * 10;	
		}else
		{
			player2Score += SecondPlayerBet * 10;
		}
		
		if(CurrentRound == MaxRounds)
		{
			determineWinner();
		}
	}
	
	public String determineWinner()
	{
		//at the end of the seven rounds whomever has the higher score will be declared
		// the winner of the game
		if(player1Score > player2Score)
		{
//			return player[0].username + " WINS!";
		}else if( player1Score < player2Score)
		{
//			return player[1].username + " WINS!";
		}else if (player1Score == player2Score)
		{
			return "IT'S A DRAW!";
		}
	
		
	}
	
	
}
