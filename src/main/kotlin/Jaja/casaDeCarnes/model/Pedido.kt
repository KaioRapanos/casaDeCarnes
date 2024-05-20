package Jaja.casaDeCarnes.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "JajaCasaDeCarnes")
data class Pedido(
    @Id
    var id: String = UUID.randomUUID().toString(),
    var cliente: Cliente? = null,
    var produto: List<Produto> = mutableListOf(),
)
