package com.solvertic.disfruta.services;

import java.util.List;

import com.solvertic.disfruta.entity.VAtributos;

public interface IVAtributosService {

	void saveVAtributos(VAtributos vatributos);

	List<VAtributos> listVAtributosAll();

	void deleteVAtributosById(int id);

	VAtributos findVAtributosById(int id);

}
