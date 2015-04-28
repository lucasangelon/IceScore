package hockey.icescore.helper;

/**
 * Created by Suchi on 7/04/15.
 */
public class SearchResults {

        private String name = "";
        private String cityState = "";
        private String phone = "";
        private String date="";
        private String time ="";



        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCityState(String cityState) {
            this.cityState = cityState;
        }

        public String getCityState() {
            return cityState;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
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
