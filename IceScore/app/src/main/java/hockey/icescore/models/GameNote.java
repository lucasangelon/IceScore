package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class GameNote {

    protected long id;
    protected long gameId;
    protected String notes;

    public GameNote()
    {

    }

    public GameNote(long gId, String notes)
    {
        this.gameId = gId;
        this.notes = notes;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
