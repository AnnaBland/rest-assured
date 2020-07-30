
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;


public class SimpleTest {

    @Test
    public void SimpleTest() {
//        HashMap data = new HashMap();
//        data.put("zip", "187015,ru");
//        data.put("appid", "fdaa02ff570cb066d2df983c14ede17c");



        Rest response = given().param("appid", "fdaa02ff570cb066d2df983c14ede17c")
                .param("zip", "187015,ru")

                .when()
                    .get("https://api.openweathermap.org/data/2.5/weather")
                .then().statusCode(200).log().body().extract().response().as(Rest.class);

        Assert.assertEquals(response.sys.country, "RU");

        double c = celsyi(response.main.temp);
        System.out.println(c);
    }

    public double celsyi (double a){
        return a - 273.15;
    }
}



