package tetrisconnector;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.json.JSONObject;
import org.zeromq.ZMQ;

public class CommandChannel implements Runnable{
	
	private ZMQ.Socket channel;
	private Queue<Command> queue;
	private Lock qMutex;
	private Condition empty;
	private String clienttoken = null;
	
	public CommandChannel(ZMQ.Context c){
		channel = c.socket(ZMQ.REQ);
		queue = new LinkedList<Command>();
		qMutex = new ReentrantLock();
		empty = qMutex.newCondition();
	}
	
	/**
	 * Starts this channel and connects to the specified url
	 * @param url The url of the server to connect to.
	 * @return True if the connection was successful.
	 */
	public boolean invoke(String url){
		channel.connect("tcp://"+url+":5557");
		(new Thread(this)).start();
		return true;
	}
	
	/**
	 * This will be the command channel thread running constantly posting commands... etc
	 */
	@Override
	public void run() {
		while(true){
			qMutex.lock();
			if(queue.isEmpty()){
				try {
					empty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Command c = queue.poll();
			qMutex.unlock();
			
			channel.send(c.getBytes(),0);
			// TODO: Here we will have to check if the response is "ok" to make sure it was sent.
			String resp = new String(channel.recv(0));
			System.out.println(resp);
			JSONObject obj = null;
			try {
				obj = new JSONObject(resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(obj.getString("comm_type").equals("MatchConnectResp")){
				setClienttoken(obj.getString("client_token"));
			}
			
			
		}
		
	}
	
	/**
	 * This method will queue a command to send to the server, it also 
	 * will signal this thread if the queue was empty.
	 * @param c The command to be queued.
	 */
	public void queueCommand(Command c){
		qMutex.lock();
		queue.add(c);
		empty.signal();
		qMutex.unlock();
		
	}

	public String getClienttoken() {
		return clienttoken;
	}

	public void setClienttoken(String clienttoken) {
		this.clienttoken = clienttoken;
	}
	
}
