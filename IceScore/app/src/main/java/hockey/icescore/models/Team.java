package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Team {

    protected long id;
    protected String name;
    protected String image;
    protected long divisionId;

   public Team()
   {

   }

    public Team(String name, String image, long dId)
    {
        this.name = name;
        this.image = image;
        this.divisionId = dId;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public long getDivisionId() { return divisionId; }

    public void setDivisionId(long divisionId) { this.divisionId = divisionId; }
}
