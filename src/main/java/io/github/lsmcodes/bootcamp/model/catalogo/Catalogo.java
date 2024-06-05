package io.github.lsmcodes.bootcamp.model.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.github.lsmcodes.bootcamp.model.bootcamp.Bootcamp;
import io.github.lsmcodes.bootcamp.model.conteudo.Conteudo;
import io.github.lsmcodes.bootcamp.model.dev.Dev;

public class Catalogo {

        private Scanner scanner = new Scanner(System.in);

        private Dev dev;
        private Bootcamp bootcampAtual;
        private List<Bootcamp> bootcamps;

        public Catalogo() {
                this.bootcamps = new ArrayList<>();
        }

        public Dev getDev() {
                return dev;
        }

        public Bootcamp getBootcampAtual() {
                return bootcampAtual;
        }

        public List<Bootcamp> getBootcamps() {
                return bootcamps;
        }

        public void setDev(Dev dev) {
                this.dev = dev;
        }

        public void setBootcampAtual(Bootcamp bootcampAtual) {
                this.bootcampAtual = bootcampAtual;
        }

        public void mostrarMenu() {
                boolean mostrarMenu = true;
                String opcao;

                while (mostrarMenu) {
                        if (getDev() == null) {
                                System.out.println("\nMenu:\n"
                                                + "1 - Adicionar bootcamp\n"
                                                + "2 - Fazer cadastro para acessar bootcamps\n"
                                                + "Para sair, apenas digite qualquer outro numero");

                                opcao = scanner.nextLine();

                                switch (opcao) {
                                        case "1":
                                                criarBootcamp();
                                                break;
                                        case "2":
                                                fazerCadastro();
                                                break;
                                        default:
                                                mostrarMenu = false;
                                                break;
                                }
                        } else {
                                System.out.println("\nMenu:\n"
                                                + "1 - Adicionar outro bootcamp\n"
                                                + "2 - Se inscrever em um bootcamp\n"
                                                + "3 - Concluir um conteúdo do bootcamp\n"
                                                + "4 - Exibir XP total\n"
                                                + "5 - Cancelar inscrição no bootcamp atual\n"
                                                + "Para sair, apenas digite qualquer outro numero");

                                opcao = scanner.nextLine();

                                switch (opcao) {
                                        case "1":
                                                criarBootcamp();
                                                break;
                                        case "2":
                                                System.out.println("Escolha um bootcamp:");
                                                exibirBootcamps();

                                                int bootcampIndex = Integer.parseInt(scanner.nextLine());
                                                Bootcamp bootcampEscolhido = bootcamps.get(bootcampIndex - 1);

                                                getDev().fazerInscricao(bootcampEscolhido);
                                                setBootcampAtual(bootcampEscolhido);
                                                break;
                                        case "3":
                                                System.out.println("Escolha o conteudo que quer concluir:");
                                                exibirConteudosPendentes();

                                                int conteudoIndex = Integer.parseInt(scanner.nextLine());
                                                Conteudo conteudo = getDev().getConteudosPendentes().get(conteudoIndex - 1);

                                                getDev().concluirConteudo(conteudo, getBootcampAtual());
                                                if(getDev().getConteudosPendentes().isEmpty()) {
                                                        setBootcampAtual(null);
                                                }
                                                break;
                                        case "4":
                                                getDev().calcularXpTotal();
                                                break;
                                        case "5":
                                                getDev().cancelarInscricao(bootcampAtual);
                                                setBootcampAtual(null);
                                                break;
                                        default:
                                                mostrarMenu = false;
                                                break;
                                }
                        }
                }

                scanner.close();
        }

        public void criarBootcamp() {
                System.out.println("Nome do bootcamp:");
                String nomeDoBootcamp = scanner.nextLine();

                System.out.println("Descricao do bootcamp:");
                String descricaoDoBootcamp = scanner.nextLine();

                Bootcamp bootcamp = new Bootcamp(nomeDoBootcamp, descricaoDoBootcamp);

                bootcamp.adicionarCursosAoBootcamp(bootcamp);
                bootcamp.adicionarMentoriasAoBootcamp(bootcamp);

                getBootcamps().add(bootcamp);
        }

        public void fazerCadastro() {
                if (getBootcamps().isEmpty()) {
                        System.err.println("Adicione ao menos um bootcamp primeiro.");
                } else {
                        System.out.println("Digite seu nome:");
                        String nome = scanner.nextLine();

                        setDev(new Dev(nome));
                }
        }

        public void exibirBootcamps() {
                int index = 0;
                for (Bootcamp bootcamp : getBootcamps()) {
                        System.out.println((index += 1) + " - " + bootcamp.toString());
                }
        }

        public void exibirConteudosPendentes() {
                int conteudoNumeracao = 0;
                for (Conteudo conteudoPendente : getDev().getConteudosPendentes()) {
                        System.out.println((conteudoNumeracao += 1) + " - "
                                        + conteudoPendente.toString());
                }
        }

}