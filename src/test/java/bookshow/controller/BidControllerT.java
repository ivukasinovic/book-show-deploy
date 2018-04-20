package bookshow.controller;

import bookshow.domain.Bid;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Ivan V. on 16-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BidControllerT {


    @Test
    public void testGetBidByUsedProp() {
        RestAssured.given().header("Auth-Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWphbiIsImF1ZGllbmNlIjoid2ViIiwicm9sZSI6IlVTRVIiLCJjcmVhdGVkIjoxNTIzODgzNTY3MTE2LCJleHAiOjE1MjQ0ODgzNjd9.0TRDhwEinCnIKAofmgqBfJN2lU71_uiQwF0ZlROvGdR32ySxEIAV8cnVjRCkWp8sflgNU-Fg5wBi2YYKXMBEpA")
                .when()
                .get("/api/bids/used-prop/2")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .body("id", CoreMatchers.hasItems(2));
    }

    @Test
    public void testCreateBid() {
        Bid bid = new Bid();
        bid.setDateCreated(new java.util.Date());
        bid.setPrice(410);

        RestAssured.given()
                .header("Auth-Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbmZhbiIsImF1ZGllbmNlIjoid2ViIiwicm9sZSI6IkFETUlORkFOIiwiY3JlYXRlZCI6MTUyNDAwMjU0MTkwOSwiZXhwIjoxNTI0NjA3MzQxfQ.eNfl1znaS5Tqhe1dF0mI6ZujcereIhSb4rUSr0JoBKSsSV7BHCB2zuhhuZa1vE-DZYvi6aWWCs_eRPnPa4l36Q")
                .body(bid)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/bids/2")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .contentType(ContentType.JSON)
                .body("price", CoreMatchers.equalTo(410));
    }

    @Test
    public void testGetBid() {
        RestAssured.given().header("Auth-Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZWphbiIsImF1ZGllbmNlIjoid2ViIiwicm9sZSI6IlVTRVIiLCJjcmVhdGVkIjoxNTIzODgzNTY3MTE2LCJleHAiOjE1MjQ0ODgzNjd9.0TRDhwEinCnIKAofmgqBfJN2lU71_uiQwF0ZlROvGdR32ySxEIAV8cnVjRCkWp8sflgNU-Fg5wBi2YYKXMBEpA")
                .when()
                .get("/api/bids/2")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .body("price", CoreMatchers.equalTo(260));
    }
}
