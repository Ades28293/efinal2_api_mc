package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	
public void guardar(Estudiante estudiante);
public Estudiante consultarCedula(String cedula);
	
	
public List<EstudianteTO> buscarTodosNormal();
}
