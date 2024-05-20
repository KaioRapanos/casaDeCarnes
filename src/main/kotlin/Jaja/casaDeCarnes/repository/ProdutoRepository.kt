package Jaja.casaDeCarnes.repository

import Jaja.casaDeCarnes.enummeration.Tipo
import Jaja.casaDeCarnes.model.Produto
import org.springframework.data.mongodb.repository.MongoRepository

interface ProdutoRepository : MongoRepository<Produto, String>{
    fun findByTipo(tipo: Tipo): List<Produto>

}
