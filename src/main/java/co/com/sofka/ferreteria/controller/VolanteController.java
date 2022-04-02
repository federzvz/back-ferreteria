package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Volante;
import co.com.sofka.ferreteria.service.icontroller.IVolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proveedor")
public class VolanteController {

    @Autowired
    private IVolanteService iVolanteService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Volante> save(@RequestBody Volante volante) {
        return this.iVolanteService.save(volante);
    }

    @GetMapping(value = "/")
    private Flux<Volante> findAll() {
        return this.iVolanteService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Volante>> update(@PathVariable("id") String id, @RequestBody Volante volante) {
        return this.iVolanteService.update(id, volante)
                .flatMap(v -> Mono.just(ResponseEntity.ok(v)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iVolanteService.findById(id).block().toString());
    }

}
