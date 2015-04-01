package hockey.icescore.util;

/**
 * Created by Lucas Angelon on 25-Mar-15.
 */
public class Constants
{
    // Application Definitions.
    public static final String DATABASE_NAME = "ICE_SCORE_DATABASE";
    public static final int DATABASE_VERSION = 1;

    // Table Titles.
    public static final String TABLE_PERSON = "PERSON";
    public static final String TABLE_IDENTIFIER = "IDENTIFIER";
    public static final String TABLE_ROLE = "ROLE";
    public static final String TABLE_ROLE_IDENTIFIER = "ROLE_IDENTIFIER";
    public static final String TABLE_TEAM_PERSON_NUMBER = "TEAM_PERSON_NUMBER";
    public static final String TABLE_TEAM = "TEAM";
    public static final String TABLE_DIVISION = "DIVISION";
    public static final String TABLE_TIMEOUT = "TIMEOUT";
    public static final String TABLE_GAME = "GAME";
    public static final String TABLE_GAME_TEAM_GOALIE = "GAME_TEAM_GOALIE";
    public static final String TABLE_VENUE = "VENUE";
    public static final String TABLE_PERIOD = "PERIOD";
    public static final String TABLE_GAME_PERIOD = "GAME_PERIOD";
    public static final String TABLE_SIGN_OFF = "SIGN_OFF";
    public static final String TABLE_GAME_NOTE = "GAME_NOTE";
    public static final String TABLE_INJURY = "INJURY";
    public static final String TABLE_CATEGORY = "CATEGORY";
    public static final String TABLE_PENALTY = "PENALTY";
    public static final String TABLE_GAME_PERSON_ACTION_EXTENDED = "GAME_PERSON_ACTION_EXTENDED";
    public static final String TABLE_ACTION = "ACTION";
    public static final String TABLE_GAME_PERSON_ACTION = "GAME_PERSON_ACTION";
    public static final String TABLE_GAME_TEAM_PERSON = "GAME_TEAM_PERSON";

    // Field Titles.
    public static final String FIELD_ID = "ID";
    public static final String FIELD_NAME = "NAME";
    public static final String FIELD_NUMBER = "NUMBER";
    public static final String FIELD_IMAGE = "IMAGE";
    public static final String FIELD_TIMESTAMP = "TIMESTAMP";
    public static final String FIELD_STREET = "STREET";
    public static final String FIELD_SUBURB = "SUBURB";
    public static final String FIELD_POSTCODE = "POSTCODE";
    public static final String FIELD_CITY = "CITY";
    public static final String FIELD_STATE = "STATE";
    public static final String FIELD_COUNTRY = "COUNTRY";
    public static final String FIELD_SIGNATURE = "SIGNATURE";
    public static final String FIELD_NOTES = "NOTES";
    public static final String FIELD_DEFAULT_TIME = "DEFAULT_TIME";

    // Foreign Key Titles.
    public static final String FK_IDENTIFIER_ID = "IDENTIFIER_ID";
    public static final String FK_ROLE_ID = "ROLE_ID";
    public static final String FK_PERSON_ID = "PERSON_ID";
    public static final String FK_TEAM_ID = "TEAM_ID";
    public static final String FK_DIVISION_ID = "DIVISION_ID";
    public static final String FK_GAME_ID = "GAME_ID";
    public static final String FK_VENUE_ID = "VENUE_ID";
    public static final String FK_HOME_TEAM_ID = "HOME_TEAM_ID";
    public static final String FK_AWAY_TEAM_ID = "AWAY_TEAM_ID";
    public static final String FK_HOME_TEAM_MANAGER_ID = "HOME_TEAM_MANAGER_ID";
    public static final String FK_AWAY_TEAM_MANAGER_ID = "AWAY_TEAM_MANAGER_ID";
    public static final String FK_REFEREE_ID = "REFEREE_ID";
    public static final String FK_LINESMAN_ID = "LINESMAN_ID";
    public static final String FK_LINESMAN2_ID = "LINESMAN2_ID";
    public static final String FK_SCOREKEEPER_ID = "SCOREKEEPER_ID";
    public static final String FK_PERIOD_ID = "PERIOD_ID";
    public static final String FK_CATEGORY_ID = "CATEGORY_ID";
    public static final String FK_GAME_PERSON_ACTION_ID = "GAME_PERSON_ACTION_ID";
    public static final String FK_PENALTY_ID = "PENALTY_ID";
    public static final String FK_INJURY_ID = " INJURY_ID";
    public static final String FK_ACTION_ID = " ACTION_ID";

    // SQL Commands.
    public static final String RECREATE_TABLE = "DROP TABLE IF EXISTS ";

    // The DatabaseGenerator class contains the SQL statements required to create the Database.
    public static class DatabaseGenerator
    {
        // Yellow Database Section - Lucas
        public static final String CREATE_TABLE_PERSON = "CREATE TABLE " + TABLE_PERSON +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL, "
                    + FK_IDENTIFIER_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_IDENTIFIER_ID + ") "
                        + "REFERENCES " + TABLE_IDENTIFIER + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_IDENTIFIER = "CREATE TABLE " + TABLE_IDENTIFIER +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_ROLE = "CREATE TABLE " + TABLE_ROLE +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_ROLE_IDENTIFIER = "CREATE TABLE " +
                TABLE_ROLE_IDENTIFIER +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FK_ROLE_ID + " INTEGER NOT NULL, "
                    + FK_IDENTIFIER_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_ROLE_ID + ") "
                        + "REFERENCES " + TABLE_ROLE + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_IDENTIFIER_ID + ") "
                        + "REFERENCES " + TABLE_IDENTIFIER + "(" + FIELD_ID + ")" +
                ")";

        // Blue Database Section - Lucas
        public static final String CREATE_TABLE_TEAM = "CREATE TABLE " + TABLE_TEAM +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL, "
                    + FIELD_IMAGE + " TEXT, "
                    + FK_DIVISION_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_DIVISION_ID + ") "
                        + "REFERENCES " + TABLE_DIVISION + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_DIVISION = "CREATE TABLE " + TABLE_DIVISION +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_TEAM_PERSON_NUMBER = "CREATE TABLE " +
                TABLE_TEAM_PERSON_NUMBER +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NUMBER + " TEXT NOT NULL, "
                    + FK_PERSON_ID + " INTEGER NOT NULL, "
                    + FK_TEAM_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_PERSON_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_TEAM_ID + ") "
                        + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_TIMEOUT = "CREATE TABLE " + TABLE_TIMEOUT +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_TIMESTAMP + " TEXT NOT NULL, "
                    + FK_TEAM_ID + " INTEGER NOT NULL, "
                    + FK_GAME_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_TEAM_ID + ") "
                        + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_GAME_ID + ") "
                        + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_GAME_TEAM_GOALIE = "CREATE TABLE " +
                TABLE_GAME_TEAM_GOALIE +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_TIMESTAMP + " TEXT NOT NULL, "
                    + FK_PERSON_ID + " INTEGER NOT NULL, "
                    + FK_GAME_ID + " INTEGER NOT NULL, "
                    + FK_TEAM_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_PERSON_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_GAME_ID + ") "
                        + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_TEAM_ID + ") "
                        + "REFERENCES " + TABLE_TEAM + ")" +
                ")";

        // Pink Database Section - Lucas
        public static final String CREATE_TABLE_VENUE = "CREATE TABLE " + TABLE_VENUE +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL, "
                    + FIELD_STREET + " TEXT NOT NULL, "
                    + FIELD_SUBURB + " TEXT NOT NULL, "
                    + FIELD_POSTCODE + " TEXT NOT NULL, "
                    + FIELD_CITY + " TEXT NOT NULL, "
                    + FIELD_STATE + " TEXT NOT NULL, "
                    + FIELD_COUNTRY + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_PERIOD = "CREATE TABLE " + TABLE_PERIOD +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NAME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_GAME = "CREATE TABLE " + TABLE_GAME +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_TIMESTAMP + " TEXT NOT NULL, "
                    + FK_VENUE_ID + " INTEGER NOT NULL, "
                    + FK_HOME_TEAM_ID + " INTEGER NOT NULL, "
                    + FK_AWAY_TEAM_ID + " INTEGER NOT NULL, "
                    + FK_HOME_TEAM_MANAGER_ID + " INTEGER NOT NULL, "
                    + FK_AWAY_TEAM_MANAGER_ID + " INTEGER NOT NULL, "
                    + FK_REFEREE_ID + " INTEGER NOT NULL, "
                    + FK_LINESMAN_ID + " INTEGER NOT NULL, "
                    + FK_LINESMAN2_ID + " INTEGER NOT NULL, "
                    + FK_SCOREKEEPER_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_VENUE_ID + ") "
                        + "REFERENCES " + TABLE_VENUE + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_HOME_TEAM_ID + ") "
                        + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_AWAY_TEAM_ID + ") "
                        + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_HOME_TEAM_MANAGER_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_AWAY_TEAM_MANAGER_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_REFEREE_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_LINESMAN_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_LINESMAN2_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_SCOREKEEPER_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_GAME_PERIOD = "CREATE TABLE " + TABLE_GAME_PERIOD +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_TIMESTAMP + " TEXT NOT NULL, "
                    + FK_GAME_ID + " INTEGER NOT NULL, "
                    + FK_PERIOD_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_GAME_ID + ") "
                        + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_PERIOD_ID + ") "
                        + "REFERENCES " + TABLE_PERIOD + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_SIGN_OFF = "CREATE TABLE " + TABLE_SIGN_OFF +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_SIGNATURE + " TEXT NOT NULL, "
                    + FK_GAME_ID + " INTEGER NOT NULL, "
                    + FK_PERSON_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_GAME_ID + ") "
                        + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + "), "
                        + "FOREIGN KEY (" + FK_PERSON_ID + ") "
                        + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_TABLE_GAME_NOTE = "CREATE TABLE" + TABLE_GAME_NOTE +
                "("
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_NOTES + " TEXT NOT NULL, "
                    + FK_GAME_ID + " INTEGER NOT NULL, "
                        + "FOREIGN KEY (" + FK_GAME_ID + ") "
                        + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + ")" +
                ")";

        //Red Database Section Josh
        public static final String CREATE_TABLE_INJURY = "CREATE TABLE" + TABLE_INJURY +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIELD_NAME + " TEXT NOT NULL, "
                + FIELD_NOTES + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE" + TABLE_CATEGORY +
                "("
                + FIELD_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIELD_NAME + " TEXT NOT NULL, "
                + FIELD_DEFAULT_TIME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_TABLE_PENALTY = "CREATE TABLE" + TABLE_PENALTY +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FK_CATEGORY_ID + " INTEGER NOT NULL, "
                + FIELD_NAME + " TEXT NOT NULL, "
                + FIELD_NOTES + " TEXT, "
                + "FOREIGN KEY (" + FK_CATEGORY_ID + ") "
                + "REFERENCES " + TABLE_CATEGORY + "(" + FIELD_ID + ")" +
                ")";

        public static final String CREATE_GAME_PERSON_ACTION_EXTENDED = "CREATE TABLE" +
                TABLE_GAME_PERSON_ACTION_EXTENDED +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FK_GAME_PERSON_ACTION_ID + " INTEGER NOT NULL, "
                + FK_PENALTY_ID + " INTEGER, "
                + FK_INJURY_ID + " INTEGER, "
                + FIELD_NOTES + " TEXT, "
                + "FOREIGN KEY (" + FK_GAME_PERSON_ACTION_ID + ") "
                + "REFERENCES " + TABLE_GAME_PERSON_ACTION + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_PENALTY_ID + ") "
                + "REFERENCES " + TABLE_PENALTY + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_INJURY_ID + ") "
                + "REFERENCES " + TABLE_INJURY + "(" + FIELD_ID + ")" +
                ")";

        //Green Database Section Josh
        public static final String CREATE_ACTION = "CREATE TABLE" + TABLE_ACTION +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIELD_NAME + " TEXT NOT NULL" +
                ")";

        public static final String CREATE_GAME_PERSON_ACTION = "CREATE TABLE" +
                TABLE_GAME_PERSON_ACTION +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FK_PERSON_ID + " INTEGER NOT NULL, "
                + FK_ACTION_ID + " INTEGER NOT NULL, "
                + FK_TEAM_ID + " INTEGER NOT NULL, "
                + FK_PERIOD_ID + " INTEGER NOT NULL, "
                + FK_GAME_ID + " INTEGER NOT NULL, "
                + FIELD_TIMESTAMP + " TEXT NOT NULL, "
                + "FOREIGN KEY (" + FK_PERSON_ID + ") "
                + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_ACTION_ID + ") "
                + "REFERENCES " + TABLE_ACTION + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_TEAM_ID + ") "
                + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_PERIOD_ID + ") "
                + "REFERENCES " + TABLE_PERIOD + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_GAME_ID + ") "
                + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + ")" +
                ")";

        //Magenta Database Section Josh
        public static final String CREATE_GAME_TEAM_PERSON = "CREATE TABLE" +
                TABLE_GAME_TEAM_PERSON +
                "("
                + FIELD_ID + " INTEGER PRIMARY KEY, "
                + FK_GAME_ID + " INTEGER NOT NULL, "
                + FK_TEAM_ID + " INTEGER, "
                + FK_PERSON_ID + " INTEGER NOT NULL, "
                + FK_ROLE_ID + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + FK_GAME_ID + ") "
                + "REFERENCES " + TABLE_GAME + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_TEAM_ID + ") "
                + "REFERENCES " + TABLE_TEAM + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_PERSON_ID + ") "
                + "REFERENCES " + TABLE_PERSON + "(" + FIELD_ID + ") "
                + "FOREIGN KEY (" + FK_ROLE_ID + ") "
                + "REFERENCES " + TABLE_ROLE + "(" + FIELD_ID + ") " +
                ")";
    }
}
