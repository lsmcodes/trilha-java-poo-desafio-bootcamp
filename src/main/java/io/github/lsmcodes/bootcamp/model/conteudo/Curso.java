package io.github.lsmcodes.bootcamp.model.conteudo;

public class Curso extends Conteudo {

        private int cargaHoraria;

        public Curso(String nome, String descricao, int cargaHoraria) {
                this.nome = nome;
                this.descricao = descricao;
                this.cargaHoraria = cargaHoraria;
        }

        public int getCargaHoraria() {
                return cargaHoraria;
        }

        @Override
        public double calcularXp() {
                return XP_PADRAO * cargaHoraria;
        }

        @Override
        public String toString() {
                return "Nome: \"" + getNome() + "\", descricao: \"" + getDescricao() + "\", carga horaria: "
                                + cargaHoraria;
        }

}