package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Carrito;
import co.com.sofka.ferreteria.domain.Factura;
import co.com.sofka.ferreteria.service.icontroller.ICarritoService;
import co.com.sofka.ferreteria.service.icontroller.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    ICarritoService iCarritoService;

    @Autowired
    IFacturaService iFacturaService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Carrito> save(@RequestBody Carrito carrito) {
        return this.iCarritoService.save(carrito);
    }

    @GetMapping(value = "/")
    private Flux<Carrito> findAll() {
        return this.iCarritoService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Carrito>> update(@PathVariable("id") String id, @RequestBody Carrito carrito) {
        return this.iCarritoService.update(id, carrito)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iCarritoService.findById(id).block().toString());
    }

    @DeleteMapping(value = "/{id}")
    private Mono<Carrito> generarFactura(@PathVariable String id){
        Carrito c = iCarritoService.findById(id).block();
        Factura f = new Factura(c.getFecha(),
                c.getCliente().getNombre(),
                c.getNombreEmpleado(),
                c.getProductosComprados(),
                c.getPrecioTotalAPagar());
        return iFacturaService.save(f).then(Mono.just(this.iCarritoService.delete(id).block()));
    }

    @DeleteMapping(value = "/rechazar/{id}")
    private Mono<Carrito> rechazarFactura(@PathVariable String id){
        return Mono.just(this.iCarritoService.delete(id).block());
    }
}
