/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Person;
import exceptions.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author Sindt
 */
public interface IFPersonFacade {

    Person getPerson(int id) throws PersonNotFoundException;

    List<Person> getPersons();

    Person addPerson(Person p);

    Person deletePerson(int id) throws PersonNotFoundException;  
    

}
