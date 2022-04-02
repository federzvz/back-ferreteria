package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IVolanteRepository extends ReactiveMongoRepository<Volante, String> {

}
