package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Bodega;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBodegaService {
    Mono<Bodega> save(Bodega producto);

    Mono<Bodega> delete(String id);

    Mono<Bodega> update(String id, Bodega producto);

    Flux<Bodega> findAll();

    Mono<Bodega> findById(String id);

}
