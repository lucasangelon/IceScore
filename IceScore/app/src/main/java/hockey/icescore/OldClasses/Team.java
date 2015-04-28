package hockey.icescore.OldClasses;

import java.util.ArrayList;

public class Team {
    private int teamID;
    private String name;


    public void setGoalCounter(int goalCounter) {
        this.goalCounter = goalCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int goalCounter;

    private int shotCounter;
    private int penaltyCounter;
    public ArrayList<Player> players;
    private int managerID;
    private String managerName;
    private Boolean managerSignedOff;
    //private Goalie currentGoalie;

    //constructor specifying the required details
    public Team(int teamID, String teamName, int managerID, String managerName)
    {
        //initialise the given values
        this.teamID = teamID;
        this.name = teamName;
        this.managerID = managerID;
        this.managerName = managerName;
        //this.players = new Player[];

        //set some defaults
        goalCounter = 0;
        shotCounter = 0;
        penaltyCounter = 0;
        managerSignedOff = false;
        players = new ArrayList<Player>();
    }

    public void addPlayer(int id, String name, int num)
    {
        players.add(new Player(id, name, num));
    }

    public void addGoalie(int id, String name, int num)
    {
        players.add(new Goalie(id, name, num));
    }

    public int getTeamID()
    {
        return teamID;
    }

    public String getTeamName()
    {
        return name;
    }

    public int getGoalCounter()
    {
        return goalCounter;
    }

    public void addGoal()
    {
        goalCounter += 1;
    }

    public int getPenaltyCounter()
    {
        return penaltyCounter;
    }

    public int getShotCounter()
    {
        return shotCounter;
    }

    public int getManagerID()
    {
        return managerID;
    }

    public String getManagerName()
    {
        return managerName;
    }

    public Boolean isManagerSignedOff()
    {
        return managerSignedOff;
    }

    public boolean hasNextPlayer(int index)
    {
        if(players.size()>index)
            return true;
        else
            return false;
    }
    public Player getPlayer(int index){
        return players.get(index);
    }


    //public Goalie getCurrentGoalie()
    //{
    //    return currentGoalie;
    //}

    //public Player getPlayerAt(int index)
    //{
    //    return players[index];
    //}

    //public PlayerNumber getPlayerByName(String name)
    //{
    //    Player foundPlayer = null;

    //    for (int i = 0; i < players.count; i++)
    //    {
    //        if (players[i].getName() == name)
    //        {
    //            foundPlayer = players[i];
    //        }
    //    }
    //    return foundPlayer;
    //}

    public Player getPlayerByNumber(int number)
    {
        Player foundPlayer = null;

        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getNumber() == number)
            {
                foundPlayer = players.get(i);
            }
        }
        return foundPlayer;
    }
    public Player getPlayerByID(int number)
    {
        Player foundPlayer = null;

        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getID() == number)
            {
                foundPlayer = players.get(i);
            }
        }
        return foundPlayer;
    }





}

