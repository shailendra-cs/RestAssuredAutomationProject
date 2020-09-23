import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Post_Request {
	
	@Test
	void VerifyMobileNumber()
	{
		
		//Specify BaseURI
		RestAssured.baseURI="https://iloyaltyadmin.cn.bmwgroup.com";

		//Request object
		RequestSpecification httprequest=RestAssured.given();

		JSONObject requestParams=new JSONObject();
		
		requestParams.put("clientCode","BMW");
		requestParams.put("mobileNo","1873096936");
		requestParams.put("countryCulture","en-US");
		requestParams.put("outputType","json");

		httprequest.body(requestParams.toJSONString());
		
		httprequest.header("access_token","nvSAYq+thobWCX2vI4oP9ZHNinE=");
		httprequest.header("Content-Type","application/json");
		
		//Response object
		Response response=httprequest.request(Method.POST,"/v1/services/Member.svc/VerifyMobileNo");
		
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//Status Code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:" +statusCode);
		Assert.assertEquals(statusCode,200);
		
		//Status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status Line is:" +statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
		
				
	}

}
