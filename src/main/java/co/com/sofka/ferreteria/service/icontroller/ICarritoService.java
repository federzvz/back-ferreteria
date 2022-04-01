package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Carrito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICarritoService {
    Mono<Carrito> save(Carrito carrito);

    Mono<Carrito> delete(String id);

    Mono<Carrito> update(String id, Carrito carrito);

    Flux<Carrito> findAll();

    Mono<Carrito> findById(String id);
}
