package hockey.icescore.controllers;

/**
 * Created by Lucas Angelon on 01-Apr-15.
 */
public class Action
{

    // Method to insert Shots, Goals and Assists - Lucas
    public String action(int playerId, int actionId, int teamId,
                         int periodId, int gameId, String timestamp)
    {
        String insertStatement = "INSERT INTO GAME_PERSON_ACTION " +
                "VALUES("
                + playerId + ", "
                + actionId + ", "
                + teamId + ", "
                + periodId + ", "
                + gameId + ", "
                + timestamp +
                ")";

        return insertStatement;
    }

    // Method to insert Penalties and Injuries - Lucas
    public String actionExtended(int playerId, int actionId, int teamId,
                                 int periodId, int gameId, String timestamp,
                                 int[] extendedActionIds, String notes)
    {
        // Declaring the extendedActionId holders.
        int penaltyId = 0;
        int injuryId = 0;

        // If the action is not a penalty or an injury, return an error message.
        if (actionId != 4 & actionId != 5)
        {
            return "ERROR 1: Invalid Action Detected.";
        }
        else if (actionId == 4)
        {
            penaltyId = actionId;
        }
        else if (actionId == 5)
        {
            injuryId = actionId;
        }

        // Insert the base penalty/injury action into a table.
        String insertAction = action(playerId, actionId, teamId,
                periodId, gameId, timestamp);

        // Retrieve the ID from the aforementioned entry.
        String retrieveInsertActionId = "SELECT ID FROM GAME_PERSON_ACTION " +
                "WHERE TIMESTAMP = " + timestamp;
        int retrievedId = 0;

        String extendedAction = "INSERT INTO GAME_PERSON_ACTION_EXTENDED " +
                "VALUES("
                + retrievedId + ", "
                + penaltyId + ", "
                + injuryId + ", "
                + notes +
                ")";

        return "Action Successfully saved!";
    }
}
