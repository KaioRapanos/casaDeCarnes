package Jaja.casaDeCarnes.repository

import Jaja.casaDeCarnes.model.Pedido
import org.springframework.data.mongodb.repository.MongoRepository

interface PedidoRepository : MongoRepository<Pedido, String> {

}