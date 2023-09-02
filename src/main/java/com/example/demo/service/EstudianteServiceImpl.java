package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}
	
	@Override
	public Estudiante consultarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}


	
	
	@Override
	public List<EstudianteTO> buscarTodosNormal() {
		// TODO Auto-generated method stub
		List<Estudiante> lista=this.estudianteRepository.buscarTodosNormal();
		List<EstudianteTO>listaTO=lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
		
		return listaTO;
	}

	
	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO est= new EstudianteTO();
		est.setId(estudiante.getId());
		est.setNombre(estudiante.getNombre());
		est.setApellido(estudiante.getApellido());
		est.setCedula(estudiante.getCedula());
		

		return est;
	}

}
