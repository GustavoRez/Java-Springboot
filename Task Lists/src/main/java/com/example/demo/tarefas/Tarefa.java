package com.example.demo.tarefas;

public class Tarefa {
    private long id;
    private String titulo;
    private boolean concluida;
    private String descricao;

    public Tarefa() {}

    public Tarefa(Long id, String titulo, boolean concluida, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = concluida;
        this.descricao = descricao;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    
    public boolean isConcluida() {return concluida;}
    public void setConcluida(boolean concluida) {this.concluida = concluida;}
    
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
