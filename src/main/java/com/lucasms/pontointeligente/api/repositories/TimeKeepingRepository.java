package com.lucasms.pontointeligente.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucasms.pontointeligente.api.repository.entities.Timekeeping;

@Repository
public interface TimeKeepingRepository extends CrudRepository<Timekeeping, Long>{

}
