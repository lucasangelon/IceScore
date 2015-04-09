package hockey.icescore.models;

/**
 * Created by Josh on 7/04/2015.
 */
public class GamePeriod {

    protected long id;
    protected long gameId;
    protected long periodId;
    protected String timestamp;
    protected String periodLength;

    public GamePeriod()
    {
    }

    public GamePeriod(long gId, long pId, String timestamp, String periodLength)
    {
        this.gameId = gId;
        this.periodId = pId;
        this.timestamp = timestamp;
        this.periodLength = periodLength;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public long getPeriodId() { return periodId; }

    public void setPeriodId(long periodId) { this.periodId = periodId; }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getPeriodLength() { return periodLength; }

    public void setPeriodLength(String periodLength) { this.periodLength = periodLength; }
}
