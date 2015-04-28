package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 07-Apr-15.
 */
public class Log
{
    // Empty constructor.
    public Log()
    {    }

    // Log object for goals.
    public class Goal extends Log
    {
        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;
        protected String assistNumber;
        protected String assistNumber2;

        // Empty Constructor
        public Goal()
        {   }

        // Goal Log Constructor
        public Goal(long id, String pNum, String tn, String ts, String asn, String asn2)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.assistNumber = asn;
            this.assistNumber2 = asn2;
        }

        // Method for extracting the content for the game log.
        private String extract()
        {
            return timestamp + " Goal, Team: " + teamName + ", Player: " + playerNumber + ", " +
                "Assists: " + assistNumber + ", " + assistNumber2 + ".";
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

        // Empty Constructor
        public Penalty()
        {   }

        // Penalty Log Constructor
        public Penalty(long id, String pNum, String tn, String ts, String pn)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.penaltyName = pn;
        }

        private String extract()
        {
            return timestamp + " Penalty, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Penalty Name: " + penaltyName + ".";
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

        // Injury Log Constructor
        public Injury(long id, String pNum, String tn, String ts, String in)
        {
            this.id = id;
            this.playerNumber = pNum;
            this.teamName = tn;
            this.timestamp = ts;
            this.injuryName = in;
        }

        private String extract()
        {
            return timestamp + " Injury, Team: " + teamName + ", Player: " + playerNumber + ", " +
                    "Injury Name: " + injuryName + ".";
        }
    }

    // Log object for timeouts.
    public class Timeout extends Log
    {
        protected long id;
        protected String teamName;
        protected String timestamp;

        // Timeout Log Constructor
        public Timeout(long id, String teamName, String timestamp)
        {
            this.id = id;
            this.teamName = teamName;
            this.timestamp = timestamp;
        }

        private String extract()
        {
            return timestamp + " Timeout requested by: " + teamName + ".";
        }
    }

    // Log object for change of goalies in-game.
    public class ChangeGoalie extends Log
    {
        protected long id;
        protected String playerNumber;
        protected String teamName;
        protected String timestamp;

        // Change Goalie Log Constructor.
        public ChangeGoalie(long id, String playerNumber, String teamName, String timestamp)
        {
            this.id = id;
            this.playerNumber = playerNumber;
            this.teamName = teamName;
            this.timestamp = timestamp;
        }

        private String extract()
        {
            return timestamp + " Goalie changed for team: " + teamName + ", Player: " +
                    playerNumber + ".";
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

        private String extract()
        {
            return notes;
        }
    }
}