package com.networking;

/**
 * A list of text commands which are useful to communicate between the client and server.
 * Having commands stored as variables ensures consistency between classes.
 * @author Chris Cardus
 */
public class Commands {

    /**
     * breakOp is used to distinguish between commands.
     */
	public static final String breakOp = "-";

    /**
     * defaultPort is the default port value, which is 29100.
     */
	public static final int defaultPort = 29100;

    /**
     * stop is used to shutdown the server.
     */
	public static final String stop = "stop";

    /**
     * addPlayer is used to add a new player to the game when a new client joins.
     * addPlayerCompare should be used when comparing to parsed strings.
     */
	public static final String addPlayer = "addPlayer"+breakOp;
    public static final String addPlayerCompare = "addPlayer";

    /**
     * health is used to refer to the health attribute of a player.
     * healthCompare should be used when comparing to parsed strings.
     */
    public static final String health = "health"+breakOp;
    public static final String healthCompare = "health";

    /**
     * education is used to refer to the education attribute of a player.
     * educationCompare should be used when comparing to parsed strings.
     */
    public static final String education = "education"+breakOp;
    public static final String educationCompare = "education";

    /**
     * social is used to refer to the social attribute of a player.
     * socialCompare should be used when comparing to parsed strings.
     */
    public static final String social = "social"+breakOp;
    public static final String socialCompare = "social";

    /**
     * money is used to refer to the money attribute of a player.
     * moneyCompare should be used when comparing to parsed strings.
     */
    public static final String money = "money"+breakOp;
    public static final String moneyCompare = "money";

    /**
     * energy is used to refer to the energy attribute of a player.
     * energyCompare should be used when comparing to parsed strings.
     */
    public static final String energy = "energy"+breakOp;
    public static final String energyCompare = "energy";

    /**
     * message is used when the player sends text messages to the server.
     * messageCompare should be used when comparing to parsed strings.
     */
    public static final String message = "message"+breakOp;
    public static final String messageCompare = "message";

    /**
     * position is used to specify a change to a players position.
     * positionCompare should be used when comparing to parsed strings.
     */
    public static final String position = "position"+breakOp;
    public static final String positionCompare = "position";

    public static final String globalPosition = "globalPosition"+breakOp;
    public static final String globalPositionCompare = "globalPosition";

    public static final String userID = "userID"+breakOp;
    public static final String userIDCompare = "userID";
}
