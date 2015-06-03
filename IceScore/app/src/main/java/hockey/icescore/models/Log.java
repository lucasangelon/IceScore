package hockey.icescore.models;

import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;

/**
 * Created by Lucas Angelon on 07-Apr-15.
 */
public class Log
{
    public static boolean loadDummyData = true;
    // Empty constructor.
    public Log()
    {    }

    public long getPeriodId(){
        return 0;
    };
    public long getId() { return 0;};

    // Log object for saves.
    public class Save extends Log
    {
        protected long id;
        protected String goalieNumber;
        protected String shotTeam;
        protected String timestamp;
        protected long periodId;

        public long getId() {
            return id;
        }

        // Empty Constructor
        public Save ()
        {   }

        // Save Log Constructor
        public Save(long id, String gn, String st, String t)
        {
            this.id = id;
            this.goalieNumber = gn;
            this.shotTeam = st;
            this.timestamp = t;
            periodId = Game.currentPeriod;
        }
        @Override
        public long getPeriodId() {
            return periodId;
        }

        public void setPeriodId(long periodId) {
            this.periodId = periodId;
        }

        // Method for extracting the content for the game log.
        public String extract()
        {
            return timestamp + " Shot by team: " + shotTeam + ", Saved by goalie: " + goalieNumber + ".";
        }
        @Override
        public String toString()
        {
            return timestamp + " Shot by team: " + shotTeam + ", Saved by goalie: " + goalieNumber + "Period Id:" + periodId;
        }
    }

    // Log object for goals.
    public class Goal extends Log
    {
        public long getId() {
            return id;
        }

        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;
        protected String assistNumber;
        protected String assistNumber2;
        protected long periodId;
        // Empty Constructor
        public Goal()
        {
        }

        // Goal Log Constructor
        public Goal(long id, String pNum, String tn, String ts, String asn, String asn2)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.assistNumber = asn;
            this.assistNumber2 = asn2;
            periodId = Game.currentPeriod;
        }

        // Method for extracting the content for the game log.
        public String extract()
        {
            return timestamp + " Goal, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Assists: " + assistNumber + ", " + assistNumber2 + ".";
        }

        @Override
        public String toString()
        {
            return timestamp + " Goal, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Assists: " + assistNumber + ", " + assistNumber2 + "Period Id:" + periodId;
        }
        @Override
        public long getPeriodId()
        {
            return periodId;
        }


    }

    // Log object for penalties.
    public class Penalty extends Log
    {
        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;
        protected String penaltyName;
        protected long periodId;

        // Empty Constructor
        public Penalty()
        {   }
        public long getId() {
            return id;
        }
        // Penalty Log Constructor
        public Penalty(long id, String pNum, String tn, String ts, String pn)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.penaltyName = pn;
            periodId = Game.currentPeriod;
        }
        @Override
        public long getPeriodId()
        {
            return periodId;
        }

        public String extract()
        {
            return timestamp + " Penalty, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Penalty Name: " + penaltyName + ".";
        }
        public String toString()
        {
            return timestamp + " Penalty, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Penalty Name: " + penaltyName + "Period Id:" + periodId;
        }
    }

    // Log object for injuries.
    public class Injury extends Log
    {
        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;
        protected String injuryName;
        protected long periodId;

        // Injury Log Constructor
        public Injury(long id, String pNum, String tn, String ts, String in)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.injuryName = in;
            periodId = Game.currentPeriod;
        }
        public long getId() {
            return id;
        }
        @Override
        public long getPeriodId()
        {
            return periodId;
        }

        public String extract()
        {
            return timestamp + " Injury, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Injury Name: " + injuryName + ".";
        }
        @Override
        public String toString()
        {
            return timestamp + " Injury, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Injury Name: " + injuryName + "Period Id:" + periodId;
        }
    }

    // Log object for timeouts.
    public class Timeout extends Log
    {
        protected long id;
        protected String teamName;
        protected String timestamp;
        protected long periodId;

        // Timeout Log Constructor
        public Timeout(long id, String teamName, String timestamp)
        {
            this.id = id;
            this.teamName = teamName;
            this.timestamp = timestamp;
            periodId = Game.currentPeriod;
        }
        public long getId() {
            return id;
        }
        @Override
        public long getPeriodId()
        {
            return periodId;
        }

        public String extract()
        {
            return timestamp + " Timeout requested by: " + teamName + ".";
        }
        @Override
        public String toString()
        {
            return timestamp + " Timeout requested by: " + teamName + "Period Id:" + periodId;
        }
    }

    // Log object for change of goalies in-game.
    public class ChangeGoalie extends Log
    {
        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;
        protected long periodId;

        // Change Goalie Log Constructor.
        public ChangeGoalie(long id, String playerNumber, String teamName, String timestamp)
        {
            this.id = id;
            this.playerNumber = playerNumber;
            this.teamName = teamName;
            this.timestamp = timestamp;
            periodId = Game.currentPeriod;
        }
        public long getId() {
            return id;
        }
        @Override
        public long getPeriodId()
        {
            return periodId;
        }

        public String extract()
        {
            return timestamp + " Goalie changed for team: " + teamName + ", Player: " +
                    playerNumber + ".";
        }
        @Override
        public String toString()
        {
            return timestamp + " Goalie changed for team: " + teamName + ", Player: " +
                    playerNumber + "Period Id:" + periodId;
        }
    }

    // Log object for game periods.
    public class GamePeriod extends Log
    {
        protected long id;

        // Game Period Log Constructor
        public GamePeriod(long id)
        {
            this.id = id;
        }


        private long extract()
        {
            return id;
        }
        @Override
        public String toString()
        {
            return "ID:" + id ;
        }
        @Override
        public long getPeriodId()
        {
            return 0;
        }


    }

    // Log object for game notes.
    public class GameNote extends Log
    {
        protected long id;
        protected String notes;

        // GameNote Log Constructor
        public GameNote(long id, String notes)
        {
            this.id = id;
            this.notes = notes;
        }

        @Override
        public String toString()
        {
            return "Notes:" + notes;
        }
        @Override
        public long getPeriodId()
        {
            return 6;
        }
    }
}
