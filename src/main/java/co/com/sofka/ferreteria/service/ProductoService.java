package co.com.sofka.ferreteria.service;

import co.com.sofka.ferreteria.domain.Producto;
import co.com.sofka.ferreteria.repository.IProductoRepository;
import co.com.sofka.ferreteria.service.icontroller.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public Mono<Producto> save(Producto producto){
        return this.iProductoRepository.save(producto);
    }

    @Override
    public Mono<Producto> delete(String id){
        return this.iProductoRepository
                .findById(id)
                .flatMap(p -> this.iProductoRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<Producto> update(String id, Producto producto){
        return this.iProductoRepository.findById(id)
                .flatMap(p -> {
                    producto.setId(id);
                    return save(producto);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Producto> findAll(){
        return this.iProductoRepository.findAll();
    }

    @Override
    public Mono<Producto> findById(String id){
        return this.iProductoRepository.findById(id);
    }
}
