package loyaltyAPI.base;

import java.io.IOException;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	
	
	public static Logger logger;
	protected Logger log = Logger.getLogger("devpinoyLogger");

	public void TestDataSetup() throws IOException
	{
		PropertyConfigurator.configure(".\\RestAssuredAPIAutomation\\src\\main\\java\\log4j.properties");

//	String log4jConfPath = "E:\\Pushkar_Automation\\TestProject\\RestAussuredLearning\\src\\apicode\\log4j.properties";		
//	    PropertyConfigurator.configure(log4jConfPath);

	                log.debug("opening webiste");
	                log.debug("--information--");

//		logger=Logger.getLogger("Logger_File");
	}
	
//	@BeforeClass
//	public void setup(){
//		
//	}

}
