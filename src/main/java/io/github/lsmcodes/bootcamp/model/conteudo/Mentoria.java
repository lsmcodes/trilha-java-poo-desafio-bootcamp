package io.github.lsmcodes.bootcamp.model.conteudo;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

        private LocalDate data;

        public Mentoria(String nome, String descricao, LocalDate data) {
                this.nome = nome;
                this.descricao = descricao;
                this.data = data;
        }

        public LocalDate getDate() {
                return data;
        }

        @Override
        public double calcularXp() {
                return XP_PADRAO;
        }

        @Override
        public String toString() {
                return "Nome: \"" + getNome() + "\", descricao: \"" + getDescricao() + "\", data: "
                                + data;
        }

}