package com.proyecto.integral.model.service;
import java.util.List;

import com.proyecto.integral.model.entidad.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategorias();
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
}
