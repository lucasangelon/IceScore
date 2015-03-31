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

    // Field Titles.
    public static final String FIELD_ID = "ID";
    public static final String FIELD_NAME = "NAME";

    // Foreign Key Titles.
    public static final String FK_IDENTIFIER_ID = "IDENTIFIER_ID";
    public static final String FK_ROLE_ID = "ROLE_ID";

    // The DatabaseGenerator class contains the SQL statements required to create the Database.
    public static class DatabaseGenerator
    {
        // Yellow Database Section:
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
    }

    public static class DatabaseInteractor
    {
        public static final String ACTION_SOMETHING = "";

    }
}
