package Jaja.casaDeCarnes.service

import Jaja.casaDeCarnes.model.Pedido
import Jaja.casaDeCarnes.repository.PedidoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PedidoService {

    @Autowired
    lateinit var pedidoRepository: PedidoRepository

    fun criarPedido(pedido: Pedido): Pedido{
        return pedidoRepository.save(pedido)
    }

    fun buscarPedidoPorId(id: String): Pedido{
        return pedidoRepository.findById(id)
            .orElseThrow{RuntimeException("Pedido nao enconttrado com o ID: $id")}
    }

    fun listarPedidos(): List<Pedido>{
        return pedidoRepository.findAll()
    }

    fun atualizarPedido(id: String, pedido: Pedido): Pedido{
        if(!pedidoRepository.existsById(id)){
            throw RuntimeException("Pedido nao encontrado com ID: $id")
        }
        pedido.id = id
        return pedidoRepository.save(pedido)
    }

    fun deletarPedido(id: String){
        if(!pedidoRepository.existsById(id)){
            throw RuntimeException("Pedido nao encontrado com ID: $id")
        }
        pedidoRepository.deleteById(id)
    }

}
