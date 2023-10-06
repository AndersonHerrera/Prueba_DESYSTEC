package com.prueba.sistema.controllers;

import com.prueba.sistema.DTO.CompraDTO;
import com.prueba.sistema.models.Compra;
import com.prueba.sistema.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")

public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/user/{idUsuario}")
    public List<CompraDTO> obtenerComprasPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return compraService.obtenerComprasPorUsuario(idUsuario);
    }
}
