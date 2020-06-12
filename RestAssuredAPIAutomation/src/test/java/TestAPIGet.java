
 

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import loyaltyAPI.base.TestBase;

 

public class TestAPIGet extends TestBase {
    
    
    @Test
    public Response GetCity(){
        //Specify BaseURI
                RestAssured.baseURI="https://dloyaltyadmin.cn.bmwgroup.com";
                // RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

 

                //Request object
                //httpRequest=RestAssured.given();
                 RequestSpecification httpRequest=RestAssured.given();
                 System.out.println("Test");

 

                
                httpRequest.header("access_token","nvSAYq+thobWCX2vI4oP9ZHNinE=");
                httpRequest.header("Content-Type","application/json");
                
                //Response object
                 Response response ;
                response=httpRequest.request(Method.GET,"/v1/services/Master.svc/GetCity?clientCode=bmw&regionCode=&provinceCode=&outputType=json&countryCulture=en-us&dataFor=M");
                System.out.println(response);
                //return response;
                String contentType=response.header("Content-Type");
                System.out.println(contentType);
                //logger.info("Content-Type is:" +contentType);
                Assert.assertEquals(contentType,"application/json; charset=utf-8");
                
                return response;
    }

    @Test(priority=1)
    void checkContentType() throws InterruptedException
    {
    logger.info("**********  Checking Content Type  ************");
    Response response ;
   
   
    //Content Type verification
    response=GetCity();
   
    String contentType=response.header("Content-Type");
    System.out.println(contentType);
    logger.info("Content-Type is:" +contentType);
    Assert.assertEquals(contentType,"application/json; charset=utf-8");
    }

}