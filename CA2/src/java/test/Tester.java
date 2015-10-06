/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Person;
import facade.JSONConvert;
import facade.PersonFacade;
import javax.persistence.Persistence;

/**
 *
 * @author Sindt
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Persistence.generateSchema("pu_test", null);

    }

}
