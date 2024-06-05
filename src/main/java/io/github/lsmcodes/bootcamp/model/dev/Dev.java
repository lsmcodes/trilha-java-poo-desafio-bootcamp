package io.github.lsmcodes.bootcamp.model.dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.lsmcodes.bootcamp.model.bootcamp.Bootcamp;
import io.github.lsmcodes.bootcamp.model.conteudo.Conteudo;
import io.github.lsmcodes.bootcamp.model.conteudo.Curso;

public class Dev {
        private String nome;
        private List<Conteudo> conteudosPendentes;
        private List<Conteudo> conteudosConcluidos;

        public Dev(String nome) {
                this.nome = nome;
                this.conteudosPendentes = new ArrayList<>();
                this.conteudosConcluidos = new ArrayList<>();
        }

        public String getNome() {
                return nome;
        }

        public List<Conteudo> getConteudosPendentes() {
                return conteudosPendentes;
        }

        public List<Conteudo> getConteudosConcluidos() {
                return conteudosConcluidos;
        }

        public void fazerInscricao(Bootcamp bootcamp) {
                boolean isBootcampNull = bootcamp == null;

                if (!isBootcampNull) {
                        this.conteudosPendentes.addAll(bootcamp.getConteudos());
                        bootcamp.getDevsInscritos().add(this);

                        System.out.println("Inscricao concluida.");
                } else {
                        System.err.println(
                                        "Voce ja esta inscrito(a) em um bootcamp, conclua todos os conteudos dele ou cancele sua inscricao para se inscrever em outro bootcamp.");
                }
        }

        public void cancelarInscricao(Bootcamp bootcamp) {
                if (bootcamp != null) {
                        this.conteudosPendentes.clear();
                        bootcamp.getDevsInscritos().remove(this);
                        System.out.println("Inscricao cancelada.");
                } else {
                        System.err.println("Voce nao esta inscrito(a) em nenhum bootcamp.");
                }
        }

        public void concluirConteudo(Conteudo conteudo, Bootcamp bootcamp) {
                boolean isConteudoPendente = this.conteudosPendentes.contains(conteudo);

                if (isConteudoPendente) {
                        this.conteudosPendentes.remove(conteudo);
                        this.conteudosConcluidos.add(conteudo);

                        if(this.conteudosPendentes.isEmpty()) {
                                System.out.println("Voce finalizou o bootcamp!");
                                obterCertificado(bootcamp, this);
                                cancelarInscricao(bootcamp);
                        }
                } else {
                        System.err.println("Voce ainda nao se inscreveu em um bootcamp.");
                }
        }

        public void calcularXpTotal() {
                double xpTotal = this.conteudosConcluidos.stream()
                                .mapToDouble(Conteudo::calcularXp)
                                .sum();

                System.out.println("Seu xp total é: " + xpTotal);
        }

        public void obterCertificado(Bootcamp bootcamp, Dev dev) {
                int cargaHorariaTotal = bootcamp.getConteudos().stream()
                                .filter(conteudo -> conteudo instanceof Curso)
                                .map(conteudo -> (Curso) conteudo)
                                .mapToInt(curso -> curso.getCargaHoraria())
                                .sum();

                System.out.println(".-----------------------------------------------.\n"
                                + "|  ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___  |\n"
                                + "| |  _| _ \\ _ \\_ _|  _| __/_ _|  _| _ |   \\   | |\n"
                                + "| | |_  __/   /| | | || _| | |  |_    | | | | | |\n"
                                + "| |___|___|_\\_\\|_||___|_| |___|___|_\\_|___/___| |\n"
                                + "|                                               |\n"
                                + "|                                               |\n"
                                + "|  Certificamos que " + String.format("%-27s", dev.getNome()) + " |\n"
                                + "|  concluiu o bootcamp " + String.format("%-24s", bootcamp.getNome()) + " |\n"
                                + "|  em " + LocalDate.now() + " com o equivalente a "
                                + String.format("%-10s", cargaHorariaTotal) + " |\n"
                                + "|  horas.                                       |\n"
                                + "|                                               |\n"
                                + ".-----------------------------------------------.");
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;

                if ((obj == null) || !(obj instanceof Dev))
                        return false;

                Dev dev = (Dev) obj;
                return Objects.equals(this.nome, dev.getNome())
                                && Objects.equals(this.conteudosPendentes, dev.getConteudosPendentes())
                                && Objects.equals(this.conteudosConcluidos, dev.getConteudosConcluidos());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getNome(), getConteudosPendentes(), getConteudosConcluidos());
        }
}