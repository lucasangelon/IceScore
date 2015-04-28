package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Category {

    protected long id;
    protected String name;
    protected String defaultTime;

    public Category()
    {

    }

    public Category(String name, String defaultTime)
    {
        this.name = name;
        this.defaultTime = defaultTime;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDefaultTime() { return defaultTime; }

    public void setDefaultTime(String defaultTime) { this.defaultTime = defaultTime; }
}
