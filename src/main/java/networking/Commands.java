package networking;

/**
 * A list of text commands which are useful to communicate between the client and server.
 * Having commands stored as variables ensures consistency between classes.
 * @author Chris Cardus
 */
public class Commands {

	public static final String breakOp = "-";

	public static final String stop = "stop";

	public static final String addPlayer = "addPlayer"+breakOp;
    public static final String addPlayerCompare = "addPlayer";

    public static final String health = "health"+breakOp;
    public static final String healthCompare = "health";

    public static final String education = "education"+breakOp;
    public static final String educationCompare = "education";

    public static final String social = "social"+breakOp;
    public static final String socialCompare = "social";

    public static final String money = "money"+breakOp;
    public static final String moneyCompare = "money";

    public static final String energy = "energy"+breakOp;
    public static final String energyCompare = "energy";

    public static final String message = "message"+breakOp;
    public static final String messageCompare = "message";
}
