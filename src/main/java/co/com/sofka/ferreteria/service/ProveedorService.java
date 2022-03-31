package co.com.sofka.ferreteria.service;


import co.com.sofka.ferreteria.domain.Proveedor;
import co.com.sofka.ferreteria.repository.IProveedorRepository;
import co.com.sofka.ferreteria.service.icontroller.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorService implements IProveedorService {
    @Autowired
    private IProveedorRepository iProveedorRepository;

    @Override
    public Mono<Proveedor> save(Proveedor proveedor){
        return this.iProveedorRepository.save(proveedor);
    }

    @Override
    public Mono<Proveedor> deleteByDocumento(String ci){
        return this.iProveedorRepository
                .findByDocumento(ci)
                .flatMap(c -> this.iProveedorRepository.deleteByDocumento(c.getDocumento()).thenReturn(c));
    }

    @Override
    public Mono<Proveedor> update(String ci, Proveedor cliente){
        return this.iProveedorRepository.findByDocumento(ci)
                .flatMap(b -> {
                    cliente.setDocumento(ci);
                    return save(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Proveedor> findAll(){
        return this.iProveedorRepository.findAll();
    }

    @Override
    public Mono<Proveedor> findByDocumento(String ci){
        return this.iProveedorRepository.findByDocumento(ci);
    }
}
