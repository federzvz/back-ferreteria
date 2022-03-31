package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Bodega;
import co.com.sofka.ferreteria.repository.IBodegaRepository;
import co.com.sofka.ferreteria.service.icontroller.IBodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BodegaService implements IBodegaService {

    @Autowired
    private IBodegaRepository iBodegaRepository;

    @Override
    public Mono<Bodega> save(Bodega bodega){
        return this.iBodegaRepository.save(bodega);
    }

    @Override
    public Mono<Bodega> delete(String id){
        return this.iBodegaRepository
                .findById(id)
                .flatMap(b -> this.iBodegaRepository.deleteById(b.getId()).thenReturn(b));
    }

    @Override
    public Mono<Bodega> update(String id, Bodega bodega){
        return this.iBodegaRepository.findById(id)
                .flatMap(b -> {
                    bodega.setId(id);
                    return save(bodega);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Bodega> findAll(){
        return this.iBodegaRepository.findAll();
    }

    @Override
    public Mono<Bodega> findById(String id){
        return this.iBodegaRepository.findById(id);
    }
}
