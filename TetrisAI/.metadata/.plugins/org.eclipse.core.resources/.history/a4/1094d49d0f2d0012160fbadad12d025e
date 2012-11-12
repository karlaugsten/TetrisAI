package integration;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tetrisconnector.CommandChannel;
import tetrisconnector.MoveCommand;
import tetrisconnector.PieceStateResp;
import tetrisconnector.Response;
import tetrisconnector.BoardStateResp;

public class Communicator {
	
	private Lock lock = new ReentrantLock();
	
	private int[] boardstate = new int[20];
	private int[] oppboardstate = new int[20];
	
	private int pieceRow;
	private int pieceColumn;
	private String piece = null;
	private int pieceOrient;
	
	private String[] pieceQueue = new String[5];
	
	private CommandChannel sender;
	private String clienttoken;
	
	public Communicator(CommandChannel channel, String clienttoken){
		sender = channel;
		this.clienttoken = clienttoken;
		
	}
	
	public void movePiece(String m){
		MoveCommand move = new MoveCommand(m,clienttoken);
		sender.queueCommand(move);
	}
	
	public void putResponse(Response r){
		if(r instanceof BoardStateResp){
			//here we should check if they are different, and if true update;
			updateBoardState((BoardStateResp) r);
		}else if(r instanceof PieceStateResp){
			updatePieceState((PieceStateResp) r);
		}
	}
	
	public void updatePieceState(PieceStateResp p){
		lock.lock();
		this.pieceRow = p.getPieceRow();
		this.piece = p.getPiece();
		this.pieceColumn = p.getPieceColumn();
		this.pieceOrient = p.getPieceOrient();
		this.pieceQueue = p.getPiecequeue();
		lock.unlock();
	}
	
	public void updateBoardState(BoardStateResp b){
		lock.lock();
		String ourboard = b.getBoardState();
		String theirboard = b.getOppBoardState();
		boolean shift = true;
		int mask = 0x3FF;
		for(int i = 0; i < 20; i++){
			int from = (int)(2.5*(double)i);
			int to = (int) Math.ceil(2.5*(i+1));
			String row = ourboard.substring(from,to);
			String opprow = theirboard.substring(from,to);
			
			if(shift){
				boardstate[i] = ((int)Integer.parseInt(row.toUpperCase(),16)) >> 2;
				oppboardstate[i] = ((int)Integer.parseInt(opprow.toUpperCase(),16)) >> 2;
				shift = false;
			}else{
				boardstate[i] = ((int)Integer.parseInt(row.toUpperCase(),16));
				oppboardstate[i] = ((int)Integer.parseInt(opprow.toUpperCase(),16));
				boardstate[i] &= mask;
				oppboardstate[i] &= mask;
				shift = true;
			}
		}
		lock.unlock();
	}
	
	public int[] getBoardState(){
		lock.lock();
		int[] ret = boardstate.clone();
		lock.unlock();
		return ret;
	}
	
	public int[] getOpponentBoardState(){
		lock.lock();
		int[] ret = oppboardstate.clone();
		lock.unlock();
		return ret;
	}

	public int getPieceRow() {
		lock.lock();
		int ret = pieceRow;
		lock.unlock();
		return ret;
	}

	public int getPieceColumn() {
		lock.lock();
		int ret = pieceColumn;
		lock.unlock();
		return ret;
	}

	public String getPiece() {
		lock.lock();
		String ret = piece;
		lock.unlock();
		return ret;
	}

	public int getPieceOrient() {
		lock.lock();
		int ret = pieceOrient;
		lock.unlock();
		return ret;
	}

	public String[] getPieceQueue() {
		lock.lock();
		String[] ret = pieceQueue;
		lock.unlock();
		return ret;
	}

}
