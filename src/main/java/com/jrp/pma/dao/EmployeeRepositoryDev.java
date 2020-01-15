package com.jrp.pma.dao;

import com.jrp.pma.entities.Employee;
import org.springframework.context.annotation.Profile;

@Profile("dev")
public interface EmployeeRepositoryDev extends EmployeeRepository {
    @Override
    <S extends Employee> S save(S entity);

    @Override
    <S extends Employee> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Employee> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void delete(Employee entity);

    @Override
    void deleteAll(Iterable<? extends Employee> entities);

    @Override
    void deleteAll();
}
