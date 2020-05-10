package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class E2ETest {

    public static void main(String[] args) {
        String baseUrl = "http://bookstore.toolsqa.com";
        String userId = "ab60d46d-7723-492d-a914-ec1669bc3965";
        String userName = "thanhnd1";
        String password = "Selenium@123456";
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();

        //Step 1
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", userName);
        requestParams.put("password", password);
        Response response = request.body(requestParams.toJSONString())
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("token"));
        String token = JsonPath.from(responseBody).get("token");
        System.out.println("token: "+token);

        //Step 2
        response = request.get("/BookStore/v1/Books");
        Assert.assertEquals(response.getStatusCode(), 200);
        responseBody = response.getBody().asString();
        List<Map<String, String>> books = JsonPath.from(responseBody).get("books");
        Assert.assertTrue(books.size() > 0);
        String bookId = books.get(0).get("isbn");

        //Step 3
        request.header("Authorization", "Bearer "+token)
                .header("Content-type", "application/json");
        requestParams.clear();
        JSONObject isbn = new JSONObject();
        isbn.put("isbn", bookId);
        JSONArray collectionOfIsbns = new JSONArray();
        collectionOfIsbns.add(isbn);
        requestParams.put("userId", userId);
        requestParams.put("collectionOfIsbns", collectionOfIsbns);
        response = request.body(requestParams.toJSONString()).post("/BookStore/v1/Books");
        Assert.assertEquals(response.getStatusCode(), 201);

        //Step 4
        request.header("Authorization", "Bearer "+token)
                .header("Content-type", "application/json");

        requestParams.clear();
        requestParams.put("isbn", bookId);
        requestParams.put("userId", userId);
        response = request.body(requestParams.toJSONString()).delete("/BookStore/v1/Book");
        Assert.assertEquals(response.getStatusCode(), 204);

        //Step 5
        request.header("Authorization", "Bearer "+token)
                .header("Content-type", "application/json");

        response = request.get("/Account/v1/User/"+userId);
        Assert.assertEquals(response.getStatusCode(), 200);
        List<Map<String, String>> bookOfUser = JsonPath.from(response.getBody().asString()).get("books");
        Assert.assertEquals(bookOfUser.size(), 0);
    }
}
