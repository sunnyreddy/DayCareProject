/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author medas
 */
public class Person {
    private int personId;
    private int age;
    private String firstName;
    private String lastName;
    private String description;

    public Person(int personId, int age, String firstName, String lastName) {
        super();
        this.personId = personId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "personId=" + personId 
            + ", age=" + age 
            + ", firstName=" + firstName 
            + ", lastName=" + lastName + "";
    }
}
