package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Proveedor;
import co.com.sofka.ferreteria.service.icontroller.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private IProveedorService iProveedorService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Proveedor> save(@RequestBody Proveedor proveedor) {
        return this.iProveedorService.save(proveedor);
    }

    @GetMapping(value = "/")
    private Flux<Proveedor> findAll() {
        return this.iProveedorService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Proveedor>> update(@PathVariable("id") String id, @RequestBody Proveedor proveedor) {
        return this.iProveedorService.update(id, proveedor)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iProveedorService.findByDocumento(id).block().toString());
    }
}
