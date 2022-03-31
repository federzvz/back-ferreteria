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
@CrossOrigin(origins = "*")
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private IBodegaService iBodegaService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Bodega> save(@RequestBody Bodega bodega) {
        return this.iBodegaService.save(bodega);
    }

    @GetMapping(value = "/")
    private Flux<Bodega> findAll() {
        return this.iBodegaService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Bodega>> update(@PathVariable("id") String id, @RequestBody Bodega bodega) {
        return this.iBodegaService.update(id, bodega)
                .flatMap(b -> Mono.just(ResponseEntity.ok(b)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iBodegaService.findById(id).block().toString());
    }

}
