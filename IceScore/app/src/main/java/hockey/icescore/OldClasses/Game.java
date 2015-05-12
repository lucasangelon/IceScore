package hockey.icescore.OldClasses;

import android.text.format.Time;

import java.util.ArrayList;

import hockey.icescore.models.Log;

/**
 * Created by 041402465 on 7/04/2015.
 */
public class Game {
    static public int gameID;
    static public Team homeTeam;
    static public Team awayTeam;
    static public String gameTime;
    static public String venue;
    static public String division;
    static public ArrayList<Official> officials;

    public static ArrayList<Log> getLogs() {
        return logs;
    }

    public static void setLogs(ArrayList<Log> logs) {
        Game.logs = logs;
    }

    public static void addToLogs(Log logs) {
        Game.logs.add(logs);
    }

    public static void deleteLogs(Log log) {
        Game.logs.remove(log);
    }

    static public ArrayList<Log> logs;
    static public String notes;
    //      public Event[] events;
    static public int currentPeriod;
    static public String CurrentPeriod;
    static public int periodLength = 20;


    public static String getCurrentScore() {
        return homeTeam.getGoalCounter() + " | " + awayTeam.getGoalCounter() ;
    }

    public String CurrentScore;


    public static void setGameID(int gameID) {
        Game.gameID = gameID;
    }

    public static void setGameTime(String gameTime) {
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

    public static void setCurrentPeriod(int currentPeriod) {
        Game.currentPeriod = currentPeriod;
    }

    public Game(int ID,String time, String venue, String division)
    {
        this.gameID = ID;
        this.gameTime = time;
        this.venue = venue;
        this.division = division;

        this.notes = "";
        this.currentPeriod = 0;
        this.officials = new ArrayList<Official>();
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

