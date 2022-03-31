package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Bodega;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBodegaRepository extends ReactiveMongoRepository<Bodega, String> {

}
