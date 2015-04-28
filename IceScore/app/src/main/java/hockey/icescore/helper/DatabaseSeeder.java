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
            for (Role role : roles) {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, role.getName());

               writeDb.insert(Constants.TABLE_ROLE, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 6: Unable to seed Roles.";
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
            for (Identifier identifier : identifiers) {
                ContentValues values = new ContentValues();
                values.put(Constants.FIELD_NAME, identifier.getName());

                writeDb.insert(Constants.TABLE_IDENTIFIER, null, values);
            }

            writeDb.setTransactionSuccessful();
        }
        catch (SQLiteException e)
        {
            return "ERROR 7: Unable to seed Identifiers.";
        }
        finally
        {
            writeDb.endTransaction();
        }

        return "Successfully seeded Identifiers!";
    }
}
