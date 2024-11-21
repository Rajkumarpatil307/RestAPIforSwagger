package SwaggerAPITest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SwaggerUI {


@Test
    public void createWithListPost() {
        Response postListResponse = given()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"rajkumarpatil30\",\n" +
                        "    \"firstName\": \"Rajkumar\",\n" +
                        "    \"lastName\": \"Patil\",\n" +
                        "    \"email\": \"rajkumar@gmail.com\",\n" +
                        "    \"password\": \"raju1234\",\n" +
                        "    \"phone\": \"8431252665\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");

        Assert.assertEquals(postListResponse.getStatusCode(), 200);
    }
    @Test
    public void getUserByUsername() {

        Response getUserResponse = given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .queryParam("username", "rajkumarpatil30")
                .when()
                .get("https://petstore.swagger.io/v2/user/rajkumarpatil30" );

        Assert.assertEquals(getUserResponse.getStatusCode(), 200);
    }
    @Test
    public void updateUserByUsername() {
        Response putResponse = given()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"rajkumarpatil30\",\n" +
                        "  \"firstName\": \"Raju\",\n" +
                        "  \"lastName\": \"Patil\",\n" +
                        "  \"email\": \"rajkumarpatil0501784@gmail.com\",\n" +
                        "  \"password\": \"RajuPatil@1234\",\n" +
                        "  \"phone\": \"8431252665\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/rajkumarpatil30");

        Assert.assertEquals(putResponse.getStatusCode(), 200);
    }
    @Test
    public void deleteUserByUsername() {
        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .queryParam("username", "ramkumar26")
                .when()
                .delete("https://petstore.swagger.io/v2/user/ramkumar26");

        Assert.assertEquals(deleteResponse.getStatusCode(), 200);


    }
    @Test
    public void loginUser() {


        Response loginResponse = given()
                .accept("application/json")
                .queryParam("username", "rajkumarpatil30")
                .queryParam("password", "raju1234")
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/rajkumarpatil30" );

        Assert.assertEquals(loginResponse.getStatusCode(), 200);
    }

    @Test
    public void createWithArrayPost() {
        Response postArrayResponse = given()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"username\": \"darshan14\",\n" +
                        "    \"firstName\": \"Darshan\",\n" +
                        "    \"lastName\": \"PL\",\n" +
                        "    \"email\": \"darshan@gmail.com\",\n" +
                        "    \"password\": \"d12345\",\n" +
                        "    \"phone\": \"85654246425\",\n" +
                        "    \"userStatus\": 3\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"username\": \"sudhir25\",\n" +
                        "    \"firstName\": \"Sudhir\",\n" +
                        "    \"lastName\": \"Pawar\",\n" +
                        "    \"email\": \"sudhir@gmail.com\",\n" +
                        "    \"password\": \"sudhir123\",\n" +
                        "    \"phone\": \"9843235632\",\n" +
                        "    \"userStatus\": 4\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");

        Assert.assertEquals(postArrayResponse.getStatusCode(), 200);
    }
    @Test
    public void createUserPost() {
        Response createUserResponse = given()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"username\": \"ramkumar26\",\n" +
                        "  \"firstName\": \"Ramkumar\",\n" +
                        "  \"lastName\": \"Dahariya\",\n" +
                        "  \"email\": \"ram@gmail.com\",\n" +
                        "  \"password\": \"1234\",\n" +
                        "  \"phone\": \"985642364\",\n" +
                        "  \"userStatus\": 2\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");

        Assert.assertEquals(createUserResponse.getStatusCode(), 200);
    }
    /* ------------------------------- Store --------------------------------------------------*/
   @Test
    public void getInventory() {
        Response inventoryResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");

        Assert.assertEquals(inventoryResponse.getStatusCode(), 200);
    }

@Test
public void placeOrderPost() {
        Response orderResponse = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": \"001\",\n" +
                        "  \"quantity\": \"1\",\n" +
                        "  \"shipDate\": \"2024-11-13T12:14:39.116Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");

        Assert.assertEquals(orderResponse.getStatusCode(), 200);
    }
@Test
    public void findOrderByIdGet() {

        Response orderResponse = given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1)
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1" );

        Assert.assertEquals(orderResponse.getStatusCode(), 404);
    }
@Test
    public void deleteOrderById() {

        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1)
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1" );

        Assert.assertEquals(deleteResponse.getStatusCode(), 200);


    }

/******************************** PET *************************************** */

@Test
public void uploadImagePost() {

    Response uploadResponse = given()
            .multiPart("file", "C:\\Users\\DELL\\Downloads\\dogImage.jpg")
            .queryParam("petId",1)
            .when()
            .post("https://petstore.swagger.io/v2/pet/1/uploadImage" );

    Assert.assertEquals(uploadResponse.getStatusCode(), 200);
}

    @Test
    public void addPetPost() {
        Response addPetResponse = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        Assert.assertEquals(addPetResponse.getStatusCode(), 200);
    }

    @Test
    public void updatePetPut() {
        Response updatePetResponse = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": \"01\",\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": \"02\",\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": \"01\",\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": \"02\",\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");

        Assert.assertEquals(updatePetResponse.getStatusCode(), 200);
    }

    @Test
    public void findPetsByStatusGet() {

        Response findByStatusResponse = given()
                .contentType(ContentType.JSON)
                .queryParam("status", "available")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        Assert.assertEquals(findByStatusResponse.getStatusCode(), 200);
    }

    @Test
    public void findPetsByTagsGet() {
        String tags = "friendly";
        Response findByTagsResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://your-api-endpoint.com/pet/findByTags?tags=" + tags);

        Assert.assertEquals(findByTagsResponse.getStatusCode(), 200);
    }

    @Test
    public void findPetByIdGet() {

        Response findByIdResponse = given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1)
                .when()
                .get("https://petstore.swagger.io/v2/pet/001");

        Assert.assertEquals(findByIdResponse.getStatusCode(), 200);
    }

    @Test
    public void updatePetWithFormDataPost() {
        Response updateFormResponse = given()
                .queryParam("petId",1)
                .formParam("name", "Buddy New Name")
                .formParam("status", "available")
                .when()
                .post("https://petstore.swagger.io/v2/pet/001");

        Assert.assertEquals(updateFormResponse.getStatusCode(), 404);
    }

    @Test
    public void deletePetByIdDelete() {

        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .queryParam("id", 1)
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1");

        Assert.assertEquals(deleteResponse.getStatusCode(), 404);

    }

}

