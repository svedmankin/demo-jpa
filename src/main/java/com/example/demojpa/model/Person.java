package com.example.demojpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "age" , nullable = false)
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Person(String name, int age, Address address, Set<Role> roles) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.roles = roles;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Person: {id=" + getId() + ", " +
                "name=" + getName() + ", " +
                "age=" + getAge() + ", " +
                "address=" + getAddress() + ", " +
                "roles=" + getRoles() + "}";
    }
}
