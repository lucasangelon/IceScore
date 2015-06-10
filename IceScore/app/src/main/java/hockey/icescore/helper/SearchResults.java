package hockey.icescore.helper;

/**
 * Created by Suchi on 7/04/15.
 */
public class SearchResults {

        private String homeTeamName = "";
        private String awayTeamName = "";
        private String venue = "";
        private String date="";
        private String time ="";



        public void setHomeTeamName(String name) {
            this.homeTeamName = name;
        }

        public String getHomeTeamName() {
            return homeTeamName;
        }

        public void setAwayTeamName(String awayTeamName) {
            this.awayTeamName = awayTeamName;
        }

        public String getAwayTeamName() {
            return awayTeamName;
        }

        public void setVenue(String venue) {
            this.venue = venue;
        }

        public String getVenue() {
            return venue;
        }

        public void setDate(String date){
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setTime(String time){
            this.time = time;
        }

        public String getTime() {
            return time;
        }
}
