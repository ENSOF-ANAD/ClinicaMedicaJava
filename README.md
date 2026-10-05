# Clínica Médica — introdução a classes e objetos em Java

Este projeto é um exemplo didático para aprender os primeiros conceitos de **Programação Orientada a Objetos (POO)** com Java. O cenário é uma pequena clínica médica, com classes para pacientes, médicos e consultas.

Nesta etapa, o foco é entender:

- o que são classes, atributos e objetos;
- como criar objetos e acessar seus atributos;
- como objetos da mesma classe podem ter estados diferentes;
- como uma classe pode se relacionar com objetos de outras classes.

O projeto é intencionalmente simples e pode evoluir durante as aulas.

## Requisitos

- JDK 21;
- Eclipse IDE com suporte a projetos Java.

O projeto não utiliza bibliotecas externas nem ferramentas de build como Maven ou Gradle.

## Importar no Eclipse

Se você recebeu o projeto em um arquivo ZIP:

1. Acesse **File > Import > General > Existing Projects into Workspace**.
2. Selecione **Select archive file** e escolha o ZIP.
3. Clique em **Finish**.

Se você já tem a pasta do projeto descompactada:

1. Acesse **File > Import > General > Existing Projects into Workspace**.
2. Selecione **Select root directory** e escolha a pasta `ClinicaMedica`.
3. Selecione o projeto encontrado e clique em **Finish**.

Confirme que o projeto está usando um JDK 21: clique com o botão direito no projeto, abra **Properties > Java Build Path > Libraries** e selecione uma instalação Java 21 para **JRE System Library**, se necessário.

## Executar

1. No Package Explorer, abra `src > br.edu.clinica.view > Principal.java`.
2. Clique com o botão direito no editor ou no arquivo.
3. Selecione **Run As > Java Application**.
4. Consulte o resultado na aba **Console** do Eclipse.

## Estrutura do projeto

```text
ClinicaMedica
└── src
    └── br
        └── edu
            └── clinica
                ├── model
                │   ├── Consulta.java
                │   ├── Medico.java
                │   └── Paciente.java
                ├── view
                │   └── Principal.java
                └── controller
```

- **`model`** contém as classes que representam os elementos do exemplo: `Paciente`, `Medico` e `Consulta`.
- **`view`** contém `Principal`, que cria os objetos e apresenta informações no console.
- **`controller`** está reservado para etapas futuras; ainda não há classes implementadas nesse pacote.

## 1. Programação Orientada a Objetos

Um sistema pode representar conceitos do problema que está resolvendo. No cenário da clínica, por exemplo:

| Conceito | Classe no programa |
|---|---|
| Paciente | `Paciente` |
| Médico | `Medico` |
| Consulta | `Consulta` |

Classes ajudam a organizar os dados e comportamentos relacionados a esses conceitos.

## 2. O que é uma classe?

Uma classe é uma definição que descreve um tipo de objeto. Por exemplo:

```java
public class Paciente {
    public String nome;
    public int idade;
    public String cpf;
}
```

`Paciente` é o nome da classe. Ela declara quais informações cada objeto desse tipo pode armazenar.

## 3. Classes também são tipos

Java possui tipos como `int`, `double` e `boolean`. Ao declarar uma classe, também criamos um tipo que pode ser usado em variáveis:

```java
Paciente paciente1;
Medico medico1;
```

Essas declarações criam referências tipadas; para criar os objetos, usamos `new`.

## 4. O que são atributos?

Atributos são os dados que descrevem um objeto. Na classe `Paciente`, por exemplo:

```java
public String nome;
public int idade;
public String cpf;
```

Cada atributo tem um tipo:

| Atributo | Tipo | Significado neste exemplo |
|---|---|---|
| `nome` | `String` | Nome do paciente |
| `idade` | `int` | Idade em anos |
| `cpf` | `String` | Identificador do paciente |

### Por que CPF é `String`?

Embora seja formado por dígitos, CPF é um identificador, não uma quantidade usada em cálculos. Guardá-lo como texto também permite preservar zeros à esquerda e caracteres de formatação.

Esse é um exemplo de que a escolha de um tipo deve considerar o significado da informação, não apenas os caracteres que a representam.

## 5. O que é um objeto?

Uma classe define o tipo; um objeto é uma instância criada a partir dessa definição:

```java
Paciente paciente1 = new Paciente();
```

Nessa linha:

- `Paciente` é o tipo da variável;
- `paciente1` é a variável que guarda a referência;
- `new Paciente()` cria uma nova instância.

Depois, podemos preencher os atributos usando o operador ponto (`.`):

```java
paciente1.nome = "Ana";
paciente1.idade = 32;
paciente1.cpf = "123.456.789-00";
```

## 6. Classe e objeto não são a mesma coisa

Podemos criar muitos objetos a partir de uma única classe:

```java
Paciente paciente1 = new Paciente();
Paciente paciente2 = new Paciente();
Paciente paciente3 = new Paciente();
```

Há uma classe (`Paciente`) e três objetos (`paciente1`, `paciente2` e `paciente3`). Cada objeto existe separadamente e pode armazenar seus próprios valores.

```text
                 classe Paciente
                 /      |      \
                /       |       \
        paciente1  paciente2  paciente3
```

## 7. Estado de um objeto

O conjunto dos valores armazenados nos atributos de um objeto é chamado de **estado**.

```java
Paciente paciente1 = new Paciente();
paciente1.nome = "Ana";
paciente1.idade = 32;

Paciente paciente2 = new Paciente();
paciente2.nome = "Carlos";
paciente2.idade = 45;
```

Os dois objetos pertencem à mesma classe, mas têm estados diferentes.

O estado também pode mudar durante a execução:

```java
paciente1.idade = 33;
```

Nesse caso, o objeto continua sendo o mesmo; o valor do atributo `idade` é que mudou.

## 8. A classe `Medico`

No projeto, um médico é representado por nome, CRM e especialidade:

```java
public class Medico {
    public String nome;
    public String crm;
    public String especialidade;
}
```

O programa instancia e preenche um médico assim:

```java
Medico medico1 = new Medico();
medico1.nome = "Dra. Mariana";
medico1.crm = "CRM-12345";
medico1.especialidade = "Cardiologia";
```

O CRM também é texto: nesta demonstração ele contém letras e hífen, além de servir como identificador.

## 9. A classe `Consulta` e a relação entre objetos

Uma consulta guarda referências a um paciente e a um médico, além da data:

```java
public class Consulta {
    public Paciente paciente;
    public Medico medico;
    public String data;
}
```

Assim, os atributos `paciente` e `medico` não guardam nomes em texto: guardam referências a objetos das classes correspondentes. O exemplo em `Principal.java` cria e associa esses objetos:

```java
Consulta consulta1 = new Consulta();
consulta1.paciente = paciente1;
consulta1.medico = medico1;
consulta1.data = "10/10/2026";
```

Nesta versão introdutória, `data` é uma `String` para manter o exemplo simples; não há validação de formato nem armazenamento em banco de dados.

## 10. Métodos que exibem os dados

As classes `Paciente` e `Medico` possuem o método `exibirDados()`. A classe `Consulta` possui `exibirResumo()`. Esses métodos usam `System.out.println()` para escrever no console.

Por exemplo:

```java
paciente1.exibirDados();
consulta1.exibirResumo();
```

O método `exibirResumo()` acessa o nome do paciente e do médico associados à consulta. Por isso, neste exemplo, esses objetos precisam ser atribuídos antes da chamada.

## 11. O que o programa demonstra

A classe `Principal` realiza, em sequência, as seguintes ações:

1. cria dois pacientes e preenche seus dados;
2. exibe os dados dos pacientes;
3. cria um médico e exibe seus dados;
4. cria uma consulta associando um paciente ao médico;
5. exibe o resumo da consulta.

A saída esperada no console é:

```text
=== PACIENTES ===
Nome: Ana
Idade: 32
CPF: 123.456.789-00

Nome: Carlos
Idade: 45
CPF: 987.654.321-00

=== MÉDICO ===
Nome: Dra. Mariana
CRM: CRM-12345
Especialidade: Cardiologia

=== CONSULTA ===
Consulta
Paciente: Ana
Médico: Dra. Mariana
Data: 10/10/2026
```

## 12. Antes de continuar

Tente responder sem consultar os exemplos:

1. O que uma classe define?
2. O que os atributos representam?
3. O que é um objeto?
4. No trecho abaixo, quantas classes estão sendo usadas e quantos objetos são criados?

   ```java
   Paciente paciente1 = new Paciente();
   Paciente paciente2 = new Paciente();
   Paciente paciente3 = new Paciente();
   ```

**Resposta:** uma classe (`Paciente`) e três objetos.

## 13. Desafio

A clínica precisa começar a representar medicamentos. Cada medicamento possui:

- nome;
- fabricante;
- princípio ativo;
- preço;
- informação indicando se necessita de receita médica.

Crie uma classe para representar um medicamento e:

1. escolha tipos adequados para os atributos;
2. crie dois objetos;
3. atribua valores diferentes a cada objeto;
4. exiba alguns valores usando `System.out.println()`;
5. tente prever a saída antes de executar o programa.

## 14. Próximos passos

Conforme o projeto evoluir, outros conceitos de POO poderão ser estudados, por exemplo:

```text
Encapsulamento
     ↓
Construtores
     ↓
Métodos
     ↓
Relacionamentos entre objetos
     ↓
Coleções
     ↓
Herança e polimorfismo
```

## Resumo

- **Classe:** define um tipo e os elementos que o compõem.
- **Atributo:** representa um dado mantido pelo objeto.
- **Objeto:** instância criada a partir de uma classe.
- **Estado:** valores atuais dos atributos de um objeto.

```text
CLASSE
  └── define a estrutura dos objetos
        └── OBJETOS
              └── possuem ATRIBUTOS
                    └── cujos valores formam o ESTADO
```

Continue praticando: crie objetos, altere seus atributos e observe o resultado. Ao analisar cada classe, pergunte: **o que ela representa?** **Quais dados possui?** **Quantos objetos foram criados?** **Qual é o estado de cada um?**
