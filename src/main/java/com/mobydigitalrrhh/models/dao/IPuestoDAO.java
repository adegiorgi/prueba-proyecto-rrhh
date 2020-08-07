package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.mobydigitalrrhh.models.entities.Puesto;

public interface IPuestoDAO extends CrudRepository<Puesto, Integer> {

}
