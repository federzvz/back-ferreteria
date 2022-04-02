package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.DTOs.ClienteDTO;
import co.com.sofka.ferreteria.domain.Cliente;
import co.com.sofka.ferreteria.service.icontroller.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) {
        Cliente c = new Cliente(clienteDTO.getDocumento(), clienteDTO.getNombre(), clienteDTO.getCelular());
        return this.iClienteService.save(c).thenReturn(clienteDTO);
    }

    @GetMapping(value = "/")
    private Flux<ClienteDTO> findAll() {
        return this.iClienteService.findAll().map(c -> new ClienteDTO(c.getDocumento(),c.getNombre(),c.getCelular()));
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Cliente>> update(@PathVariable("id") String id, @RequestBody ClienteDTO clienteDTO) {
        return this.iClienteService.update(id, new Cliente(
                clienteDTO.getDocumento(),
                        clienteDTO.getNombre(),
                        clienteDTO.getCelular()))
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iClienteService.findByDocumento(id).block().toString());
    }
}
