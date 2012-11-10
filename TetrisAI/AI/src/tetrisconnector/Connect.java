package tetrisconnector;

import integration.Communicator;

import org.zeromq.ZMQ;

public class Connect {

	/**
	 * TODO: generate initialization
	 */
	public Connect(){}
	
	/**
	 * Method to manually connect to test server using 
	 * Match token and server url.
	 * @return True if connection was successful.
	 */
	public boolean ConnectManual(String matchtoken, String url){
		ZMQ.Context context = ZMQ.context(1);
		
		CommandChannel cChannel = new CommandChannel(context);
		StateChannel sChannel = new StateChannel(new Communicator(),context);
		
		
		Command connect = new MatchConnectCommand(matchtoken);
		cChannel.invoke(url);
		cChannel.queueCommand(connect);
		sChannel.invoke(url,matchtoken);
		
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	/**
	 * Method which will automatically connect to test server
	 * using an http post.
	 *
	 * @return True if connection was successful.
	 */
	public boolean ConnectAuto(){
		/*
		ZMQ.Context context = ZMQ.context(1);
		ZMQ.Socket http = context.socket(ZMQ.SUB);
		http.
		http.bind("http://condingcontest.pason.com/scheduler/create_unauthenticated_test_match?team_name=Team%20112&password=castlemountain:80");
		byte[] response = http.recv(0);
		System.out.println(new String(response));
		*/
		return true;
	}
	
	
}
