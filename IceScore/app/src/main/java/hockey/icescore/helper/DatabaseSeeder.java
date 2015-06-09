package hockey.icescore.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.*;

import java.util.ArrayList;
import java.util.List;

import hockey.icescore.models.*;
import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 22-Apr-15.
 */
public class DatabaseSeeder
{
    private DatabaseManager dbManager;
    private Context context;

    public DatabaseSeeder(Context context)
    {
        dbManager = DatabaseManager.getInstance(context);
        this.context = context;
    }

    public void seedAll()
    {
        seedAction();
        seedCategory();
        seedDivision();
        seedGame();
        seedGamePeriod();
        seedGameTeamGoalie();
        seedIdentifier();
        seedInjury();
        seedPenalty();
        seedPeriod();
        seedPerson();
        seedRoleIdentifier();
        seedRoles();
        seedTeam();
        seedTeamPersonNumber();
        seedGameTeamGoalie();
        seedVenue();
    }

    public String seedRoles()
    {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("Player"));
        roles.add(new Role("Manager"));
        roles.add(new Role("Referee"));
        roles.add(new Role("Linesman"));
        roles.add(new Role("Scorekeeper"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Role role : roles)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, role.getName());

               writeDb.insert(Constants.TABLE_ROLE, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 6: Unable to seed Role.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Roles!";
    }

    public String seedIdentifier()
    {
        List<Identifier> identifiers = new ArrayList<>();

        identifiers.add(new Identifier("P"));
        identifiers.add(new Identifier("PM"));
        identifiers.add(new Identifier("PR"));
        identifiers.add(new Identifier("PL"));
        identifiers.add(new Identifier("PS"));
        identifiers.add(new Identifier("PMR"));
        identifiers.add(new Identifier("PML"));
        identifiers.add(new Identifier("PMS"));
        identifiers.add(new Identifier("PRL"));
        identifiers.add(new Identifier("PRS"));
        identifiers.add(new Identifier("PLS"));
        identifiers.add(new Identifier("PMRL"));
        identifiers.add(new Identifier("PMRS"));
        identifiers.add(new Identifier("PMLS"));
        identifiers.add(new Identifier("PRLS"));
        identifiers.add(new Identifier("PMRLS"));
        identifiers.add(new Identifier("M"));
        identifiers.add(new Identifier("MR"));
        identifiers.add(new Identifier("ML"));
        identifiers.add(new Identifier("MS"));
        identifiers.add(new Identifier("MRL"));
        identifiers.add(new Identifier("MRS"));
        identifiers.add(new Identifier("MLS"));
        identifiers.add(new Identifier("MRLS"));
        identifiers.add(new Identifier("R"));
        identifiers.add(new Identifier("RL"));
        identifiers.add(new Identifier("RS"));
        identifiers.add(new Identifier("RLS"));
        identifiers.add(new Identifier("L"));
        identifiers.add(new Identifier("LS"));
        identifiers.add(new Identifier("S"));


        SQLiteDatabase writeDb = dbManager.getWritableDatabase();

        writeDb.beginTransaction();

        try
        {
            for (Identifier identifier : identifiers)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, identifier.getName());

                writeDb.insert(Constants.TABLE_IDENTIFIER, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 7: Unable to seed Identifier.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Identifiers!";
    }

    public String seedRoleIdentifier()
    {
        List<RoleIdentifier> rIdentifiers = new ArrayList<>();

        // P
        rIdentifiers.add(new RoleIdentifier(1,1));

        // PM, PR, PL, PS
        rIdentifiers.add(new RoleIdentifier(1,2));
        rIdentifiers.add(new RoleIdentifier(2,2));
        rIdentifiers.add(new RoleIdentifier(1,3));
        rIdentifiers.add(new RoleIdentifier(3,3));
        rIdentifiers.add(new RoleIdentifier(1,4));
        rIdentifiers.add(new RoleIdentifier(4,4));
        rIdentifiers.add(new RoleIdentifier(1,5));
        rIdentifiers.add(new RoleIdentifier(5,5));

        // PMR, PML, PMS, PRL, PRS, PLS
        rIdentifiers.add(new RoleIdentifier(1,6));
        rIdentifiers.add(new RoleIdentifier(2,6));
        rIdentifiers.add(new RoleIdentifier(3,6));
        rIdentifiers.add(new RoleIdentifier(1,7));
        rIdentifiers.add(new RoleIdentifier(2,7));
        rIdentifiers.add(new RoleIdentifier(4,7));
        rIdentifiers.add(new RoleIdentifier(1,8));
        rIdentifiers.add(new RoleIdentifier(2,8));
        rIdentifiers.add(new RoleIdentifier(5,8));
        rIdentifiers.add(new RoleIdentifier(1,9));
        rIdentifiers.add(new RoleIdentifier(3,9));
        rIdentifiers.add(new RoleIdentifier(4,9));
        rIdentifiers.add(new RoleIdentifier(1,10));
        rIdentifiers.add(new RoleIdentifier(3,10));
        rIdentifiers.add(new RoleIdentifier(5,10));
        rIdentifiers.add(new RoleIdentifier(1,11));
        rIdentifiers.add(new RoleIdentifier(4,11));
        rIdentifiers.add(new RoleIdentifier(5,11));

        // PMRL, PMRS, PMLS, PRLS
        rIdentifiers.add(new RoleIdentifier(1,12));
        rIdentifiers.add(new RoleIdentifier(2,12));
        rIdentifiers.add(new RoleIdentifier(3,12));
        rIdentifiers.add(new RoleIdentifier(4,12));
        rIdentifiers.add(new RoleIdentifier(1,13));
        rIdentifiers.add(new RoleIdentifier(2,13));
        rIdentifiers.add(new RoleIdentifier(3,13));
        rIdentifiers.add(new RoleIdentifier(5,13));
        rIdentifiers.add(new RoleIdentifier(1,14));
        rIdentifiers.add(new RoleIdentifier(2,14));
        rIdentifiers.add(new RoleIdentifier(4,14));
        rIdentifiers.add(new RoleIdentifier(5,14));
        rIdentifiers.add(new RoleIdentifier(1,15));
        rIdentifiers.add(new RoleIdentifier(3,15));
        rIdentifiers.add(new RoleIdentifier(4,15));
        rIdentifiers.add(new RoleIdentifier(5,15));

        // PMRLS
        rIdentifiers.add(new RoleIdentifier(1,16));
        rIdentifiers.add(new RoleIdentifier(2,16));
        rIdentifiers.add(new RoleIdentifier(3,16));
        rIdentifiers.add(new RoleIdentifier(4,16));
        rIdentifiers.add(new RoleIdentifier(5,16));

        // M
        rIdentifiers.add(new RoleIdentifier(2,17));

        // MR, ML, MS
        rIdentifiers.add(new RoleIdentifier(2,18));
        rIdentifiers.add(new RoleIdentifier(3,18));
        rIdentifiers.add(new RoleIdentifier(2,19));
        rIdentifiers.add(new RoleIdentifier(4,19));
        rIdentifiers.add(new RoleIdentifier(2,20));
        rIdentifiers.add(new RoleIdentifier(5,20));

        // MRL, MRS, MLS
        rIdentifiers.add(new RoleIdentifier(2,21));
        rIdentifiers.add(new RoleIdentifier(3,21));
        rIdentifiers.add(new RoleIdentifier(4,21));
        rIdentifiers.add(new RoleIdentifier(2,22));
        rIdentifiers.add(new RoleIdentifier(3,22));
        rIdentifiers.add(new RoleIdentifier(5,22));
        rIdentifiers.add(new RoleIdentifier(2,23));
        rIdentifiers.add(new RoleIdentifier(4,23));
        rIdentifiers.add(new RoleIdentifier(5,23));

        // MRLS
        rIdentifiers.add(new RoleIdentifier(2,24));
        rIdentifiers.add(new RoleIdentifier(3,24));
        rIdentifiers.add(new RoleIdentifier(4,24));
        rIdentifiers.add(new RoleIdentifier(5,24));

        // R
        rIdentifiers.add(new RoleIdentifier(3,25));

        // RL, RS
        rIdentifiers.add(new RoleIdentifier(3,26));
        rIdentifiers.add(new RoleIdentifier(4,26));
        rIdentifiers.add(new RoleIdentifier(3,27));
        rIdentifiers.add(new RoleIdentifier(5,27));

        // RLS
        rIdentifiers.add(new RoleIdentifier(3,28));
        rIdentifiers.add(new RoleIdentifier(4,28));
        rIdentifiers.add(new RoleIdentifier(5,28));

        // L
        rIdentifiers.add(new RoleIdentifier(4,29));

        // LS
        rIdentifiers.add(new RoleIdentifier(4,30));
        rIdentifiers.add(new RoleIdentifier(5,30));

        // S
        rIdentifiers.add(new RoleIdentifier(5,31));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();

        writeDb.beginTransaction();

        try
        {
            for (RoleIdentifier rIdentifier : rIdentifiers)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_ROLE_ID, rIdentifier.getRoleId());
                values.put(Constants.FK_IDENTIFIER_ID, rIdentifier.getIdentifierId());

                writeDb.insert(Constants.TABLE_ROLE_IDENTIFIER, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 8: Unable to seed Role Identifier.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Role Identifiers!";
    }

    public String seedPerson()
    {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Jack Kitchener", 1));
        people.add(new Person("Johnathan Lynch", 1));
        people.add(new Person("Joshua Lloyd", 16));
        people.add(new Person("Lucas Angelon", 2));
        people.add(new Person("Suruchi Bapat", 5));
        people.add(new Person("Nichola Kerr", 16));
        people.add(new Person("Deborah Hammond", 25));
        people.add(new Person("Linesman A", 29));
        people.add(new Person("Linesman B", 29));
        people.add(new Person("Scorekeeper", 31));
        people.add(new Person("Manager A", 17));
        people.add(new Person("Manager B", 17));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Person person : people)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, person.getName());
                values.put(Constants.FK_IDENTIFIER_ID, person.getIdentifierId());

                writeDb.insert(Constants.TABLE_PERSON, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 9: Unable to seed Person.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded People!";
    }

    public String seedDivision()
    {
        List<Division> divisions = new ArrayList<>();

        divisions.add(new Division("Peewee"));
        divisions.add(new Division("Midget"));
        divisions.add(new Division("Senior 2"));
        divisions.add(new Division("Senior 1"));
        divisions.add(new Division("Super League"));
        divisions.add(new Division("Bantam"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Division division : divisions)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, division.getName());

                writeDb.insert(Constants.TABLE_DIVISION, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 10: Unable to seed Division.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Divisions!";
    }

    public String seedTeam()
    {
        List<Team> teams = new ArrayList<>();

        teams.add(new Team("Redhawks", "", 6));
        teams.add(new Team("Central Blitzrieg", "", 3));
        teams.add(new Team("Blackhawks", "", 6));
        teams.add(new Team("Blackhawks", "", 5));
        teams.add(new Team("Panthers", "", 3));
        teams.add(new Team("Flyers", "", 5));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Team team : teams)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, team.getName());
                values.put(Constants.FIELD_IMAGE, team.getImage());
                values.put(Constants.FK_DIVISION_ID, team.getDivisionId());

                writeDb.insert(Constants.TABLE_TEAM, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 11: Unable to seed Team.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Teams!";
    }

    public String seedTeamPersonNumber()
    {
        List<TeamPersonNumber> tmps = new ArrayList<>();

        tmps.add(new TeamPersonNumber(3, 1, "22"));
        tmps.add(new TeamPersonNumber(3, 2, "34"));
        tmps.add(new TeamPersonNumber(3, 4, "29"));
        tmps.add(new TeamPersonNumber(1, 3, "17"));
        tmps.add(new TeamPersonNumber(1, 5, "31"));
        tmps.add(new TeamPersonNumber(1, 6, "00"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (TeamPersonNumber tmp : tmps)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_TEAM_ID, tmp.getTeamId());
                values.put(Constants.FK_PERSON_ID, tmp.getPersonId());
                values.put(Constants.FIELD_NUMBER, tmp.getNumber());

                writeDb.insert(Constants.TABLE_TEAM_PERSON_NUMBER, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 12: Unable to seed Team Person Number.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Team Person Numbers!";
    }

    public String seedVenue()
    {
        List<Venue> venues = new ArrayList<>();

        venues.add(new Venue("Xtreme Ice Arena", "Chesterfield Road", "Mirrabooka", "6061", "Stirling", "WA", "Australia"));
        venues.add(new Venue("Cockburn Ice Arena", "Barrington Street", "Bibra Lake", "6163", "Cockburn", "WA", "Australia"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Venue venue : venues)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, venue.getName());
                values.put(Constants.FIELD_STREET, venue.getStreet());
                values.put(Constants.FIELD_SUBURB, venue.getSuburb());
                values.put(Constants.FIELD_POSTCODE, venue.getPostcode());
                values.put(Constants.FIELD_CITY, venue.getCity());
                values.put(Constants.FIELD_STATE, venue.getState());
                values.put(Constants.FIELD_COUNTRY, venue.getCountry());

                writeDb.insert(Constants.TABLE_VENUE, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 13: Unable to seed Venue.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Venues!";
    }

    public String seedPeriod()
    {
        List<Period> periods = new ArrayList<>();

        periods.add(new Period("Period 1"));
        periods.add(new Period("Period 2"));
        periods.add(new Period("Period 3"));
        periods.add(new Period("Overtime"));
        periods.add(new Period("Shootout"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Period period : periods)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, period.getName());

                writeDb.insert(Constants.TABLE_PERIOD, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 14: Unable to seed Period.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Periods!";
    }

    public String seedGame()
    {
        List<Game> games = new ArrayList<>();

        games.add(new Game(1, 3, 1, 11, 12, 7, 8, 9, 10, "06-MAY-2015 14:00:00"));
        games.add(new Game(2, 1, 3, 12, 11, 7, 8, 9, 10, "18-MAY-2015 14:00:00"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Game game : games)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_VENUE_ID, game.getVenueId());
                values.put(Constants.FK_HOME_TEAM_ID, game.getHomeTeamId());
                values.put(Constants.FK_AWAY_TEAM_ID, game.getAwayTeamId());
                values.put(Constants.FK_HOME_TEAM_MANAGER_ID, game.getHomeTeamManagerId());
                values.put(Constants.FK_AWAY_TEAM_MANAGER_ID, game.getAwayTeamManagerId());
                values.put(Constants.FK_REFEREE_ID, game.getRefereeId());
                values.put(Constants.FK_LINESMAN_ID, game.getLinesmanId());
                values.put(Constants.FK_LINESMAN2_ID, game.getLinesman2Id());
                values.put(Constants.FK_SCOREKEEPER_ID, game.getScorekeeperId());
                values.put(Constants.FIELD_TIMESTAMP, game.getDate());

                writeDb.insert(Constants.TABLE_GAME, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 15: Unable to seed Game.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Games!";
    }

    public String seedGamePeriod()
    {
        List<GamePeriod> gPeriods = new ArrayList<>();

        gPeriods.add(new GamePeriod(1, 1, "06-MAY-2015 14:00:00", "20"));
        gPeriods.add(new GamePeriod(1, 2, "06-MAY-2015 14:25:00", "20"));
        gPeriods.add(new GamePeriod(1, 3, "06-MAY-2015 14:50:00", "20"));
        gPeriods.add(new GamePeriod(1, 4, "06-MAY-2015 15:10:00", "10"));
        gPeriods.add(new GamePeriod(1, 5, "06-MAY-2015 15:30:00", "20"));
        gPeriods.add(new GamePeriod(2, 1, "18-MAY-2015 14:00:00", "20"));
        gPeriods.add(new GamePeriod(2, 2, "18-MAY-2015 14:25:00", "20"));
        gPeriods.add(new GamePeriod(2, 3, "18-MAY-2015 14:50:00", "20"));
        gPeriods.add(new GamePeriod(2, 4, "18-MAY-2015 15:10:00", "10"));
        gPeriods.add(new GamePeriod(2, 5, "18-MAY-2015 15:30:00", "20"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (GamePeriod gp : gPeriods)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_GAME_ID, gp.getGameId());
                values.put(Constants.FK_PERIOD_ID, gp.getPeriodId());
                values.put(Constants.FIELD_TIMESTAMP, gp.getTimestamp());
                values.put(Constants.FIELD_PERIOD_LENGTH, gp.getPeriodLength());

                writeDb.insert(Constants.TABLE_GAME_PERIOD, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 16: Unable to seed Game Period.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Game Periods!";
    }

    public String seedGameTeamGoalie()
    {
        List<GameTeamGoalie> gtgs = new ArrayList<>();

        gtgs.add(new GameTeamGoalie(1, 1, 3, "06-MAY-2015 14:00:00"));
        gtgs.add(new GameTeamGoalie(4, 1, 1, "06-MAY-2015 14:00:00"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (GameTeamGoalie gtg : gtgs)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_PERSON_ID, gtg.getPersonId());
                values.put(Constants.FK_GAME_ID, gtg.getGameId());
                values.put(Constants.FK_TEAM_ID, gtg.getTeamId());
                values.put(Constants.FIELD_TIMESTAMP, gtg.getTimestamp());

                writeDb.insert(Constants.TABLE_GAME_TEAM_GOALIE, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 17: Unable to seed Game Team Goalie.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Game Team Goalies!";
    }

    public String seedAction()
    {
        List<Action> actions = new ArrayList<>();

        actions.add(new Action("Save"));
        actions.add(new Action("Goal"));
        actions.add(new Action("Penalty"));
        actions.add(new Action("Injury"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Action action : actions)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, action.getName());

                writeDb.insert(Constants.TABLE_ACTION, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 18: Unable to seed Action.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Actions!";
    }

    public String seedCategory()
    {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Minor", "2"));
        categories.add(new Category("Double Minor", "4"));
        categories.add(new Category("Major", "5"));
        categories.add(new Category("Misconduct", "10"));
        categories.add(new Category("Game Misconduct", "5"));
        categories.add(new Category("Match", "5"));
        categories.add(new Category("Penalty Shot", "0"));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Category cat : categories)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, cat.getName());
                values.put(Constants.FIELD_DEFAULT_TIME, cat.getDefaultTime());

                writeDb.insert(Constants.TABLE_CATEGORY, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 19: Unable to seed Category.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Categories.";
    }

    public String seedPenalty()
    {
        List<Penalty> penalties = new ArrayList<>();

        penalties.add(new Penalty(1, "Tripping", ""));
        penalties.add(new Penalty(3, "Spearing", ""));
        penalties.add(new Penalty(3, "Butt-Ending", ""));
        penalties.add(new Penalty(3, "Fighting", ""));
        penalties.add(new Penalty(4, "Swearing", ""));
        penalties.add(new Penalty(5, "Intentional Boarding", ""));
        penalties.add(new Penalty(6, "Deliberate Injury", ""));
        penalties.add(new Penalty(7, "Missed Score Opportunity", ""));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Penalty p : penalties)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FK_CATEGORY_ID, p.getCategoryId());
                values.put(Constants.FIELD_NAME, p.getName());
                values.put(Constants.FIELD_NOTES, p.getNotes());

                writeDb.insert(Constants.TABLE_PENALTY, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 20: Unable to seed Penalty.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Penalties.";
    }

    public String seedInjury()
    {
        List<Injury> injuries = new ArrayList<>();

        injuries.add(new Injury("Laceration", ""));
        injuries.add(new Injury("Concussion", ""));
        injuries.add(new Injury("Broken Bone", ""));
        injuries.add(new Injury("Hyperextension", ""));

        SQLiteDatabase writeDb = dbManager.getWritableDatabase();
        writeDb.beginTransaction();

        try
        {
            for (Injury i : injuries)
            {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, i.getName());
                values.put(Constants.FIELD_NOTES, i.getNotes());

                writeDb.insert(Constants.TABLE_INJURY, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 21: Unable to seed Injury.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Injuries.";
    }
}
