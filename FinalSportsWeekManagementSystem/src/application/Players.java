package application;
public class Players 
{
	public static String player_name;
	public static String player_id;
	public static String email;
	public static String address;
	public static String team;
	public static String game;
	
	//Getters Setters
	public Players()
	{
		setPlayer_name ("");
		setPlayer_id("");
		setGame("");
		
	}
	public Players(String name, String id,  String game_name, String email, String address)
	{
		setPlayer_name (name);
		setPlayer_id(id);
		setGame(game_name);
		setEmail(email);
		setAddress(address);
	}

	public static String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		Players.player_name = player_name;
	}
	public static String getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String player_id) {
		Players.player_id = player_id;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		Players.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		Players.address = address;
	}

	public static String getGame() {
		return game;
	}
	public static void setGame(String game) {
		Players.game = game;
	}	
	
}
