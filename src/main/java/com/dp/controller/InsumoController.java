package com.dp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dp.domain.InsumoRepository;
import com.dp.infraestrutura.InsumoService;
import com.dp.integration.Client;
import com.dp.model.Insumo;

@RestController
@RequestMapping("/insumo")
public class InsumoController {

	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoService service;
	
	@GetMapping("/listar")
	public Page<Insumo> listar(String classificacao, String regiao, @PageableDefault(size = 6) Pageable pageable) {
		Page<Insumo> insumosPage = insumoRepository.list(regiao, classificacao, pageable);
		List<Insumo> collection = Client.list;

		if(insumoRepository.findAll().isEmpty()) {
			for (Insumo insumo : collection) {
				service.insert(insumo);
			}
			insumosPage = insumoRepository.list(regiao, classificacao, pageable);
		}
		
		return insumosPage;
	}  
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> search(@PathVariable Long id) {
		Optional<Insumo> obj = insumoRepository.findById(id) ;

		if(insumoRepository.findAll().isEmpty()) {
			List<Insumo> collection = Client.list;
			for (Insumo insumo : collection) {
				service.insert(insumo);
			}
			obj = insumoRepository.findById(id);
		}
		
		if(obj.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(obj);
		
		return null;
		
	} 
	
}
