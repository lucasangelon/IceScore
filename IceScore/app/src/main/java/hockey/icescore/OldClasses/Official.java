package hockey.icescore.OldClasses;
public class Official
{
    public int officialID;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public boolean signedOff;
    //private Uri signature;
    public String type;



    public Official(String name, String type)
    {
        //this.officialID = officialID;
        this.name = name;
        this.type = type;

        signedOff = false;
        //signature = new Uri();
    }

    public Official(int officialID, String name, String type)
    {
        this.officialID = officialID;
        this.name = name;
        this.type = type;

        signedOff = false;
        //signature = new Uri();
    }

    public int getOfficialID()
    {
        return officialID;
    }

    public String getName()
    {
        return name;
    }

    public boolean getSignedOff()
    {
        return signedOff;
    }

        /*public Uri getSignature()
        {
            return signature;
        }*/

    public String getType()
    {
        return type;
    }



}
