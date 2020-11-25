package game_Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import ocsf.server.ConnectionToClient;
import server.GameServer;
import server.serverdata.BoardGameData;
import server.serverdata.UserData;

public class GameManager {

	GameServer server = new GameServer();
	
	
	private final ArrayList<String> OGDeck = new ArrayList<String>( Arrays.asList("C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13", "D14"
			,"H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "H14", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "S14") );
	 
	private ArrayList<String> playingDeck = new ArrayList<String>();
	
	private int CurrentRound = 0;
	private  final int MaxRounds = 7;
	private ArrayList<UserData> players;
	private ConnectionToClient player1connection = null;
	private ConnectionToClient player2connection = null;
	private ArrayList<Integer> PlayerScores;
	private String FirstPlayerMove = new String();
	private String SecondPlayerMove = new String();
	private Integer FirstPlayerBet = null;
	private Integer SecondPlayerBet = null;
	private UserData player1 = null;
	private UserData player2 = null;
	private Integer player1Score = null; // these are the overall scores
	private Integer player2Score = null;
	
	
	//below are the blank players hands
	private ArrayList<String> player1Hand = new ArrayList<String>();
	private ArrayList<String> player2Hand = new ArrayList<String>();
	
	
	
	//below are the turn scores, AKA: how many bids are won
	private Integer player1turnscore = null;
	private Integer player2turnscore = null;
	
	
	
	private ArrayList<Integer> TurnScores = new ArrayList<Integer>();
	private final Integer maxTurns = 13;
	private Integer currentTurn = 0;	
	
	
	public GameManager(UserData player1)
	{
		//Basic constructor that allows for the game manager to know the players and the server
		// while setting up the basic information needed for containing a round
		
		this.player1 = player1;
		
		//this.player2 = player2;
		
		CurrentRound = 0;
		PlayerScores = new ArrayList<Integer>();
		currentTurn = 0; 
	}
	public void setPlayer2(UserData player2)
	{
		this.player2 = player2;
	}
	
	public long getPlayer1()
	{
		return player1.getConnectionID();
	}
	
	public long getPlayer2()
	{
		return player2.getConnectionID();
	}
	
	public void ReceiveMove(BoardGameData data)
	{
		
		//Essentially a two way setter for the moves of the players,
		// at the beginning of a turn both moves will be set to null,
		// if firstplayermove is null and this is called then obviously 
		// it is the first players move and if not null, then it is obviously the second players 
		
		if(FirstPlayerMove == null)
		{
			FirstPlayerMove = data.getCurrentMove();
			System.out.println("First Player's Move Received");
			SendMove();
			
		}else if(FirstPlayerMove != null)
		{
			SecondPlayerMove = data.getCurrentMove();
			System.out.println("Second Player's Move Received");
			SendMove();
			calculateTurnEnd();
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
	
	public void receiveBet(BoardGameData data)
	{
		//Similar to the receiving of a move, the boardGameData will hold the players current
		//bet regardless of whose turn it is. However, due to the fact that a new round has a new
		// bet each time, it will be null before this is called. And we can set the FirstPlayer to play
		// at the beginning of each round and associate the first player bet with that player
	
		if(FirstPlayerBet == null)
		{
			FirstPlayerBet = data.getCurrentBet();
			System.out.println("First Player's Bet Received");
			sendBet();
		
		}else if(FirstPlayerMove != null)
		{
			SecondPlayerBet = data.getCurrentBet();
			System.out.println("Second Player's Bet Received");
			sendBet();
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
	
	public String SendScoreRoundEnd()
	{
		return player1.getUsername() + " 's Score: " + player1Score + ", " + player2.getUsername() + "'s Score: " + player2Score;
	}
	
	public void StartRound()
	{
		CurrentRound++;
		FirstPlayerBet = null;
		FirstPlayerMove = null;
		player1turnscore = null;
		SecondPlayerBet = null;
		SecondPlayerMove = null;
		player2turnscore = null;
		playingDeck.clear();
		for(String s : OGDeck)
		{
			playingDeck.add(s);
		}
		Collections.shuffle(playingDeck);
		
		for(int i = 0; i < 12; i++)
		{
		  player1Hand.add(playingDeck.get(i));
		  
		}
		for(int i = 13; i < 26; i++)
		{
			player2Hand.add(playingDeck.get(i));
		}
		
		
		
		//Here is where we would request the 
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
				
				if(secondSuit.contentEquals("S"))
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
			return players.get(0).getUsername() + " WINS!";
		}else if( player1Score < player2Score)
		{
			return players.get(1).getUsername() + " WINS!";
		}else 
		{
			return "IT'S A DRAW!";
		}
	
		
	}
	
	
	public void receiveData(BoardGameData data)
	{
	
		/*
		String purpose = data.getPurpose();
		
		if(purpose.contentEquals("play")
		{
			this.ReceiveMove(data);
		}
		else if (purpose.contentEquals("bet")
		{
			this.ReceiveBet(data);
		}
		*/
	}
	
	
}
