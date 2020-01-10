package com.jrp.pma.dao;

import com.jrp.pma.entities.MyTestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyEntityRepository extends CrudRepository<MyTestEntity, Long> {
    @Override
    List<MyTestEntity> findAll();
}
