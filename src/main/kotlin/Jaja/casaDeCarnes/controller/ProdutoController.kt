package Jaja.casaDeCarnes.controller

import Jaja.casaDeCarnes.dto.ProdutoDTO
import Jaja.casaDeCarnes.enummeration.Tipo
import Jaja.casaDeCarnes.model.Produto
import Jaja.casaDeCarnes.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = arrayOf("http://127.0.0.1:5500"))
class ProdutoController() {

    @Autowired
    lateinit var produtoService: ProdutoService

    @GetMapping("/{id}")
    fun obterProduto(@PathVariable id: String): Produto? {
        return produtoService.obterProduto(id)
    }

    @GetMapping
    fun listarProdutos(): List<Produto>{
        return produtoService.listarProdutos()
    }

    @GetMapping("/{tipo}/listar")
    fun listarProdutoPorTipo(@PathVariable tipo: Tipo): List<Produto>{
        return produtoService.listarProdutosPorTipo(tipo)
    }

    @PostMapping
    fun criarProduto(@RequestBody produtoDTO: ProdutoDTO): ProdutoDTO {
        val produtoSalvo = produtoService.salvarProduto(produtoDTO)
        return produtoService.toProdutoDTO(produtoSalvo)
    }

    @PutMapping("/{id}")
    fun atualizarProduto(@PathVariable id: String, @RequestBody produto: Produto): Produto? {
        return produtoService.atualizatProduto(id, produto)
    }

    @DeleteMapping("/{id}")
    fun deletarProduto(@PathVariable id: String){
        produtoService.deletarProduto(id)
    }

}