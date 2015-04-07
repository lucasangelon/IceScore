package hockey.icescore.OldClasses;
public class Goal extends Event
{
    public static int nextGoalID = 0;

    public static int getNextGoalID()
    {
        nextGoalID++;
        return nextGoalID;
    }

    public int goalID;
    public int playerID;
    public int assist1Player;
    public int assist2Player;
    public boolean penaltyShootout;

    public Goal(int team, String period, int playerID, int assist1Player, int assist2Player, boolean penalty)

    {
        super(team,period);
        goalID = getNextGoalID();
        this.playerID = playerID;
        this.assist1Player = assist1Player;
        this.assist2Player = assist2Player;
        penaltyShootout = penalty;
    }
}

