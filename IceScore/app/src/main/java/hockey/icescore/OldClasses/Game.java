package hockey.icescore.OldClasses;

import android.text.format.Time;

import java.util.ArrayList;

/**
 * Created by 041402465 on 7/04/2015.
 */
public class Game {
    static public int gameID;
    static public Team homeTeam;
    static public Team awayTeam;
    static public Time gameTime;
    static public String venue;
    static public String division;
    static public ArrayList<Official> officials;
    static public String notes;
    //      public Event[] events;
    static public String currentPeriod;
    static public String CurrentPeriod;
    static public int periodLength = 20;


    public static String getCurrentScore() {
        return homeTeam.getGoalCounter() + " | " + awayTeam.getGoalCounter() ;
    }

    public String CurrentScore;


    public static void setGameID(int gameID) {
        Game.gameID = gameID;
    }

    public static void setGameTime(Time gameTime) {
        Game.gameTime = gameTime;
    }

    public static void setVenue(String venue) {
        Game.venue = venue;
    }

    public static void setDivision(String division) {
        Game.division = division;
    }

    public static void setOfficials(ArrayList<Official> officials) {
        Game.officials = officials;
    }

    public static void setNotes(String notes) {
        Game.notes = notes;
    }

    public static void setCurrentPeriod(String currentPeriod) {
        Game.currentPeriod = currentPeriod;
    }

    public Game(int ID,Time time, String venue, String division)
    {
        this.gameID = ID;
        this.gameTime = time;
        this.venue = venue;
        this.division = division;

        this.notes = "";
        this.currentPeriod = "Period 0";
        this.officials = new ArrayList<Official>();
    }

    public void beginGame()
    {
        if (currentPeriod == "Period 0")
            currentPeriod = "Period 1";


    }

    public void nextPeriod()
    {
        if(currentPeriod == "Period 1")
            currentPeriod = "Period 2";
        else if (currentPeriod == "Period 2")
            currentPeriod = "Period 3";


    }

    public static  void setHomeTeam(int teamID, String teamName, int managerID, String managerName)
    {
        homeTeam = new Team(teamID, teamName, managerID, managerName);
    }

    public static void setAwayTeam(int teamID, String teamName, int managerID, String managerName)
    {
        awayTeam = new Team(teamID, teamName, managerID, managerName);
    }

    public static  void addOfficial(int officialID, String name, String type)
    {
        officials.add(new Official(officialID, name, type));
    }

    public static  void addOfficial(String name, String type)
    {
        officials.add(new Official(name, type));
    }


    public static  ArrayList<Official> getOfficialsByType(String type)
    {
        ArrayList<Official> result = new ArrayList<Official>();

        for(int i = 0; i < officials.size(); i++)
        {
            if(officials.get(i).getType().equals(type))
            {
                result.add(officials.get(i));
            }
        }

        return result;
    }



}

