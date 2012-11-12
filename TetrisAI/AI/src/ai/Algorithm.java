package ai;

import integration.Communicator;

public class Algorithm 
{
	private Communicator c;

	/**
	 * Create a new Algorithm Class
	 * Pass in Communicator object
	 * @param c
	 */
	public Algorithm(Communicator c)
	{
			this.c = c;
	}
	
	public void start()
	{
		String Tetrimino = c.getPiece();
		GetBestPosition(Tetrimino);
	}
	
	public void GetBestPosition(String Tetrimino)
	{
		if(Tetrimino.equals("O"))
		{
			//Only one possible Orientation
			//Do Algorithm Once
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
			int[] tempBoardState = c.getBoardState();
			
			
			
			
		}
		else if(Tetrimino.equals("I"))
		{
			//Two possible Orientations
			//Do Algorithm Twice
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
			
		}
		else if(Tetrimino.equals("S"))
		{
			//Two possible Orientations
			//Do Algortihm Twice
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
		}
		else if(Tetrimino.equals("Z"))
		{
			//Two possible Orientations
			//Do Algorithm Twice
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
		}
		else if(Tetrimino.equals("L"))
		{
			//Four possible Orientations
			//Call Algorithm Four times
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
		}
		else if(Tetrimino.equals("J"))
		{
			//Four possible Orientations
			//Call Algorithm Four times
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
		}
		else if(Tetrimino.equals("T"))
		{
			//Four possible Orientations
			//Call Algorithm Four times
			Tetrimino = new O(c.getPieceOrient, c.getPieceColumn, c.getPieceRow);
		}
		
	}
	
	
	
	
}
