package com.solvertic.disfruta.services;

import java.util.List;

import com.solvertic.disfruta.entity.TAtributos;

public interface ITAtributosService {

	void saveTAtributos(TAtributos tatributos);

	List<TAtributos> listTAtributosAll();

	void deleteTAtributosById(int id);

	TAtributos findTAtributosById(int id);

}
