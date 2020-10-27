package com.solvertic.disfruta.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solvertic.disfruta.dao.ITAtributosDao;
import com.solvertic.disfruta.entity.TAtributos;
import com.solvertic.disfruta.services.ITAtributosService;

@Service
public class TAtributosServiceImpl implements ITAtributosService {

	@Autowired
	private ITAtributosDao iTAtributosDao;

	@Override
	public void saveTAtributos(TAtributos tatributos) {
		// TODO Auto-generated method stub
		iTAtributosDao.save(tatributos);

	}

	@Override
	public List<TAtributos> listTAtributosAll() {
		// TODO Auto-generated method stub
		return iTAtributosDao.findAll();
	}

	@Override
	public void deleteTAtributosById(int id) {
		// TODO Auto-generated method stub
		iTAtributosDao.deleteById(id);

	}

	@Override
	public TAtributos findTAtributosById(int id) {
		// TODO Auto-generated method stub
		return iTAtributosDao.getOne(id);
	}

}
