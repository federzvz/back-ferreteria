package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Volante;
import co.com.sofka.ferreteria.repository.IVolanteRepository;
import co.com.sofka.ferreteria.service.icontroller.IVolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteService implements IVolanteService {
    @Autowired
    private IVolanteRepository iVolanteRepository;

    @Override
    public Mono<Volante> save(Volante volante){
        return this.iVolanteRepository.save(volante);
    }

    @Override
    public Mono<Volante> delete(String id){
        return this.iVolanteRepository
                .findById(id)
                .flatMap(p -> this.iVolanteRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<Volante> update(String id, Volante volante){
        return this.iVolanteRepository.findById(id)
                .flatMap(p -> {
                    volante.setId(id);
                    return save(volante);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Volante> findAll(){
        return this.iVolanteRepository.findAll();
    }

    @Override
    public Mono<Volante> findById(String id){
        return this.iVolanteRepository.findById(id);
    }

}
