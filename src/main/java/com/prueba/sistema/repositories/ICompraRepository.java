package com.prueba.sistema.repositories;

import com.prueba.sistema.models.Compra;
import com.prueba.sistema.models.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByIdUsuario(Long idUsuario);
    /*List<Compra> findByIdUsuarioAndFechaCompra(Long idUsuario, Date fechaCompra);*/
}
