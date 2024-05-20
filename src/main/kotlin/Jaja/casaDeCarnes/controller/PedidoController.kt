package Jaja.casaDeCarnes.controller

import Jaja.casaDeCarnes.model.Pedido
import Jaja.casaDeCarnes.service.PedidoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/pedidos")
@CrossOrigin(origins = arrayOf("http://127.0.0.1:5500"))
class PedidoController {

    @Autowired
    lateinit var pedidoService: PedidoService

    @PostMapping
    fun criarPedido(@RequestBody pedido: Pedido): Pedido{
        return pedidoService.criarPedido(pedido)
    }

    @GetMapping("/{id}")
    fun buscarPedidoPorId(@PathVariable id: String): Pedido{
        return pedidoService.buscarPedidoPorId(id)
    }

    @GetMapping
    fun listarPedidos(): List<Pedido>{
        return pedidoService.listarPedidos()
    }

    @PutMapping("/{id}")
    fun atualizarPedido(@PathVariable id: String, @RequestBody pedido: Pedido): Pedido{
        return pedidoService.atualizarPedido(id, pedido)
    }

    @DeleteMapping("/{id}")
    fun deletarPedido(@PathVariable id: String){
        pedidoService.deletarPedido(id)
    }

}