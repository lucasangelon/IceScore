package hockey.icescore.OldClasses;
public class Penalty extends Event
{
    public static int nextPenaltyID = 0;

    public static int getNextPenaltyID()
    {
        nextPenaltyID++;
        return nextPenaltyID;
    }

    public int penaltyID;
    public int playerID;
    public int minutes;
    public String offence;
    public boolean penaltyShootout;

    public Penalty(int team, String period, int playerID, int minutes, String offence, boolean penalty)

    {
        super(team,period);
        penaltyID = getNextPenaltyID();
        this.playerID = playerID;
        this.minutes = minutes;
        this.offence = offence;
        penaltyShootout = penalty;
    }

}
