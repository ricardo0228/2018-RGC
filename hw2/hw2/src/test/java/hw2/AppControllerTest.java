package hw2;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",
        "spring.datasource.url:jdbc:h2:mem:hw2;DB_CLOSE_ON_EXIT=FALSE"})
public class AppControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testRunning() throws Exception {
        when().get("/WordLadder").then()
                .body(is("App is running."));
    }
    
    @Test
    public void testSearch() throws Exception {
        when().get("/WordLadder/search?start=hid&end=did").then()
                .body(is("2"));
    }

    @Test
    public void testShow() throws Exception {
        when().get("/WordLadder/showDictionary").then()
                .body(is("hid hat had did "));
    }

    @Test
    public void testAdd() throws Exception {
        when().get("/WordLadder/addWord?word=cat").then()
                .body(is("hid cat hat had did "));
    }
}