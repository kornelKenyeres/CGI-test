package com.cgi.boat.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static final Integer TOP_COUNT = 3;

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        
        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3

        HashMap<String, Integer> result = new HashMap<String, Integer>();
        
        for (String key : lastByFirst.keySet()) {
        	int currentSize = lastByFirst.get(key).size();
        	if (result.size() < TOP_COUNT) {
        		
        		//initial set with first ${TOP_COUNT} items
        		result.put(key, currentSize);
        	
        	} else if (checkIfMorePopular(result, currentSize)) {
        	
        		//if a name is more popular, then one of the ${TOP_COUNT} most popular names so far
        		//then swap current with the less popular one
        		swapWithLowest(result, key, currentSize);
        	
        	}
        }
        
        //print result
        for (String key : result.keySet()) {
        	System.out.println(key+": "+result.get(key));
        }
    }

    //Checks if the name is more popular then the current tops
    private static boolean checkIfMorePopular(Map<String, Integer> top, int size) {
    	for (String key : top.keySet()) {
    		if (size > top.get(key)) {
    			return true;
    		}
    	}
    	return false;
    }

    //swaps the less popular element in the "result" array with the new one (only if it is more popular)
    private static HashMap<String, Integer> swapWithLowest(HashMap<String, Integer> top, String name, int occourance) {
    	String lowestName = null;
    	int lowestCount = Integer.MAX_VALUE;
    	for (String key : top.keySet()) {
    		if (top.get(key) < lowestCount) {
    			lowestCount = top.get(key);
    			lowestName = key;
    		}
    	}
    	if (lowestCount < occourance) {
    		top.remove(lowestName);
    		top.put(name, occourance);
    	}
    	return top;
    }



}
