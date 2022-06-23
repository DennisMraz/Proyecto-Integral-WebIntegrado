package com.proyecto.integral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.integral.model.dao.ICategoriaDAO;
import com.proyecto.integral.model.entidad.Categoria;

@Service
public class CategoriaServicesImp implements ICategoriaService {

    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaDAO.save(categoria); //Guarda la categoria en la base de datos
    }

    @Override
    public List<Categoria> cargarCategorias() {
      //  return (List<Categoria>) categoriaDAO.findAll(); //Se castea a List<Categoria> para que se pueda usar el metodo findAll()
       // return (List<Categoria>) categoriaDAO.findByOrderByNombre(); //Se ordena por nombre
        //return (List<Categoria>) categoriaDAO.findByNombre(" "); //Se busca por nombre
        //return (List<Categoria>) categoriaDAO.findByIdLessThan(5L); //Se busca por id menor a 5
        return (List<Categoria>) categoriaDAO.pruebaQuery("A%"); //Se busca con query native
    }

    @Override
    public Categoria buscarCategoria(Long id) {
           return categoriaDAO.findById(id).orElse(null); //orElse(null) es para que si no encuentra nada, retorne null
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaDAO.deleteById(id); //Se elimina por id
    }

}
