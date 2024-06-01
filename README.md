# DIO - Trilha POO Java
www.dio.me

## Autora do Desafio e Repositório Original
- [Camila Cavalcante](https://github.com/cami-la)
- [Desafio POO](https://github.com/cami-la/desafio-poo-dio)

## Desafio de Projeto
Considerando o seu conhecimento no domínio bootcamp e no domínio de Programação Orientada a Objetos, siga os passos a seguir e como desafio, implemente as evoluções que achar interessantes.

1. Abstraia o domínio Bootcamp e modele seus atributos e métodos;
2. Crie as classes: `Bootcamp`, `Cursos`, `Mentorias` e `Devs` e as relacione;
3. Modele as classes criadas, ou seja, crie seus atributos e métodos;
4. Para que o código fique mais legível e de fácil manutenção, utilize de algumas das ferramentas que o Paradigma de Orientação a Objetos (POO) nos oferece: `Abstração`, `Encapsulamento`, `Herança` e `Polimorfismo`;
5. E para representar classes que foram criadas e relacionadas, transforme-as em objetos.

## Conceitos Fundamentais
### Domínio
`Domínio` se refere à área temática ou escopo de problema que o sistema de software está sendo construído para abordar. Engloba os conceitos, regras e processos do mundo real que o software é destinado a modelar. Por exemplo, em uma aplicação bancária, o domínio que também é conhecido como `camada de negócio` ou `camada de objetos de negócio` inclui classes correspondentes a conceitos como contas, transações, clientes e regulações relacionadas a operações bancárias.

### Classe
`Classe` é como um molde ou uma planta que define o `tipo` dos objetos que são criados a partir dela. No mundo real frequentemente encontramos diversos objetos individuais que são do mesmo tipo. Podem existir milhares de bicicletas, todas da mesma marca e modelo. Cada bicicleta foi construída a partir do mesmo conjunto de plantas e portanto, contém os mesmos componentes. Em termos orientados a objetos, podemos dizer que todas essas bicicletas são `instâncias` da classe de `objetos` conhecidos como bicicletas.
```java
class Bicicleta {
  int cadencia = 0;
  int velocidade = 0;
  int engrenagem = 1;

  void mudarCadencia(int novoValor) {
    cadencia = novoValor;
  }

  void mudarEngrenagem(int novoValor) {
    engrenagem = novoValor;
  }

  void aumentarVelocidade(int incremento) {
    velocidade = velocidade + incremento;   
  }

  void aplicarFreios(int decremento) {
    velocidade = velocidade - decremento;
  }

  void imprimirEstados() {
    System.out.println("cadência:" +
         cadencia + " velocidade:" + 
         velocidade + " engrenagem:" + engrenagem);
    }
}
```

### Objeto
`Objetos` no mundo real compartilham duas características: estado e comportamento. Cachorros possuem estado (nome, cor, raça) e comportamento (latir, abanar o rabo, correr). Objetos de software são conceitualmente similares a objetos do mundo real: eles também consistem em estado e comportamento relacionado. Um objeto armazena seu estado em campos (também chamados de `atributos` ou propriedades) e expõe seu comportamento por meio de `métodos`.

```java
Bicicleta bicicleta = new Bicicleta();
```

### Instância
`Instância` é uma cópia executável de uma classe. Outro nome para instância é objeto.
```java
Bicicleta bicicleta = new Bicicleta();
bicicleta.aumentarVelocidade(15);
```

### Atributo
`Atributos` são variáveis dentro de uma classe que definem o `estado` da mesma.
```java
class Bicicleta {
  int cadencia = 0;
  int velocidade = 0;
  int engrenagem = 1;
}
```

### Variáveis
`Variáveis` são "locais" reservados na memória para armazenar um determinado tipo de dado. Existem quatro tipos de variáveis: variáveis de instância (campos não estáticos), variáveis de classe (campos estáticos), variáveis locais e parâmetros.
```java
int engrenagem = 1;
```

### Método
`Métodos` são blocos de código que apenas são executados quando chamados. Podem receber dados por meio de parâmetros e `definem o comportamento` da classe e dos objetos criados a partir dela.
```java
void mudarCadencia(int novoValor) {
  cadencia = novoValor;
}
```
## Referências
- Domain-Driven Design (DDD) - https://www.geeksforgeeks.org/domain-driven-design-ddd/
- What Is a Class? - https://docs.oracle.com/javase/tutorial/java/concepts/class.html
- What Is an Object? - https://docs.oracle.com/javase/tutorial/java/concepts/object.html
- Object-Oriented Programming - https://www.oracle.com/java/technologies/oop.html
- Variables - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
- Declaring Classes - https://docs.oracle.com/javase/tutorial/java/javaOO/classdecl.html