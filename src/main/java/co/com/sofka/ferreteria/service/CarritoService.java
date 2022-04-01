package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Carrito;
import co.com.sofka.ferreteria.repository.ICarritoRepository;
import co.com.sofka.ferreteria.service.icontroller.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    private ICarritoRepository iCarritoRepository;

    @Override
    public Mono<Carrito> save(Carrito carrito) {
        return this.iCarritoRepository.save(carrito);
    }

    @Override
    public Mono<Carrito> delete(String id) {
        return this.iCarritoRepository
                .findById(id)
                .flatMap(c -> this.iCarritoRepository.deleteById(c.getId()).thenReturn(c));
    }

    @Override
    public Mono<Carrito> update(String id, Carrito carrito) {
        return this.iCarritoRepository.findById(id)
                .flatMap(b -> {
                    carrito.setId(b.getId());
                    return save(carrito);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Carrito> findAll() {
        return this.iCarritoRepository.findAll();
    }

    @Override
    public Mono<Carrito> findById(String id) {
        return this.iCarritoRepository.findById(id);
    }

}
