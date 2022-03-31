package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFacturaService {
    Mono<Factura> save(Factura factura);

    Mono<Factura> delete(String id);

    Mono<Factura> update(String id, Factura factura);

    Flux<Factura> findAll();

    Mono<Factura> findById(String id);
}
