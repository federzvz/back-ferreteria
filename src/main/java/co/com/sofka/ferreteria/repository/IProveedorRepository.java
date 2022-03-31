package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
    Mono<Proveedor> findByDocumento(String documento);
    Mono<Proveedor> deleteByDocumento(String documento);
}
