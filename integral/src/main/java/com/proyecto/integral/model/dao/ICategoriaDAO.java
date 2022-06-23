package com.proyecto.integral.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proyecto.integral.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long> {
    
    //metodo de lista ordenada por nombre
    public List<Categoria> findByOrderByNombre();

    //metodo de busqueda por nombre
    public List<Categoria> findByNombre(String nombre);
    
    //metodo de busqueda por id menor a 5
    public List<Categoria> findByIdLessThan(Long id);

    //Query
    @Query( value = "SELECT * FROM categorias WHERE cat_nombre LIKE ?1", nativeQuery = true)
    public List<Categoria> pruebaQuery(String nombre);



    
}
