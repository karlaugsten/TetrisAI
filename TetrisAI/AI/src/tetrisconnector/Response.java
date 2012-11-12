package tetrisconnector;

import org.json.JSONObject;

public class Response {
	
	private int sequence;
	private double timestamp;
	private String type;
	private JSONObject message;
	
	public Response(int sequence, double timestamp, String type, JSONObject m){
		
		this.setSequence(sequence);
		this.setTimestamp(timestamp);
		this.setType(type);
		setMessage(m);
	}

	public Response(JSONObject o){
		message = o;
	}
	
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public double getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JSONObject getMessage() {
		return message;
	}

	public void setMessage(JSONObject message) {
		this.message = message;
	}
}
