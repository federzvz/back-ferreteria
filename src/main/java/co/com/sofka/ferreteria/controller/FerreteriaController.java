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
public class FerreteriaController {

    @Autowired
    private IProductoService iProductoService;
    //static final String PATH ="/error";

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Producto> save(@RequestBody Producto producto) {
        return iProductoService.save(producto);
    }

    @GetMapping(value = "/producto/get")
    private Flux<Producto> findAll() {
        int x=2;
        return this.iProductoService.findAll();
    }



    /*@RequestMapping(value = PATH)
    public ResponseEntity<String> error() {
        return new ResponseEntity<String>("No se ha encontrado ninguna página web para URL especificada.",HttpStatus.NOT_FOUND);
    }*/
}
