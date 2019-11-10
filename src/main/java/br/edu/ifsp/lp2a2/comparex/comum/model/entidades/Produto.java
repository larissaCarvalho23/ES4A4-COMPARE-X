package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Comparable<Produto> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private Long pontuacao;
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void adicionarPontuacao(){
        ++this.pontuacao;
    }
    
    public Long getPontuacao(){
        return this.pontuacao;
    }
    @Override
    public int compareTo(Produto another){
        return (this.pontuacao == another.pontuacao) ? 0 : 
               (this.pontuacao > another.pontuacao) ? 1 :
               -1;
    }
    public Produto(){}
    public Produto(Long id, String descricao, Long pontuacao){
        this.id = id;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
    }
    @Override
    public boolean equals(Object obj){
        Produto another = (Produto) obj;
        return (this.id == another.id && 
                this.descricao == another.descricao &&
                this.pontuacao == another.pontuacao);
    }
}
