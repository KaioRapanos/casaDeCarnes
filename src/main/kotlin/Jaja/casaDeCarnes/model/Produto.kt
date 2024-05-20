package Jaja.casaDeCarnes.model

import Jaja.casaDeCarnes.enummeration.Tipo
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "JajaCasaDeCarnes")
data class Produto(
    @Id
    var id: String = UUID.randomUUID().toString(),
    val nome: String,
    val descricao: String,
    val preco: Double,
    val imagemUrl: String,
    var tipo: Tipo = Tipo.CARNE_BOVINA,
) {
}