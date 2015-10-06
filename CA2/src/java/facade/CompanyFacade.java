/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfaces.IFCompanyFacade;
import entity.Company;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sindt
 */
public class CompanyFacade implements IFCompanyFacade {

    private EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory e) {
        emf = e;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Company getCompany(int id) {
        EntityManager em = getEntityManager();
        try {
            Company c = em.find(Company.class, id);
            return c;
        } finally {
            em.close();
        }

    }

    @Override
    public Company addCompany(Company c) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    @Override
    public Company deleteCompany(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getCompanys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
