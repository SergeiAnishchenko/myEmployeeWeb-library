package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Override
    default <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Integer integer) {
        return false;
    }

    @Override
    default Iterable<Employee> findAll() {
        return null;
    }

    @Override
    default Iterable<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Integer integer) {

    }

    @Override
    default void delete(Employee entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    default void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    default void deleteAll() {

    }
}

