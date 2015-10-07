/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
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
public class CompanyFacadeTest {
    
     CompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("pu_test"));
    
    public CompanyFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class CompanyFacade.
     */
    @Ignore
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        CompanyFacade instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompany method, of class CompanyFacade.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        int id = 1;
        Company c = facade.getCompany(id);
        assertEquals(c.getName(), "test");
    }

    /**
     * Test of addCompany method, of class CompanyFacade.
     */
    @Ignore
    public void testAddCompany() {
        System.out.println("addCompany");
        Company c = null;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.addCompany(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCompany method, of class CompanyFacade.
     */
    @Ignore
    public void testDeleteCompany() {
        System.out.println("deleteCompany");
        int id = 0;
        CompanyFacade instance = null;
        Company expResult = null;
        Company result = instance.deleteCompany(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanys method, of class CompanyFacade.
     */
    @Ignore
    public void testGetCompanys() {
        System.out.println("getCompanys");
        CompanyFacade instance = null;
        List<Company> expResult = null;
        List<Company> result = instance.getCompanys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
