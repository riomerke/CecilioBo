package com.solvertic.disfruta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solvertic.disfruta.entity.VAtributos;

@Repository
public interface IVAtributosDao extends JpaRepository<VAtributos, Integer> {


}
