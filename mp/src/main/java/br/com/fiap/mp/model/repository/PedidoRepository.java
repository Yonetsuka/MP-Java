package br.com.fiap.mp.model.repository;

import br.com.fiap.mp.model.entity.Pedido;
import br.com.fiap.mp.model.entity.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    List<Pedido> findByStatus(StatusPedido status);
}
