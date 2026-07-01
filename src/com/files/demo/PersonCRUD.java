package com.files.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonCRUD {
	private static final String FILE_NAME = "persons.ser";
	
	// Load people from the file
	public static List<Person> loadPeople() {
		List<Person> people = new ArrayList<Person>();
		File file = new File(FILE_NAME);
		
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)){
				people = (List<Person>)ois.readObject();
				
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return people;
	}
	
	// Save people to the file
	public static void savePeople(List<Person> people) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
               oos.writeObject(people);
           } catch (IOException e) {
               e.printStackTrace();
           }

	}
	
    // Add a new person
	public static void addPerson(Person person) {
		List<Person> people = loadPeople();
        people.add(person);
        savePeople(people);
        System.out.println("Person added: " + person);
	}
    
	// Read all people
	public static void readAllPeople() {
        List<Person> people = loadPeople();
        for (Person person : people) {
            System.out.println(person);
        }
	}
	
	// Update a person's details by name
	public static void updatePerson(String name, Person newDetails) {
        List<Person> people = loadPeople();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getName().equals(name)) {
                people.set(i, newDetails);
                savePeople(people);
                System.out.println("Person updated: " + newDetails);
                return;
            }
        }
        System.out.println("Person not found: " + name);
	}
	
    // Delete a person by name
	public static void deletePerson(String name) {
		List<Person> people = loadPeople();
        boolean removed = people.removeIf(person -> person.getName().equals(name));
        if (removed) {
            savePeople(people);
            System.out.println("Person deleted: " + name);
        } else {
            System.out.println("Person not found: " + name);
        }
	}
	
	public static void main(String[] args) {
		
        // Example usage
        addPerson(new Person("Alice", 30));
        addPerson(new Person("Bob", 25));

        System.out.println("All people:");
        readAllPeople();

        updatePerson("Alice", new Person("Alice", 31));

        System.out.println("All people after update:");
        readAllPeople();

        deletePerson("Bob");

        System.out.println("All people after deletion:");
        readAllPeople();
        
	}

}
