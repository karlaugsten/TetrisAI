package tetrisconnector;

import org.zeromq.ZMQ;

import integration.Communicator;

public class StateChannel implements Runnable {

	private Communicator com;
	private ZMQ.Socket channel;
	
	public StateChannel(Communicator com, ZMQ.Context c){
		this.com = com;
		channel = c.socket(ZMQ.SUB);
	}
	
	public boolean invoke(String url, String matchtoken){
		channel.connect("tcp://"+url+":5556");
		channel.subscribe(matchtoken.getBytes());
		(new Thread(this)).start();
		return true;
	}
	
	@Override
	public void run() {
		while(true){
			
			byte[] msg = channel.recv(0);
			System.out.println(new String(msg));
		}
		
	}

	
}
