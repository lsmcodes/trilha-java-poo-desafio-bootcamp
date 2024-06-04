package io.github.lsmcodes.bootcamp.model.conteudo;

public abstract class Conteudo {

        protected static final double XP_PADRAO = 10d;

        protected String nome;
        protected String descricao;

        public String getNome() {
                return nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public abstract double calcularXp();

}