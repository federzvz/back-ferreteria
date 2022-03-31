package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Bodega;
import co.com.sofka.ferreteria.service.icontroller.IBodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BodegaController {
    @Autowired
    private IBodegaService iBodegaService;

    @PostMapping("/bodega")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Bodega> save(@RequestBody Bodega bodega) {
        return this.iBodegaService.save(bodega);
    }

    @GetMapping(value = "/bodega")
    private Flux<Bodega> findAll() {
        return this.iBodegaService.findAll();
    }

    @PutMapping(value = "/bodega/{id}")
    private Mono<ResponseEntity<Bodega>> update(@PathVariable("id") String id, @RequestBody Bodega bodega) {
        return this.iBodegaService.update(id, bodega)
                .flatMap(b -> Mono.just(ResponseEntity.ok(b)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "bodega/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iBodegaService.findById(id).block().toString());
    }

}
