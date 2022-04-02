package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Volante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVolanteService {
    Mono<Volante> save(Volante volante);

    Mono<Volante> delete(String id);

    Mono<Volante> update(String id, Volante volante);

    Flux<Volante> findAll();

    Mono<Volante> findById(String id);
}
