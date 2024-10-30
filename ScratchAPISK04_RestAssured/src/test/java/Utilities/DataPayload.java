package Utilities;

import java.util.HashMap;
import java.util.Map;

public class DataPayload {
	
	public static Map dataPayload()
	{
		Map<String,Object> mp=new HashMap<String,Object>();
		mp.put("name","Harry");
		mp.put("gender","male");
		mp.put("email",ReUsableMethods.generateRandomEmail());
		mp.put("status","active");
		
		return mp;
		
	}
	
	
	

}
