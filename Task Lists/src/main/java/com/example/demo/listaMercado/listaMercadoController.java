package com.example.demo.listaMercado;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/listaMercado")
public class listaMercadoController {

    private List<listaMercado> itens = new ArrayList<>();
    private Long contadorId = 1L;

    @GetMapping
    public List<listaMercado> listar() {
        return itens;
    }

    @GetMapping("/{id}")
    public listaMercado buscarPorId(@PathVariable Long id) {
        return itens.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public listaMercado criar(@RequestBody listaMercado item) {
        item.setId(contadorId++);

        float valor = (item.getPreco() > 10.0) ? item.getPreco() * 0.9f : item.getPreco();

        item.setPreco(valor);
        
        itens.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean remove = itens.removeIf(i -> i.getId().equals(id));

        if(remove){
            return "Item com ID " + id + " removido com sucesso.";
        } else {
            return "Item com ID " + id + " não encontrado.";
        }
    }
}
