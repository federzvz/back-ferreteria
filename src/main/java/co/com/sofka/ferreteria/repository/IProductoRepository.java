package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

public interface IProductoRepository extends ReactiveMongoRepository<Producto, String> {

}
