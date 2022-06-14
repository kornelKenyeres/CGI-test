package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PeopleProcessor {
    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "John" -> ["Doe", "Silver"]
     *  "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
    	
    	List<Person> sorted = new ArrayList<Person>(people);
    	sorted.sort(Comparator.comparing(Person::getFirstName));
    	Map<String, List<String>> result = new HashMap<String, List<String>>();
    	String currentFirstName = people.get(0).getFirstName();
    	List<String> lastNames = new ArrayList<String>();
    	
    	for (Person p : sorted) {
    		if (p.getFirstName().equals(currentFirstName)) {
    			lastNames.add(p.getLastName());
    		} else {
    			result.put(currentFirstName, lastNames);
    			lastNames = new ArrayList<String>();
    			currentFirstName = p.getFirstName();
    			lastNames.add(p.getLastName());
    		}
    	}
    	result.put(currentFirstName, lastNames);
    	
    	return result;
    }


    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "Doe" -> ["John", "Peter"]
     *  "Silver" -> ["John"]
     *
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people){
    	
    	List<Person> sorted = new ArrayList<Person>(people);
    	sorted.sort(Comparator.comparing(Person::getLastName));
    	Map<String, List<String>> result = new HashMap<String, List<String>>();
    	String currentLastName = people.get(0).getLastName();
    	List<String> firstNames = new ArrayList<String>();
    	
    	for (Person p : sorted) {
    		if (p.getLastName().equals(currentLastName)) {
    			firstNames.add(p.getFirstName());
    		} else {
    			result.put(currentLastName, firstNames);
    			firstNames = new ArrayList<String>();
    			currentLastName = p.getLastName();
    			firstNames.add(p.getFirstName());
    		}
    	}
    	result.put(currentLastName, firstNames);
    	
    	return result;
    }

}
