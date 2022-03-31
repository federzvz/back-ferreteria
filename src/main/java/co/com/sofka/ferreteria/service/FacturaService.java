package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Factura;
import co.com.sofka.ferreteria.repository.IFacturaRepository;
import co.com.sofka.ferreteria.service.icontroller.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private IFacturaRepository iFacturaRepository;

    @Override
    public Mono<Factura> save(Factura factura) {
        return this.iFacturaRepository.save(factura);
    }

    @Override
    public Mono<Factura> delete(String id) {
        return this.iFacturaRepository
                .findById(id)
                .flatMap(f -> this.iFacturaRepository.deleteById(f.getId()).thenReturn(f));
    }

    @Override
    public Mono<Factura> update(String id, Factura factura) {
        return this.iFacturaRepository.findById(id)
                .flatMap(b -> {
                    factura.setId(b.getId());
                    return save(factura);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Factura> findAll() {
        return this.iFacturaRepository.findAll();
    }

    @Override
    public Mono<Factura> findById(String id) {
        return this.iFacturaRepository.findById(id);
    }
}
