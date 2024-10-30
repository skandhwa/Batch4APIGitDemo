package Utilities;

import static io.restassured.RestAssured.given;

import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	
	
	public static String generateRandomString(int min, int max) {
        String signsSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprqstuvwxyz";
        char[] chars = signsSet.toCharArray();
        String randString = "";
        Random rand = new Random();
        int length = rand.nextInt((max - min) + 1) + min;
        while (length > 0) {
            randString += chars[rand.nextInt(chars.length)];
            length--;
        }
        return randString;
    }
 
 public static String generateRandomEmail() {
        String str1 = generateRandomString(3, 15);
        String str2 = generateRandomString(3, 15);
        String str3 = generateRandomString(3, 15);
        return String.format("%s.%s@%s.com", str1, str2, str3);
    }
 
 
 public static String getAccessToken()
	{
	 String access_token;
		String client_id="ASyStlg4z4BjlmHNrXnDSLwFzY6j8NwPPE16opmTNUxHYf1IXRThQgb3ZN9uWeq3byeJPHlGXp_Gk2f7";
		String client_secret_id="ECKYHfIutJTW9x6PgRFePjsHJPH5MAomf34tbLqp7xmeckGaZGwM083k7ZHrY1cSnW18IYZcNKOH_chu";
		
		RestAssured.baseURI="https://api-m.sandbox.paypal.com";
		
String Response=		given().log().all().auth().preemptive().basic(client_id, client_secret_id)
		.param("grant_type","client_credentials")
		.when().post("v1/oauth2/token")
		.then().log().all().extract().response().asString();
		
		JsonPath js=new JsonPath(Response);
		access_token=	js.getString("access_token");
	System.out.println(access_token);
	
	return access_token;
	
		
	}


}
