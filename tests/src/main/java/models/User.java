package models;

public class User {
    public Integer id;
    public String firstName;
    public String lastName;
    public Integer age;
    public Long phone;

    public User(){}

    public User(String fName, String lName, Integer age, Long phone){
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.phone = phone;
    }

    public Integer getId(){
        return this.id;
    }
}
