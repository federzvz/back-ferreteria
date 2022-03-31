package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Proveedor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProveedorService {
    Mono<Proveedor> save(Proveedor proveedor);

    Mono<Proveedor> deleteByDocumento(String id);

    Mono<Proveedor> update(String id, Proveedor proveedor);

    Flux<Proveedor> findAll();

    Mono<Proveedor> findByDocumento(String id);
}
