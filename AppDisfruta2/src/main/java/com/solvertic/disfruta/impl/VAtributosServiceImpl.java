package com.solvertic.disfruta.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solvertic.disfruta.dao.IVAtributosDao;
import com.solvertic.disfruta.entity.TAtributos;
import com.solvertic.disfruta.entity.VAtributos;
import com.solvertic.disfruta.services.IVAtributosService;

@Service
public class VAtributosServiceImpl implements IVAtributosService {

	@Autowired
	private IVAtributosDao iVAtributosDao;
	
	
	@Override
	public void saveVAtributos(VAtributos vatributos) {
		// TODO Auto-generated method stub
		iVAtributosDao.save(vatributos);
	}

	@Override
	public List<VAtributos> listVAtributosAll() {
		// TODO Auto-generated method stub
		return iVAtributosDao.findAll();
	}

	@Override
	public void deleteVAtributosById(int id) {
		// TODO Auto-generated method stub
		iVAtributosDao.deleteById(id);
	}

	@Override
	public VAtributos findVAtributosById(int id) {
		// TODO Auto-generated method stub
		return iVAtributosDao.getOne(id);
	}
	
	/*
	//Encontrar valores de atributos 
	public List<VAtributos> findAllByTAtributos(TAtributos tatributos) {
		return iVAtributosDao.findByTAtributos(tatributos);
		
	}
	
	//Encontrar valores de atributos por el ID del Tipo de Atributos
	public List<VAtributos> findAllByTAtributos(Integer tatributoId) {
		return iVAtributosDao.findByTAtributosId(tatributoId);
	}
	*/
	

}
