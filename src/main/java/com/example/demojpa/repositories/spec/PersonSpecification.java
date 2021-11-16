package com.example.demojpa.repositories.spec;

import com.example.demojpa.model.Person;
import org.springframework.data.jpa.domain.Specification;

public final class PersonSpecification {
    public static Specification<Person> all() {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.conjunction());

    }

    public static Specification<Person> withName(String name) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"),name));

    }

    public static Specification<Person> likeName(String name) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"),name+"%"));
    }

    public static Specification<Person> withAgeGreaterThen(int age) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("age"),age));
    }

    public static Specification<Person> withAgeLessThen(int age) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("age"),age));
    }
}
