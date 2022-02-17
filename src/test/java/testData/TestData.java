package testData;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class TestData {

    public static RequestSpecification requestSpecBaseUrl = new RequestSpecBuilder().
            setBaseUri("https://restful-booker.herokuapp.com/booking/").
            build();

    public static String authenticationRequestBody = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    //Block with requests
    public static String createNewBookingRequest_JohnMacintosh = "{" +
            "\"firstname\" : \"John\",\n" +
            "    \"lastname\" : \"Macintosh\",\n" +
            "    \"totalprice\" : 100,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-06-01\",\n" +
            "        \"checkout\" : \"2022-06-21\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"\"}";


    public static String createNewBookingRequest_DeeJay = "{" +
            "\"firstname\" : \"Dee\",\n" +
            "    \"lastname\" : \"Jay\",\n" +
            "    \"totalprice\" : 90,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-08-01\",\n" +
            "        \"checkout\" : \"2022-08-07\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"\"}";

    public static String createNewBookingRequest_BloomyReachson = "{" +
            "\"firstname\" : \"Bloomy\",\n" +
            "    \"lastname\" : \"Reachson\",\n" +
            "    \"totalprice\" : 40,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-05-20\",\n" +
            "        \"checkout\" : \"2022-05-22\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Cat\"}";

    public static String updateExistingBooking_Reachson = "{" +
            "\"firstname\" : \"Bloomy\",\n" +
            "    \"lastname\" : \"Reachson\",\n" +
            "    \"totalprice\" : 1040,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-05-20\",\n" +
            "        \"checkout\" : \"2022-05-29\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Cat\"}";


    public static String updateLastNameRequest_DeeJay = "{\n" +
            "    \"lastname\" : \"Jayson\"\n" +
            "}";


    private String token = "";

    private int bookingId_Macintosh;
    private int bookingId_DeeJay;
    private int bookingId_Reachson;


    //Methods
    public void authenticate(){
        String token =

        given().
            contentType(ContentType.JSON).
            body(authenticationRequestBody).
            log().all().
        when().
            post("https://restful-booker.herokuapp.com/auth").
        then().
            assertThat().
            statusCode(200).
            extract().
            path("token");

        setToken(token);
    }

    //Block with getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getBookingId_Macintosh() {
        return bookingId_Macintosh;
    }

    public void setBookingId_Macintosh(int bookingId_Macintosh) {
        this.bookingId_Macintosh = bookingId_Macintosh;
    }

    public int getBookingId_DeeJay() {
        return bookingId_DeeJay;
    }

    public void setBookingId_DeeJay(int bookingId_DeeJay) {
        this.bookingId_DeeJay = bookingId_DeeJay;
    }

    public int getBookingId_Reachson() {
        return bookingId_Reachson;
    }

    public void setBookingId_Reachson(int bookingId_Reachson) {
        this.bookingId_Reachson = bookingId_Reachson;
    }
}
