package com.proyecto.integral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.proyecto.integral.model.entidad.Cliente;
import com.proyecto.integral.model.service.IClienteService;

@Controller
@RequestMapping("/cliente") // Raiz de cliente
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/") 
    public String inicio(Model model) {
        Cliente objCliente = new Cliente();
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes()); // Lista de clientes
        return "cliente/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }

    //editar Cliente

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Cliente objCliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "cliente/inicio";
    }
}
