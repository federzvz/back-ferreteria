package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IProductoService {
    Mono<Producto> save(Producto producto);

    Mono<Producto> delete(String id);

    Mono<Producto> update(String id, Producto producto);

    Flux<Producto> findAll();

    Mono<Producto> findById(String id);
}
