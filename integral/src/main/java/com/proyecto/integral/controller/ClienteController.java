package com.proyecto.integral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.proyecto.integral.model.entidad.Cliente;
import com.proyecto.integral.model.service.IClienteService;

@Controller
@RequestMapping("/cliente") // Raiz de cliente
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/") // Raiz de cliente
    public String inicio(Model model) {
        Cliente objCliente = new Cliente();
        model.addAttribute("cliente", objCliente);
        return "cliente/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }
}
