package Jaja.casaDeCarnes.model

data class Endereco(
    var cep: String = "",
    var endereco: String = "",
    var numero: Int,
    var complemento: String = "",
)
