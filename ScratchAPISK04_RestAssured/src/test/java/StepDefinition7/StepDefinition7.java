package StepDefinition7;

import Utilities.DataPayload;
import Utilities.FetchDataFromProperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.*;

import org.testng.Assert;

import POJOMapper.CreateUser;

public class StepDefinition7 {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	
    Response response_API;
	
	
	String URL=FetchDataFromProperty.readDataFromProperty().getProperty("baseURI");
	String Expected_status_code=FetchDataFromProperty.readDataFromProperty().getProperty("post_Status_code");
	String URL_new=FetchDataFromProperty.readDataFromProperty().getProperty("baseURI_new");
	String Token=FetchDataFromProperty.readDataFromProperty().getProperty("token");
	
	@Given("User will hit a specific URL on reqres site")
	public void user_will_hit_a_specific_url_on_reqres_site() {
		
		req=new RequestSpecBuilder().setBaseUri(URL).setContentType(ContentType.JSON)
				.build();
		
	    
	}

	@Given("User will pass the payload and header in the request specified")
	public void user_will_pass_the_payload_and_header_in_the_request_specified() {
	   
	res=	given().log().all().relaxedHTTPSValidation().spec(req)
		.body(CreateUser.createUser());
		
		
		
	}

	@When("the user is going to hit the {string}")
	public void the_user_is_going_to_hit_the(String endpoint) {
		
		respec=new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();
		
		
		response_API=	res.when().post(endpoint).then().log().all().spec(respec)
		.extract().response();
		
		
		
		
		
		
		
		
	    
	}

	@Then("the User is going to validate the response with the status code as {string}")
	public void the_user_is_going_to_validate_the_response_with_the_status_code_as(String string) {
	   
	
		int x=Integer.parseInt(Expected_status_code);
	int actual_statusCode=	response_API.getStatusCode();
	
	Assert.assertEquals(actual_statusCode, x);
	
	
	
	
		
		
	}
	
	@Given("User hits an application url")
	public void user_hits_an_application_url() {
		
		req=new RequestSpecBuilder().setBaseUri(URL_new).setContentType(ContentType.JSON)
				.build();
		
		
	   
	}

	@Given("the User passes the payload with all required details")
	public void the_user_passes_the_payload_with_all_required_details() {
		
		res=	given().log().all().relaxedHTTPSValidation().spec(req).
				header("Authorization",Token)
				.body(DataPayload.dataPayload());
				
		
		
	    
	}

	@When("the User will hit the url with the {string}")
	public void the_user_will_hit_the_url_with_the(String endpoint) {
		
		respec=new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.build();
		
		
		response_API=	res.when().post(endpoint).then().log().all().spec(respec)
		.extract().response();
		
	    
	}

	@Then("the User will be able to validate the reponse with a specific status code")
	public void the_user_will_be_able_to_validate_the_reponse_with_a_specific_status_code() {
	    
		
		int x=Integer.parseInt(Expected_status_code);
		int actual_statusCode=	response_API.getStatusCode();
		
		Assert.assertEquals(actual_statusCode, x);
		
		
	}
	
	
	
	
	
	


}
