package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Cliente;
import co.com.sofka.ferreteria.service.icontroller.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> save(@RequestBody Cliente cliente) {
        return this.iClienteService.save(cliente);
    }

    @GetMapping(value = "/cliente")
    private Flux<Cliente> findAll() {
        return this.iClienteService.findAll();
    }

    @PutMapping(value = "/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> update(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return this.iClienteService.update(id, cliente)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/cliente/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iClienteService.findByDocumento(id).block().toString());
    }
}
