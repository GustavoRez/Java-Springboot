package com.example.demo.tarefas;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Long contadorId = 1L;

    @GetMapping
    public List<Tarefa> listar() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        tarefa.setId(contadorId++);
        tarefas.add(tarefa);
        return tarefa;
    }

    @PutMapping("/{id}")
    public void concluir(@PathVariable Long id) {
        tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(t -> t.setConcluida(t.isConcluida() ? false : true));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean removed = tarefas.removeIf(t -> t.getId().equals(id));
        if (removed) {
            return "Tarefa removida com sucesso!";
        } else {
            return "Tarefa não encontrada!";
        }
    }

}