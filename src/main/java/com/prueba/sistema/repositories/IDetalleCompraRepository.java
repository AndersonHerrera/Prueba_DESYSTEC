package com.prueba.sistema.repositories;

import com.prueba.sistema.models.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
    List<DetalleCompra> findAllByIdCompra(Long idCompra);
}
