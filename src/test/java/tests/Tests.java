package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import testData.TestData;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;
import static testData.TestData.*;

public class Tests {

    TestData testData = new TestData();

    @Test
    public void checkCreateBooking_JohnMacintosh(){
        int bookingId_Macintosh =

        given().
            contentType(ContentType.JSON).
            spec(requestSpecBaseUrl).
            body(createNewBookingRequest_JohnMacintosh).
            log().all().
        when().
            post().
        then().
            assertThat().
            statusCode(200).
            extract().
            path("bookingid");

        testData.setBookingId_Macintosh(bookingId_Macintosh);
        System.out.println(testData.getBookingId_Macintosh());
    }

    @Test
    public void checkCreateBooking_DeeJay(){
        int bookingId_DeeJay =

        given().
            contentType(ContentType.JSON).
            spec(requestSpecBaseUrl).
            body(createNewBookingRequest_DeeJay).
            log().all().
        when().
            post().
        then().
            assertThat().
            statusCode(200).
            extract().
            path("bookingid");

        testData.setBookingId_DeeJay(bookingId_DeeJay);
    }

    @Test
    public void checkCreateBooking_BloomyReachson(){
        int bookingId_Reachson =

        given().
            contentType(ContentType.JSON).
            spec(requestSpecBaseUrl).
            body(createNewBookingRequest_BloomyReachson).
            log().all().
        when().
            post().
        then().
            assertThat().
            statusCode(200).
            extract().
            path("bookingid");

        testData.setBookingId_Reachson(bookingId_Reachson);
    }

    @Test
    public void checkDeleteBooking_Macintosh(){
        testData.authenticate();

        given().
            contentType(ContentType.JSON).
            spec(requestSpecBaseUrl).
            cookie("token", testData.getToken()).
            log().all().
        when().
            delete(String.valueOf(testData.getBookingId_Macintosh())).
        then().
            assertThat().
            statusCode(201);
    }

    @Test
    public void checkUpdateSurname_DeeJay(){
        String newLastName =

        given().
            contentType(ContentType.JSON).
            cookie("token", testData.getToken()).
            spec(requestSpecBaseUrl).
            body(updateLastNameRequest_DeeJay).
            log().all().
        when().
            patch(String.valueOf(testData.getBookingId_DeeJay())).
        then().
            assertThat().
            statusCode(200).
            extract().
            path("lastname");

        assertTrue(newLastName.equals("Jayson"));
    }

    @Test
    public void checkUpdateBooking_Reachson(){
        testData.authenticate();

        given().
            contentType(ContentType.JSON).
            cookie("token", testData.getToken()).
            spec(requestSpecBaseUrl).
            body(updateExistingBooking_Reachson).
            log().all().
        when().
            put(String.valueOf(testData.getBookingId_Reachson())).
        then().
            assertThat().
            statusCode(200).
            extract().
            path("lastname");

    }
}