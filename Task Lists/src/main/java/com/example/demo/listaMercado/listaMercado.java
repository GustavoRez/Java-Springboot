package com.example.demo.listaMercado;

public class listaMercado {
    private Long id;
    private String nome;
    private String quantidade;
    private float preco;

    public listaMercado() {}

    public listaMercado(Long id, String nome, String quantidade, float preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getQuantidade() {return quantidade;}
    public void setQuantidade(String quantidade) {this.quantidade = quantidade;}

    public float getPreco() {return preco;}
    public void setPreco(float preco) {this.preco = preco;}
}
