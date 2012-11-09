package game;

public class Run {

	/**
	 * Main function which will setup match
	 */
	public static void main(String[] args) {
		Connection c = new Connection();
		String matchtoken = "99da22f4-71ea-4eff-a5de-079fd7db6148";
		String url = "ec2-50-19-179-117.compute-1.amazonaws.com";
		c.ConnectManual(matchtoken, url);

	}

}
