package game;

import org.json.*;

public class MatchConnectCommand implements Command {
	
	private JSONObject Command = new JSONObject();
	private String message;
	private byte[] output;
	
	public MatchConnectCommand(String matchToken){
		Command.put("comm_type","MatchConnect");
		Command.put("match_token", matchToken);
		Command.put("team_name", "Team 112");
		Command.put("password", "castlemountain");
		message = Command.toString();
		output = message.getBytes();
	}
	
	public String getMessage(){
		return message;
	}
	
	public byte[] getBytes(){
		return output;
	}
	
	
}
