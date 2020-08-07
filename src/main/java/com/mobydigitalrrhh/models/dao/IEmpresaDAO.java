package com.mobydigitalrrhh.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.mobydigitalrrhh.models.entities.Empresa;

public interface IEmpresaDAO extends CrudRepository<Empresa, Integer> {

}
