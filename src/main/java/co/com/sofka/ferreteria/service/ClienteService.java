package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Cliente;
import co.com.sofka.ferreteria.repository.IClienteRepository;
import co.com.sofka.ferreteria.service.icontroller.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public Mono<Cliente> save(Cliente cliente){
        return this.iClienteRepository.save(cliente);
    }

    @Override
    public Mono<Cliente> deleteByDocumento(String ci){
        return this.iClienteRepository
                .findByDocumento(ci)
                .flatMap(c -> this.iClienteRepository.deleteByDocumento(c.getDocumento()).thenReturn(c));
    }

    @Override
    public Mono<Cliente> update(String ci, Cliente cliente){
        return this.iClienteRepository.findByDocumento(ci)
                .flatMap(b -> {
                    cliente.setDocumento(ci);
                    return save(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Cliente> findAll(){
        return this.iClienteRepository.findAll();
    }

    @Override
    public Mono<Cliente> findByDocumento(String ci){
        return this.iClienteRepository.findByDocumento(ci);
    }
}
