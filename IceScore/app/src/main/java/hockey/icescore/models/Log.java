package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 07-Apr-15.
 */
public class Log
{

    protected class Action
    {
        protected long id;
        protected String playerNumber;
        protected String team;
        protected String action;
        protected String timestamp;
        protected String dbTable;

        public Action (long id, String pNum, String t, String a, String ts, String dbt)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.team = t;
            this.action = a;
            this.timestamp = ts;
            this.dbTable = dbt;
        }

        // Method for extracting the content for the game log. Returns:
        // Actions, Extended Actions.
        public String extract()
        {
            return "Time: " + timestamp + ", Action: " + action + ", Team: " + team + ", Player: " + playerNumber + ".";
        }
    }
}