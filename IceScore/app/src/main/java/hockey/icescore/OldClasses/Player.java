package hockey.icescore.OldClasses;
public class Player
{
    public int playerID;
    public String name;
    public int number;
    public int goals;
    public int assists;

    public Player(int id, String name, int num)
    {
        this.playerID = id;
        this.name = name;
        this.number = num;

        goals = 0;
        assists = 0;
    }
}

