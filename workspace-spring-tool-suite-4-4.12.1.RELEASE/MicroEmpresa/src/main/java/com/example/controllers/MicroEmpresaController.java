package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.responses.Response;
import com.example.documents.MicroEmpresa;
import com.example.services.MicroEmpresaService;

@RestController
@RequestMapping (path = "/api/microempresas")
public class MicroEmpresaController {
	
	@Autowired
	private MicroEmpresaService microEmpresaService;
	
	@GetMapping
	public ResponseEntity<Response<List<MicroEmpresa>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<MicroEmpresa>>(this.microEmpresaService.listarTodos()));
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<MicroEmpresa>> listarPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<MicroEmpresa>(this.microEmpresaService.listarPorId(id)));
		
	}
	@PostMapping
	public ResponseEntity<Response<MicroEmpresa>> cadastrar(@Valid @RequestBody MicroEmpresa microempresa, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<MicroEmpresa>(erros));
		}
		return ResponseEntity.ok(new Response<MicroEmpresa>(this.microEmpresaService.cadastrar(microempresa)));
		
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id")String id){
		this.microEmpresaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
		
		
	}

}
