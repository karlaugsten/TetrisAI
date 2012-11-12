package tetrisconnector;

import java.text.ParseException;

import org.json.JSONObject;
import org.zeromq.ZMQ;

import integration.Communicator;

public class StateChannel implements Runnable {

	private Communicator com;
	private ZMQ.Socket channel;
	private String matchtoken;
	
	public StateChannel(Communicator com, ZMQ.Context c){
		this.com = com;
		channel = c.socket(ZMQ.SUB);
	}
	
	public boolean invoke(String url, String matchtoken){
		this.matchtoken = matchtoken;
		channel.connect("tcp://"+url+":5556");
		channel.subscribe(matchtoken.getBytes());
		(new Thread(this)).start();
		return true;
	}
	
	@Override
	public void run() {
		while(true){
			
			byte[] msg = channel.recv(0);
			String m = new String(msg);
			if(!m.equals(matchtoken)){
				Response c = processResponse(msg);
				com.putResponse(c);
			}
		}
	}

	public Response processResponse(byte[] message){
		String m = new String(message);
		m = m.replace(matchtoken, "");
		JSONObject o = null;
		try {
			o = new JSONObject(m);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String type = (String) o.get("comm_type");
		if(type.equals("GameBoardState")){
			return new BoardStateResp(o);
		}else if(type.equals("GamePieceState")){
			return new PieceStateResp(o);
		}else if(type.equals("MatchEnd")){
			System.out.println("Match ended with: \n"+o.toString());
			return new Response(o);
		}else if(type.equals("GameEnd")){
			System.out.println("Game ended with: \n"+o.toString());
			return new Response(o);
		}
		else{
			System.out.println("ERROR: State Channel retrieved unknown response!");
			return null;
		}
		
	}
	
}
