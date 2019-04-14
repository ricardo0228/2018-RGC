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
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        System.out.print(port);
        RestAssured.port = port;
    }

    @Test
    public void test1_Running() throws Exception {
        when().get("/WordLadder").then()
                .body(is("App is running."));
    }
    
    @Test
    public void test2_Search() throws Exception {
        when().get("/WordLadder/search?start=hid&end=did").then()
                .body(is("2"));
    }

    @Test
    public void test3_Show() throws Exception {
        when().get("/WordLadder/showDictionary").then()
                .body(is("hid hat had did "));
    }

    @Test
    public void test4_Add() throws Exception {
        when().get("/WordLadder/addWord?word=cat").then()
                .body(is("hid cat hat had did "));
    }
}