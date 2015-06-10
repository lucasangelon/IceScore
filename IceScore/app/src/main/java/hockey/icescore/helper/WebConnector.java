package hockey.icescore.helper;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.io.Reader;

import hockey.icescore.helper.ConfigContent;

/**
 * Created by 041402465 on 9/06/2015.
 */
public class WebConnector {
    private final static String EMPLOYEE_SERVICE_URI = "http://student.mydesign.central.wa.edu.au/IceWA_Virtual/IceWAService.svc/";


    public static ConfigContent tryGet(String method) {
        try {

            Log.d("Internet", "connecting");
            DefaultHttpClient client = new DefaultHttpClient();

            // http get request
            Log.d("Internet", "creating request");
            HttpGet request = new HttpGet(EMPLOYEE_SERVICE_URI+method);
            Log.d("Internet", "made request");

            // set the hedear to get the data in JSON formate
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            //get the response
            Log.d("Internet", "Executing request");
            HttpResponse response = client.execute(request);
            Log.d("Internet", "success");
            Log.d("Internet", "gettingrepsonse");
            HttpEntity entity = response.getEntity();
            Log.d("Internet", "success");
            //if entity contect lenght 0, means no employee exist in the system with these code
            if (entity.getContentLength() != 0) {
                // stream reader object
                Reader employeeReader = new InputStreamReader(response.getEntity().getContent());
                //create a buffer to fill if from reader
                char[] buffer = new char[(int) response.getEntity().getContentLength()];
                //fill the buffer by the help of reader
                employeeReader.read(buffer);
                //close the reader streams
                employeeReader.close();

                //for the employee json object
                JSONObject employee = new JSONObject(new String(buffer));

                JSONObject jobj = employee.getJSONObject(method+"Result");
                JSONArray jarr = jobj.getJSONArray("content");
                String temp[] = new String[jarr.length()];
                Log.d("content", employee.getJSONObject(method+"Result").getJSONArray("content").length() + "");
                for (int count = 0; count < jarr.length() - 1; count++) {

                    String ts = jarr.getString(count);
                    temp[count] = ts;
                }
                //set the text of text view
                //temp[jarr.length() - 1] = "[END]";
                ConfigContent content = ConfigLoader.returnConfigContentFromStrings(temp);

                return content;
            }

        } catch (Exception e) {
            return null;
        }
        return null;
    }
}


