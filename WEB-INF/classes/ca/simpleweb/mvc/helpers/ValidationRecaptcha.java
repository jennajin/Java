/**********************************************************************************
 * Verify reCaptcha
 *********************************************************************************/

package ca.simpleweb.mvc.helpers;

import java.io.*;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

public class ValidationRecaptcha {
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LekinYUAAAAAIdRKX4uALuJop7y36pWs84OXbBl";
	private static final String USER_AGENT = "Mozilla/5.0";

	public boolean isValidRecaptcha(String recaptcha) throws IOException {
		if (recaptcha == null || "".equals(recaptcha)) {
			return false;
		}
		
		try{
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			String param = "secret=" + secret + "&response=" + recaptcha;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream output = new DataOutputStream(con.getOutputStream());
			output.writeBytes(param);
			output.flush();
			output.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			//parse JSON response 
			JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();
			return jsonObject.getBoolean("success");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}

