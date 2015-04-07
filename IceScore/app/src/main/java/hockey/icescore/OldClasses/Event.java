package hockey.icescore.OldClasses;

import java.util.Date;

public class Event
{

    public static int nextID = 0;

    public static int getNextID()
    {
        nextID++;
        return nextID;
    }

    public int eventID;
    public int teamID;
    public Date eventTime;
    public String period;

    public Event(int team, String period)
    {
        eventID = getNextID();
        teamID = team;
        eventTime = new Date();
        this.period = period;
    }
}

