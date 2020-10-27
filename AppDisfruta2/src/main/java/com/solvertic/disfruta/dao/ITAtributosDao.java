package com.solvertic.disfruta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solvertic.disfruta.entity.TAtributos;

@Repository
public interface ITAtributosDao extends JpaRepository<TAtributos, Integer>{

}
