package com.proyecto.integral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.integral.model.dao.IProductoDAO;
import com.proyecto.integral.model.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public String guardarProducto(Producto producto) {
        String rpta = "";
        try {
            productoDAO.save(producto);
            rpta = "Producto guardado correctamente";
        } catch (Exception e) {
             rpta=e.toString(); // rpta = "ERROR"; //Se recomienda no usar el toString() en una aplicacion web por que puede ser una vulnerabilidad 
        }
        // return productoDAO.save(producto).getId().toString(); //Se retorna el id del producto guardado
        return rpta;
    }

    @Override
    public List<Producto> cargarProductos() {
        return (List<Producto>) productoDAO.findAll(); //Se castea a List<Producto> para que se pueda usar el metodo findAll()
    }

}
