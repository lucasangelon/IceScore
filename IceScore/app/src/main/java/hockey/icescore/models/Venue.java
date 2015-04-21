package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Venue {

    protected long id;
    protected String name;
    protected String street;
    protected String suburb;
    protected String postcode;
    protected String city;
    protected String state;
    protected String country;

    public Venue()
    {

    }

    public Venue(String name, String street, String suburb, String postcode, String city, String state, String country)
    {
        this.name = name;
        this.street = street;
        this.suburb = suburb;
        this.postcode = postcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getSuburb() { return suburb; }

    public void setSuburb(String suburb) { this.suburb = suburb; }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }
}
