package com.example.services;

import java.util.List;

import com.example.documents.MicroEmpresa;

public interface MicroEmpresaService {
	
	List<MicroEmpresa> listarTodos();
	
	MicroEmpresa listarPorId(String id);
	
	MicroEmpresa cadastrar(MicroEmpresa microempresa);
	
	void remover(String id);
	
	

}
