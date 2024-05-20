package Jaja.casaDeCarnes.service

import Jaja.casaDeCarnes.dto.ProdutoDTO
import Jaja.casaDeCarnes.enummeration.Tipo
import Jaja.casaDeCarnes.model.Produto
import Jaja.casaDeCarnes.repository.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val produtoRepository: ProdutoRepository) {

    fun salvarProduto(produtoDTO: ProdutoDTO): Produto {
        val produto = fromProdutoDTO(produtoDTO)
        return produtoRepository.save(produto)
    }

    fun obterProduto(id: String): Produto? {
        return produtoRepository.findById(id).orElse(null)
    }

    fun listarProdutos(): List<Produto>{
        return produtoRepository.findAll()
    }

    fun atualizatProduto(id: String, novoProduto: Produto): Produto? {
        val produtoExistente = produtoRepository.findById(id)
        if (produtoExistente.isPresent) {
            val produto = produtoExistente.get()
            val produtoAtualizado = produto.copy(
            nome = novoProduto.nome,
            descricao = novoProduto.descricao,
            preco = novoProduto.preco,
            imagemUrl = novoProduto.imagemUrl,
            tipo = novoProduto.tipo,
            )
            return produtoRepository.save(produtoAtualizado)
        }
        return null
    }

    fun deletarProduto(id: String){
        produtoRepository.deleteById(id)
    }

    fun listarProdutosPorTipo(tipo: Tipo): List<Produto> {
        return produtoRepository.findByTipo(tipo)

    }

    fun toProdutoDTO(produto: Produto): ProdutoDTO {
        return ProdutoDTO(
            nome = produto.nome,
            descricao = produto.descricao,
            preco = produto.preco,
            imagemUrl = produto.imagemUrl,
            tipo = produto.tipo
        )

    }
    private fun fromProdutoDTO(produtoDTO: ProdutoDTO): Produto {
        return Produto(
            nome = produtoDTO.nome,
            descricao = produtoDTO.descricao,
            preco = produtoDTO.preco,
            imagemUrl = produtoDTO.imagemUrl,
            tipo = produtoDTO.tipo
        )
    }
}