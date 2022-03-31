package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Factura;
import co.com.sofka.ferreteria.service.icontroller.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private IFacturaService iFacturaService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> save(@RequestBody Factura factura) {
        return this.iFacturaService.save(factura);
    }

    @GetMapping(value = "/")
    private Flux<Factura> findAll() {
        return this.iFacturaService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Factura>> update(@PathVariable("id") String id, @RequestBody Factura factura) {
        return this.iFacturaService.update(id, factura)
                .flatMap(f -> Mono.just(ResponseEntity.ok(f)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iFacturaService.findById(id).block().toString());
    }

}
