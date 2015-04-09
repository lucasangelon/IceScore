package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 09-Apr-15.
 */
public class GamePersonActionGoal
{
    protected long id;
    protected long gamePersonActionId;
    protected long goalieId;
    protected long assistId;
    protected long assist2Id;

    public GamePersonActionGoal(long gid, long asid, long as2id)
    {
        this.goalieId = gid;
        this.assistId = asid;
        this.assist2Id = as2id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGamePersonActionId() { return gamePersonActionId; }

    public void setGamePersonActionId(long gamePersonActionId) { this.gamePersonActionId = gamePersonActionId; }

    public long getGoalieId() { return goalieId; }

    public void setGoalieId(long goalieId) { this.goalieId = goalieId; }

    public long getAssistId() { return assistId; }

    public void setAssistId(long assistId) { this.assistId = assistId; }

    public long getAssist2Id() { return assist2Id; }

    public void setAssist2Id(long assist2Id) { this.assist2Id = assist2Id; }
}
