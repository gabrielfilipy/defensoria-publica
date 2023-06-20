package com.dp.infraestrutura;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.domain.InsumoRepository;
import com.dp.model.Insumo;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository repository;

	@Transactional
	public void insert(Insumo insumo) {
		repository.save(insumo);
	}
	
}
