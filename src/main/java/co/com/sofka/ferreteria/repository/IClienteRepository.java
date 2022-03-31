package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Mono<Cliente> findByDocumento(String documento);
    Mono<Cliente> deleteByDocumento(String documento);
}
