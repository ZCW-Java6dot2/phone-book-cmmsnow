package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = null;
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)){
            List<String> numsList = phonebook.get(name);
            numsList.add(phoneNumber);
        } else {
            List<String> phoneNums = new LinkedList<>();
            phoneNums.add(phoneNumber);
            phonebook.put(name, phoneNums);
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        if (phonebook.containsKey(name)){
            List<String> phoneNums = phonebook.get(name);
            for (String number : phoneNumbers){
                phoneNums.add(number);
            }
        } else {
            List<String> phoneNums = new LinkedList<>();
            for (String number : phoneNumbers){
                phoneNums.add(number);
            }
            phonebook.put(name, phoneNums);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    //Why is this angry?
    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> allKeys = phonebook.keySet();
        for (String key : allKeys){
            List<String> values = phonebook.get(key);
            if(values.contains(phoneNumber)){
                return key;
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        Set<String> contacts = phonebook.keySet();
        List<String> contactsList = contacts.stream().collect(Collectors.toList());
        return contactsList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
