package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Carrito;
import co.com.sofka.ferreteria.service.icontroller.ICarritoService;
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
}
