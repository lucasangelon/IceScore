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
                    "Penalty Name: " + injuryName + ".";
        }
    }

    protected class Timeouts
    {

    }
}