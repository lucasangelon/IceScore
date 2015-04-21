package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Penalty {

    protected long id;
    protected long categoryId;
    protected String name;
    protected String notes;

    public Penalty()
    {

    }

    public Penalty(long cId, String name, String notes)
    {
        this.categoryId = cId;
        this.name = name;
        this.notes = notes;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getCategoryId() { return categoryId; }

    public void setCategoryId(long categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
