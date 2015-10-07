/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Company;
import entity.Person;
import java.util.List;

/**
 *
 * @author Casper
 */
public class JSONConvert {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public static String getJSONFromPerson(Person p) {
        return gson.toJson(p);
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }
    

    public static Company getCompanyFromJson(String js) {
        return gson.fromJson(js, Company.class);
    }

    public static String getJSONFromCompany(Company c) {
        return gson.toJson(c);
    }

    public static String getJSONFromCompany(List<Company> c) {
        return gson.toJson(c);
    }

}
