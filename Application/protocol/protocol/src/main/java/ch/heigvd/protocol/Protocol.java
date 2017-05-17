package ch.heigvd.protocol;

import java.util.List;

/**
 * Protocol
 * @author Tony Clavien
 * Define the message exchanged between clients and server
 */
public class Protocol 
{
	
	public static enum FreeRole {
		skier,
		defender
	}
	
	public static enum Direction {
		right,
		left,
		bottom
	}
	
    public static String formatLoginSend(String user, String password) {
    	
    	return "not implemented yet";
    }
    
    public static String getFormatLoginUser(String message) {
    	return "not implemented yet";
    }
    
    public static String getFormatLoginPassword(String message) {
    	return "not implemented yet";
    }
    
    public static String formatLoginAnswer(String token,Difficulty difficulty, MapSize map) {
    	return "not implemented yet";
    }
    
    public static String getFormatLoginToken(String message) {
    	return "not implemented yet";
    }
    
    public static Difficulty getFormatLoginDifficulty(String message) {
    	return null;
    }
    
    public static MapSize getFormatLoginMapSize(String message) {
    	return null;
    }
    
    public static String formatLobbySend(String token) {
    	return "not implemented yet";
    }
    
    public static String getFormatLobbyToken(String message) {
    	return "not implemented yet";
    }
    
    public static String formatLobbyAnswer(int id, String name, String difficulty, String mapSize, FreeRole free) {
    	return "not implemented yet";
    }
    
    public static String getFormatLobbyId(String message) {
    	return "not implemented yet";
    }
    
    public static String getFormatLobbyName(String message) {
    	return "not implemented yet";
    }
    
    public static String getFormatLobbyDifficulty(String message) {
    	return "not implemented yet";
    }
    
    public static String getFormatLobbyMapSize(String message) {
    	return "not implemented yet";
    }
    
    public static FreeRole getFormatLobbyFreeRole(String message) {
    	return null;
    }
    
    public static String formatJoinSend(String token, int id) {
    	return "not implemented yet";
    }
    
    public static String getFormatJoinToken(String message) {
    	return "not implemented yet";
    }
    
    public static String getFormatJoinId(String message) {
    	return "not implemented yet";
    }
    
    public static String formatJoinAnswer(List<FixedObstacle> ls) {
    	return "not implemented yet";
    }
    
    public static List<FixedObstacle> getFormatJoinObstacle(String message) {
    	return null;
    }
    
    public static String formatMoveSend(Direction dir) {
    	return "not implemented yet";
    }
    
    public static Direction getFormatMove(String message) {
    	return null;
    }
    
    public static String formatNewDynamicObstacle(int row) {
    	return "not implemented yet";
    }
    
    // TODO send skier coordinate
    // TODO send new Dynamic obstacle coordinate
}
