package co.com.sofka.ferreteria.service.icontroller;

import co.com.sofka.ferreteria.domain.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {
    Mono<Cliente> save(Cliente cliente);

    Mono<Cliente> deleteByDocumento(String id);

    Mono<Cliente> update(String id, Cliente cliente);

    Flux<Cliente> findAll();

    Mono<Cliente> findByDocumento(String id);
}
