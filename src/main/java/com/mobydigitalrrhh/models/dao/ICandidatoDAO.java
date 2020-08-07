package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.mobydigitalrrhh.models.entities.Candidato;

public interface ICandidatoDAO extends CrudRepository<Candidato, Integer> {

}
