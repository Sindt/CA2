/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import facade.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Sindt
 */
public class PersonResourceTest {

    static EntityManagerFactory emfOriginal;
    static PersonFacade facade;
    static int id;
    static int idForDelete;
    static int idForSave;

    public PersonResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        baseURI = "http://localhost:8080/CA2";
        defaultParser = Parser.JSON;
        basePath = "/api";

        id = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"firstName\": \"Allan\", \"lastName\": \"Petersen\",\"address_id\": \"1\"}")
                .when()
                .post("/person")
                .then()
                .extract().path("id");
        idForDelete = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"firstName\": \"Peter\", \"lastName\": \"Olesen\",\"address_id\": \"1\"}")
                .when()
                .post("/person")
                .then()
                .extract().path("id");

    }

    @AfterClass
    public static void tearDownClass() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .delete("/person/complete/" + id);
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .delete("/person/complete/" + idForSave);
        
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPerson method, of class PersonResource.
     */
    @Test
    public void testGetPerson() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/person/complete/" + id)
                .then().
                body("firstName", equalTo("Allan"));

        given().
                contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/person/complete/123456789")
                .then().
                statusCode(200);
    }

    /**
     * Test of getPerson method, of class PersonResource.
     */
    @Test
    public void testGetAllPersons() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/person/complete")
                .then().
                statusCode(200);
    }

    /**
     * Test of savePerson method, of class PersonResource.
     */
    @Test
    public void testSavePerson() {
        idForSave = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"firstName\": \"a\", \"lastName\": \"b\",\"address_id\": \"1\"}")
                .when()
                .post("/person")
                .then()
                .statusCode(200).and().body("firstName", equalTo("a"))
                .extract().path("id");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/person/complete/" + idForSave)
                .then()
                .statusCode(200).and().body("firstName", equalTo("a")).and().body("lastName", equalTo("b"));
    }

    /**
     * Test of deletePerson method, of class PersonResource.
     */
    @Test
    public void testDeletePerson() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .delete("/person/complete/" + idForDelete)
                .then()
                .statusCode(200);
    }

}
