package hockey.icescore.OldClasses;
public class Injury extends Event
{
    public static int nextInjuryID = 0;

    public static int getNextInjuryID()
    {
        nextInjuryID++;
        return nextInjuryID;
    }

    public int injuryID;
    public int playerID;
    public String injuryDescription;

    public Injury(int team, String period, int playerID, String desc)

    {
        super(team,period);
        injuryID = getNextInjuryID();
        this.playerID = playerID;
        injuryDescription = desc;
    }

}
