package API_Tests;

import API_Tests.pojo.TickerPojo;
import API_Tests.specifications.Specifications;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class MainAPIClassTest {

    private final String baseUrl = "https://api.kucoin.com";

    //Формируем список, чтобы не повторять код в дальнейшем
    public List<TickerPojo> getTickers(){
        return given()
                .contentType(ContentType.JSON)
                .when().get(baseUrl + "/api/v1/market/allTickers")
                .then()
                .extract()
                .jsonPath()
                .getList("data.ticker", TickerPojo.class);
    }

    @Test
    @DisplayName("1. Выборка валютных пар с условием")
    public void checkCurrency(){
        Specifications.installSpecifications(Specifications.requestSpec(baseUrl), Specifications.responseSpec200());
                getTickers()
                        .stream()
                        .filter(x -> x.getSymbol().endsWith("BTC"))
                        .toList();
    }

    @Test
    @DisplayName("2. Сортировка по проценту, берём топ-1 ")
    public void sortHighToLow(){
        List<TickerPojo> highToLow =
                getTickers()
                        .stream()
                        .filter(x -> x.getSymbol()
                                .endsWith("BTC"))
                        .sorted((o1, o2) -> o2.getChangeRate()
                                .compareTo(o1.getChangeRate()))
                        .toList();
        Assert.assertEquals(highToLow.get(0).getSymbol(),"SKU-BTC");
    }
    @Test
    @DisplayName("3. Cоответствие статус-кода и времени ответа")
    public void checkStatusAndResponseTime(){
        Specifications.installSpecifications
                (Specifications.requestSpec(baseUrl), Specifications.responseSpec200());
        given()
                .when()
                .get("/api/v1/symbols");
    }

}
