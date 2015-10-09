/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import deploy.DeploymentConfiguration;
import entity.Person;
import exceptions.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
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

    PersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
    private int id;
    private int id1;
    private int id2;

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
        EntityManager em = facade.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Person").executeUpdate();
            Person p = new Person("Ole", "Hansen", 1);
            Person p1 = new Person("Hanne", "Hansen", 1);
            Person p2 = new Person("Peter", "Olsen", 1);
            em.persist(p);
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
            id = p.getId();
            id1 = p1.getId();
            id2 = p2.getId();
        } finally {
            em.close();
        }
    }

    @After
    public void tearDown() {
        EntityManager em = facade.getEntityManager();
        try {
            Person p1 = em.find(Person.class, id1);
            Person p2 = em.find(Person.class, id2);
            em.getTransaction().begin();
            em.remove(p1);
            em.remove(p2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
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
    public void testGetPerson() throws PersonNotFoundException {
        System.out.println("getPerson");
        Person p = facade.getPerson(id1);
        assertEquals(p.getFirstName(), "Hanne");
    }

    /**
     * Test of addPerson method, of class PersonFacade.
     */
    @Test
    public void testAddPerson() throws PersonNotFoundException {
        System.out.println("addPerson");
        Person person = facade.addPerson(new Person("Ole", "Bole", 1));
        person = facade.getPerson(person.getId());
        assertEquals("Ole", person.getFirstName());
    }

    /**
     * Test of deletePerson method, of class PersonFacade.
     */
    @Test
    public void testDeletePerson() throws PersonNotFoundException {
        System.out.println("deletePerson");
        facade.deletePerson(id);
        assertEquals(facade.getPersons().size(), 2);
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons() {
        System.out.println("getPersons");
        List<Person> result = facade.getPersons();
        assertNotNull(result);
    }

}
