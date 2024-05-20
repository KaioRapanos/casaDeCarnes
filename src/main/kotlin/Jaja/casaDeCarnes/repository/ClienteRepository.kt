package Jaja.casaDeCarnes.repository

import Jaja.casaDeCarnes.model.Cliente
import org.springframework.data.mongodb.repository.MongoRepository

interface ClienteRepository : MongoRepository<Cliente, String> {

}