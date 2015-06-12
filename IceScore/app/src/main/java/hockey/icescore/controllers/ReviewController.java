package hockey.icescore.controllers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.Game;
import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 03-Jun-15.
 */

/* Retrieved from http://www.androidhive.info/2012/06/android-populating-spinner-data-from-sqlite-database/ */
public class ReviewController
{
    private DatabaseManager dbManager;
    private Context context;
    private SQLiteDatabase sqlDb;

    // Constructor
    public ReviewController(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
        sqlDb = dbManager.getReadableDatabase();
    }

    public List<String> getArrayAdapter()
    {
        List<String> games = new ArrayList<String>();


        Cursor cursor = sqlDb.rawQuery("SELECT * FROM " + Constants.TABLE_GAME, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Game currentGame = new Game(Long.parseLong(cursor.getString(1)),
                        Long.parseLong(cursor.getString(2)),
                        Long.parseLong(cursor.getString(3)),
                        Long.parseLong(cursor.getString(4)),
                        Long.parseLong(cursor.getString(5)),
                        Long.parseLong(cursor.getString(6)),
                        Long.parseLong(cursor.getString(7)),
                        Long.parseLong(cursor.getString(8)),
                        Long.parseLong(cursor.getString(9)),
                        cursor.getString(10));

                currentGame.setId(Long.parseLong(cursor.getString(0)));

                String venue = "", homeTeam = "", awayTeam = "";

                getVenueName(currentGame.getVenueId());
                getTeamName(currentGame.getHomeTeamId());
                getTeamName(currentGame.getAwayTeamId());

                games.add(currentGame.getId() + " Venue: " + venue + ", Home Team: " + homeTeam + ", Away Team: " + awayTeam + ", Date: " + currentGame.getDate());
                cursor.moveToNext();
            }
            while (!cursor.isLast());
        }

        return games;
    }

    public String getVenueName(long id)
    {
        String venueName = "";
        Cursor cursor = sqlDb.rawQuery("SELECT name FROM "+Constants.TABLE_VENUE+" WHERE id = ?",new String[]{""+id});

        if (cursor.moveToFirst())
        {
            venueName = cursor.getString(0);
        }

        return venueName;
    }

    public String getTeamName(long id)
    {
        String teamName = "";

        Cursor cursor = sqlDb.rawQuery("SELECT NAME FROM " + Constants.TABLE_TEAM + " WHERE id = " + id, null);

        if (cursor.moveToFirst())
        {
            teamName = cursor.getString(0);
        }

        return teamName;
    }

    public int getDivision(long id)
    {
        int division = 0;

        Cursor cursor = sqlDb.rawQuery("SELECT name FROM " + Constants.TABLE_DIVISION + " WHERE id = " + id, null);

        if (cursor.moveToFirst())
        {
            division = Integer.parseInt(cursor.getString(0));
        }

        return division;
    }
}
