package Jaja.casaDeCarnes.dto

import Jaja.casaDeCarnes.enummeration.Tipo

data class ProdutoDTO (
    val nome: String,
    val descricao: String,
    val preco: Double,
    val imagemUrl: String,
    var tipo: Tipo = Tipo.CARNE_BOVINA
){

}