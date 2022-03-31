package co.com.sofka.ferreteria.controller;

import co.com.sofka.ferreteria.domain.Producto;
import co.com.sofka.ferreteria.service.icontroller.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;
    //static final String PATH ="/error";

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Producto> save(@RequestBody Producto producto) {
        return this.iProductoService.save(producto);
    }

    @GetMapping(value = "/")
    private Flux<Producto> findAll() {
        return this.iProductoService.findAll();
    }

    @PutMapping(value = "/{id}")
    private Mono<ResponseEntity<Producto>> update(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.iProductoService.update(id, producto)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/{id}")
    private Mono<String> getById(@PathVariable String id){
        return Mono.just(this.iProductoService.findById(id).block().toString());
    }


    /*@RequestMapping(value = PATH)
    public ResponseEntity<String> error() {
        return new ResponseEntity<String>("No se ha encontrado ninguna página web para URL especificada.",HttpStatus.NOT_FOUND);
    }*/
}
