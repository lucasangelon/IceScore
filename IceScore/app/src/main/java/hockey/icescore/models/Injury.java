package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Injury {

    protected long id;
    protected String name;
    protected String notes;

    public Injury()
    {

    }

    public Injury(String name, String notes)
    {
        this.name = name;
        this.notes = notes;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
