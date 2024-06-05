package io.github.lsmcodes.bootcamp.model.bootcamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import io.github.lsmcodes.bootcamp.model.conteudo.Conteudo;
import io.github.lsmcodes.bootcamp.model.conteudo.Curso;
import io.github.lsmcodes.bootcamp.model.conteudo.Mentoria;
import io.github.lsmcodes.bootcamp.model.dev.Dev;

public class Bootcamp {

        private Scanner scanner = new Scanner(System.in);

        private String nome;
        private String descricao;
        private LocalDate dataInicial;
        private LocalDate dataFinal;
        private List<Conteudo> conteudos;
        private List<Dev> devsInscritos;

        public Bootcamp(String nome, String descricao) {
                this.nome = nome;
                this.descricao = descricao;
                this.dataInicial = LocalDate.now();
                this.dataFinal = this.dataInicial.plusDays(45);
                this.conteudos = new ArrayList<>();
                this.devsInscritos = new ArrayList<>();
        }

        public String getNome() {
                return nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public LocalDate getDataInicial() {
                return dataInicial;
        }

        public LocalDate getDataFinal() {
                return dataFinal;
        }

        public List<Conteudo> getConteudos() {
                return conteudos;
        }

        public List<Dev> getDevsInscritos() {
                return devsInscritos;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;

                if ((obj == null) || !(obj instanceof Bootcamp))
                        return false;

                Bootcamp bootcamp = (Bootcamp) obj;
                return Objects.equals(nome, bootcamp.getNome())
                                && Objects.equals(descricao, bootcamp.getDescricao())
                                && Objects.equals(dataInicial, bootcamp.getDataInicial())
                                && Objects.equals(dataFinal, bootcamp.getDataFinal())
                                && Objects.equals(conteudos, bootcamp.getConteudos())
                                && Objects.equals(devsInscritos, bootcamp.getDevsInscritos());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getNome(), getDescricao(), getDataInicial(), getDataFinal(), getConteudos(),
                                getDevsInscritos());
        }

        @Override
        public String toString() {
                return "Nome: \"" + getNome() + "\", descricao: \"" + getDescricao() + "\" data: " + dataInicial + " - "
                                + dataFinal;
        }

        public void adicionarCursosAoBootcamp(Bootcamp bootcamp) {
                System.out.println("Quantos cursos ele tera?");
                int quantidadeCursos = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < quantidadeCursos; i++) {
                        System.out.println("Nome do curso:");
                        String nomeDoCurso = scanner.nextLine();

                        System.out.println("Descricao do curso:");
                        String descricaoDoCurso = scanner.nextLine();

                        System.out.println("Carga horaria do curso:");
                        int cargaHoraria = Integer.parseInt(scanner.nextLine());

                        Curso curso = new Curso(nomeDoCurso, descricaoDoCurso, cargaHoraria);
                        bootcamp.getConteudos().add(curso);
                }
        }

        public void adicionarMentoriasAoBootcamp(Bootcamp bootcamp) {
                System.out.println("Quantas mentorias ele terá?");
                int quantidadeMentorias = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < quantidadeMentorias; i++) {
                        System.out.println("Nome da mentoria:");
                        String nomeDaMentoria = scanner.nextLine();

                        System.out.println("Descricao da mentoria:");
                        String descricaoDaMentoria = scanner.nextLine();

                        System.out.println("Data da mentoria");

                        System.out.println("Ano:");
                        int ano = Integer.parseInt(scanner.nextLine());

                        System.out.println("Mes:");
                        int mes = Integer.parseInt(scanner.nextLine());

                        System.out.println("Dia:");
                        int dia = Integer.parseInt(scanner.nextLine());

                        LocalDate dataDaMentoria = LocalDate.of(ano, mes, dia);

                        Mentoria mentoria = new Mentoria(nomeDaMentoria, descricaoDaMentoria,
                                        dataDaMentoria);
                        bootcamp.getConteudos().add(mentoria);
                }
        }

}