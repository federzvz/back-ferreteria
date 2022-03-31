package co.com.sofka.ferreteria.repository;

import co.com.sofka.ferreteria.domain.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IFacturaRepository extends ReactiveMongoRepository<Factura, String> {

}
