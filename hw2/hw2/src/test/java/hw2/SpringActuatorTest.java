package hw2;

import com.jayway.restassured.RestAssured;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringActuatorTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void test1_Info() throws Exception {
        when().get("/actuator/info").then()
            .body("author",equalTo("WangYilin")).and()
            .body("version",equalTo("v1.0"));
    }
    
    @Test
    public void test2_Health() throws Exception {
        when().get("/actuator/health").then()
            .body("status",equalTo("UP")).and()
            .body("details.MyHealthStyle.status",equalTo("UP")).and()
            .body("details.db.status",equalTo("UP")).and()
            .body("details.diskSpace.status",equalTo("UP"));
    }
    
    @Test
    public void test3_EndPoint() throws Exception {
        when().get("/actuator/myEndPoint1").then()
            .body("author",equalTo("WangYilin")).and()
            .body("date",equalTo("2019/04/14")).and()
            .body("version",equalTo("v1.0.0"));
    }
}