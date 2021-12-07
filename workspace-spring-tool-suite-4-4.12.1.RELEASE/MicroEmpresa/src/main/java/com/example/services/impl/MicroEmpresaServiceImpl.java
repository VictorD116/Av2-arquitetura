package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documents.MicroEmpresa;
import com.example.repositories.MicroEmpresaRepository;
import com.example.services.MicroEmpresaService;

@Service
public class MicroEmpresaServiceImpl implements MicroEmpresaService {
	
	@Autowired
	private MicroEmpresaRepository microEmpresaRepositoy;

	@Override
	public List<MicroEmpresa> listarTodos() {
		return this.microEmpresaRepositoy.findAll();
	}

	@Override
	public MicroEmpresa listarPorId(String id) {
		return this.microEmpresaRepositoy.findById(id).get();
	}

	@Override
	public MicroEmpresa cadastrar(MicroEmpresa microempresa) {
		return this.microEmpresaRepositoy.save(microempresa);
	}

	@Override
	public void remover(String id) {
		this.microEmpresaRepositoy.deleteById(id);

	}

}
