package com.example.app.demo.resources;

import com.example.app.demo.domain.Pedido;
import com.example.app.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id) {
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<Pedido>> findPage(@RequestParam(value="page", defaultValue = "0") Integer page, @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, @RequestParam(value="direction", defaultValue = "DESC") String direction, @RequestParam(value="orderBy", defaultValue = "instante") String orderBy) throws AuthenticationException {
        Page<Pedido> list = service.findPage(page, linesPerPage, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }
}
