package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 01-Apr-15.
 */
public class GamePersonAction
{
    protected long id;
    protected long personId;
    protected long actionId;
    protected long teamId;
    protected long periodId;
    protected long gameId;
    protected String timestamp;

    public GamePersonAction()
    {
    }

    public GamePersonAction(long pId, long aId, long tId,
                            long periodId, long gId, String timestamp)
    {
        this.personId = pId;
        this.actionId = aId;
        this.teamId = tId;
        this.periodId = periodId;
        this.gameId = gId;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
