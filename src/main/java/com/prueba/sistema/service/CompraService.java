package com.prueba.sistema.service;

import com.prueba.sistema.DTO.CompraDTO;
import com.prueba.sistema.models.Compra;
import com.prueba.sistema.models.DetalleCompra;
import com.prueba.sistema.repositories.ICompraRepository;
import com.prueba.sistema.repositories.IDetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CompraService {
    @Autowired
    private ICompraRepository compraRepository;
    @Autowired
    private IDetalleCompraRepository detalleCompraRepository;

    /*public List<Compra> obtenerComprasPorFecha(Long idUsuario, Date fechaCompra) {
        return compraRepository.findByIdUsuarioAndFechaCompra(idUsuario, fechaCompra);
    }*/
    public List<CompraDTO> obtenerComprasPorUsuario(Long idUsuario) {
        List<Compra> listaCompras = compraRepository.findAllByIdUsuario(idUsuario);
        List<CompraDTO> comprasDTO = new ArrayList<>();

        for (Compra compra : listaCompras) {
            List<DetalleCompra> detallesCompra = detalleCompraRepository.findAllByIdCompra(compra.getIdCompra());

            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setIdCompra(compra.getIdCompra());
            compraDTO.setIdUsuario(compra.getIdUsuario());
            compraDTO.setFechaCompra(compra.getFechaCompra());
            compraDTO.setTotal(compra.getTotal());
            compraDTO.setDetalleCompra(detallesCompra);

            comprasDTO.add(compraDTO);
        }
        return comprasDTO;

    }

}
