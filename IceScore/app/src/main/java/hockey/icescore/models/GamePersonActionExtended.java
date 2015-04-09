package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 09-Apr-15.
 */
public class GamePersonActionExtended
{
    protected long id;
    protected long gamePersonActionId;
    protected long penaltyId;
    protected long injuryId;
    protected String notes;

    // Constructor
    public GamePersonActionExtended(long penaltyId, long injuryId, String notes)
    {
        this.penaltyId = penaltyId;
        this.injuryId = injuryId;
        this.notes = notes;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGamePersonActionId() { return gamePersonActionId; }

    public void setGamePersonActionId(long gamePersonActionId) { this.gamePersonActionId = gamePersonActionId; }

    public long getPenaltyId() { return penaltyId; }

    public void setPenaltyId(long penaltyId) { this.penaltyId = penaltyId; }

    public long getInjuryId() { return injuryId; }

    public void setInjuryId(long injuryId) { this.injuryId = injuryId; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
