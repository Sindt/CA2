/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class PersonFacadeTest {

    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("pu_test"));

    public PersonFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       // EntityManager em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class PersonFacade.
     */
    @Ignore
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        Person p = facade.getPerson(1);
        assertEquals(p.getFirstName(), "bob");
    }

    /**
     * Test of addPerson method, of class PersonFacade.
     */
    @Ignore
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = null;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.addPerson(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class PersonFacade.
     */
    @Ignore
    public void testDeletePerson() {
        System.out.println("deletePerson");
        int id = 0;
        PersonFacade instance = null;
        Person expResult = null;
        Person result = instance.deletePerson(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Ignore
    public void testGetPersons() {
        System.out.println("getPersons");
        PersonFacade instance = null;
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
