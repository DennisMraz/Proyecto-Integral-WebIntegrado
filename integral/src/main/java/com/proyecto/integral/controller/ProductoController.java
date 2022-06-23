package com.proyecto.integral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.integral.model.entidad.Producto;
import com.proyecto.integral.model.service.ICategoriaService;
import com.proyecto.integral.model.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IProductoService productoService;

    @RequestMapping("/")
    public String inicio(Model model){ //Modelo para pasar datos a la vista
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias()); //Carga las categorias
        model.addAttribute("listaProductos", productoService.cargarProductos()); //Carga los productos
        return "producto/inicio";
    }

    //Guardar
    @RequestMapping(value="/form", method=RequestMethod.POST) 
    public String guardar(Producto producto, RedirectAttributes flash){
        String rpta = productoService.guardarProducto(producto);
        flash.addFlashAttribute("mensaje",rpta);
        return "redirect:/producto/";
    }
}
