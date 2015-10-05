/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import java.util.List;

/**
 *
 * @author Sindt
 */
public interface IFCompanyFacade {

    Company getCompany(int id);

    List<Company> getCompanys();

    Company addCompany(Company c);

    Company deleteCompany(int id);

}
