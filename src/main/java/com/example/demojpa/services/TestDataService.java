package com.example.demojpa.services;

import com.example.demojpa.model.Address;
import com.example.demojpa.model.Person;
import com.example.demojpa.model.Role;
import com.example.demojpa.repositories.AddressRepository;
import com.example.demojpa.repositories.PersonRepository;
import com.example.demojpa.repositories.RoleRepository;
import com.example.demojpa.repositories.spec.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;

@Service
public class TestDataService {
    PersonRepository personRepository;
    AddressRepository addressRepository;
    RoleRepository roleRepository;


    public TestDataService(PersonRepository personRepository, AddressRepository addressRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
    }

    public void printAllRoles() {
        roleRepository.findAll().forEach(System.out::println);
    }

    public void printAllPersons() {
        System.out.println("All persons:");
        personRepository.findAll().forEach(System.out::println);
        System.out.println();
    }

    public void printPersonsByCriteria() {
        Specification<Person> spec = PersonSpecification.all()
                .and(PersonSpecification.likeName("Tom"))
                .and(PersonSpecification.withAgeGreaterThen(21))
                .and(PersonSpecification.withAgeLessThen(39));

        System.out.println("All persons with name like Tom% and age between 21 and 39:");
        personRepository.findAll(spec).forEach(System.out::println);
        System.out.println();
    }

    @Transactional
    public void initData() {
        Role role1 = roleRepository.save(new Role("citizen"));
        Role role2 = roleRepository.save(new Role("foreigner"));
        Role role3 = roleRepository.save(new Role("man"));
        Role role4 = roleRepository.save(new Role("woman"));
        Role role5 = roleRepository.save(new Role("student"));
        Role role6 = roleRepository.save(new Role("worker"));

        HashSet roleSet1 = new HashSet<Role>();
        roleSet1.add(role1);
        roleSet1.add(role3);
        roleSet1.add(role5);

        HashSet roleSet2 = new HashSet<Role>();
        roleSet2.add(role1);
        roleSet2.add(role4);
        roleSet2.add(role6);

        HashSet roleSet3 = new HashSet<Role>();
        roleSet3.add(role2);
        roleSet3.add(role3);
        roleSet3.add(role5);

        HashSet roleSet4 = new HashSet<Role>();
        roleSet4.add(role2);
        roleSet4.add(role4);
        roleSet4.add(role5);

        Address address11 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Darwin Street", "54", "123"));
        Address address12 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Defence Street", "11", "24"));
        Address address13 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Distant street", "17", "76"));
        Address address21 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Gas Street", "45", "27"));
        Address address22 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Gastello Street", "33", "11"));
        Address address23 = addressRepository.save(new Address("RU", "Moscow", "Moscow", "Gogol street", "71", "89"));


        personRepository.save(new Person("Ivan", 21, address11, roleSet1));
        personRepository.save(new Person("Alex", 27, address12, roleSet1));
        personRepository.save(new Person("Tomas", 25, address13, roleSet3));
        personRepository.save(new Person("Tomiris", 27, address21, roleSet2));
        personRepository.save(new Person("Anna", 21, address22, roleSet2));

        personRepository.save(new Person("Toma", 35, address23, roleSet4));
        personRepository.save(new Person("Ben", 38, address23, roleSet3));
        personRepository.save(new Person("Mike", 16, address23, roleSet3));
        personRepository.save(new Person("Ibrahim", 39, address12, roleSet3));
    }
}
