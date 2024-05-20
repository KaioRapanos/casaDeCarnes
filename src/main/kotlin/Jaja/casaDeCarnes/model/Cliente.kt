package Jaja.casaDeCarnes.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "JajaCasaDeCarnes")
data class Cliente(
    var id: String = UUID.randomUUID().toString(),
    var nome: String = "",
    val cpf: String = "",
    var endereco: Endereco,
    var telefone: Int,
    var email: String = "",
)
