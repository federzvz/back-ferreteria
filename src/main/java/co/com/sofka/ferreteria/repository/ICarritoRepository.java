package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Carrito;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICarritoRepository extends ReactiveMongoRepository<Carrito, String> {

}
