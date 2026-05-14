package org.serratec.atividade5.controller;

import org.serratec.atividade5.model.ClienteVIP;
import org.serratec.atividade5.repository.ClienteVIPRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes-vip")
public class ClienteVIPController {

    private final ClienteVIPRepository repository;

    public ClienteVIPController(ClienteVIPRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ClienteVIP salvar(@RequestBody ClienteVIP clienteVip) {
        return repository.save(clienteVip);
    }

    @GetMapping
    public List<ClienteVIP> listar() {
        return repository.findAll();
    }
}