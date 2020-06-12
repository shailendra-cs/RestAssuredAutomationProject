import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

import loyaltyAPI.base.TestBase;

public class TC001_Get_Request extends TestBase {
	
	@BeforeTest
	public void GetCity() throws InterruptedException
	{
		
		log.debug("**********Started TC001_Get_Request************");

		//Specify BaseURI
		RestAssured.baseURI="https://dloyaltyadmin.cn.bmwgroup.com";

		//Request object
		httpRequest=RestAssured.given();
		System.out.println("Test");

		
		httpRequest.header("access_token","nvSAYq+thobWCX2vI4oP9ZHNinE=");
		httpRequest.header("Content-Type","application/json");
		
		//Response object
		response=httpRequest.request(Method.GET,"/v1/services/Master.svc/GetCity?clientCode=bmw&regionCode=&provinceCode=&outputType=json&countryCulture=en-us&dataFor=M");
		System.out.println(response);
		//return response;
		String contentType=response.header("Content-Type");
//		System.out.println(contentType);
		log.debug("Content-Type is:" +contentType);
		Assert.assertEquals(contentType,"application/json; charset=utf-8");
		
	}
	
//	@Test(priority=1)
//	void checkContentType() throws InterruptedException
//	{
//	log.debug("**********  Checking Content Type  ************");
//	
//	//Content Type verification
//	GetCity();
//	
//	String contentType=response.header("Content-Type");
//	System.out.println(contentType);
//	log.debug("Content-Type is:" +contentType);
//	Assert.assertEquals(contentType,"application/json; charset=utf-8");
//	}
//
	
	
	
	
		@Test(priority=9)
		public void Chectetst() throws InterruptedException
		{
			System.out.println("i am here");
			GetCity();
		}
			
		@Test(priority=1)
		void checkResponseBody()
		{
		log.debug("**********  Checking Response Body  ************");
		String responseBody = response.getBody().asString();
		log.debug("Response Body is:" +responseBody);
		Assert.assertTrue(responseBody!=null);
		}
		
		@Test(priority=2)
		void checkStatusCode()
		{
				//Status Code validation
		log.debug("**********  Checking Status Code  ************");
		int statusCode=response.getStatusCode();
		log.debug("Status Code is:" +statusCode);
		Assert.assertEquals(statusCode,200);
		}

		
		@Test(priority=3)
		void checkResponseTime()
		{
		log.debug("**********  Checking Response Time  ************");
		long responseTime=response.getTime();
		log.debug("Response Time is:" +responseTime);

		if(responseTime>2000)
			logger.warn("Response time is greater than 2000");
		
		Assert.assertTrue(responseTime<2000);
		}
		
		@Test(priority=4)
		void checkStatusLine()
		{
		log.debug("**********  Checking Status Line  ************");
		//Status line verification
		String statusLine=response.getStatusLine();
		log.debug("Status Line is:" +statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		}
		

		@Test(priority=5)
		void checkContentType() throws InterruptedException
		{
		log.debug("**********  Checking Content Type  ************");
		
		//Content Type verification
		GetCity();
		
		String contentType=response.header("Content-Type");
		System.out.println(contentType);
		log.debug("Content-Type is:" +contentType);
		Assert.assertEquals(contentType,"application/json; charset=utf-8");
		}

		@Test(priority=6)
		void checkServerType()
		{
		log.debug("**********  Checking Server Type  ************");
		//Content Type verification
		String serverType=response.header("Server");
		log.debug("Content-Type is:" +serverType);
		Assert.assertEquals(serverType,"Microsoft-IIS/8.5");
		}

		@Test(enabled=false)

		void checkContentEncoding()
		{
		log.debug("**********  Checking Content Encoding  ************");
		//Content Type verification
		String contentEncoding=response.header("Content-Encoding");
		log.debug("Content-Type is:" +contentEncoding);
		Assert.assertEquals(contentEncoding,"gzip");
		}
		
		@Test(priority=8)
		
		void checkContentLength()
		{
		log.debug("**********  Checking Content Length  ************");
		//Content Type verification
		String contentLength=response.header("Content-Length");
		log.debug("Content-Type is:" +contentLength);
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		}
		
		@AfterTest
		void tearDown()
		{
			log.debug("************* Finishing the Test   *************");

}	
}
