# Iniciando o caminho pelo Java
Implementação de Cadastro de Clientes em Java com Persistência em Arquivos

- Campus: 202301037751 - POLO CENTRO - PORTO REAL - RJ
- Curso: Desenvolvimento Full Stack
- Disciplina: Nível 1: Iniciando o Caminho Pelo Java
- Turma: 9001
- Semestre letivo: 3º Semestre
- Nome do estudante: Leonardo Naves de Lima Araujo

Missão Prática | Nível 1 | Mundo 3

RPG0014 - Iniciando o caminho pelo Java
2º Procedimento | Criação do Cadastro em Modo Texto


# Objetivos da prática
1. Utilizar herança e polimorfismo na definição de entidades.
2. Utilizar persistência de objetos em arquivos binários.
3. Implementar uma interface cadastral em modo texto.
4. Utilizar o controle de exceções da plataforma Java.
5. No final do projeto, o aluno terá implementado um sistema cadastral em Java,
6. utilizando os recursos da programação orientada a objetos e a persistência em
7. arquivos binários

# Materiais necessários para a prática
JDK e IDE NetBeans.
Equipamentos: Computador com JDK e NetBeans instalados.

# Resultados da Execução
![Screenshot 2024-04-21 184840](https://github.com/Navesz/Iniciando-o-caminho-pelo-Java/assets/58537948/f2a0323a-aa27-4dcb-b168-6b2d57bfe7c7)

run:
Dados de Pessoa Fisica Armazenados.
Dados de Pessoa Fisica Recuperados.
Id: 1
Nome: Ana
CPF: 11111111111
Idade: 25
Id: 2
Nome: Carlos
CPF: 22222222222
Idade: 52
Dados de Pessoa Juridica Armazenados.
Dados de Pessoa Juridica Recuperados.
Id: 3
Nome: XPTO Sales
CNPJ: 33333333333333
Id: 4
Nome: XPTO Solutions
CNPJ: 44444444444444
BUILD SUCCESSFUL (total time: 0 seconds)

Análise e Conclusão

1. Elementos Estáticos e o Método Main:
Elementos estáticos, como campos estáticos (variáveis) e métodos estáticos, são associados à classe em que são declarados, ao invés de a uma instância específica de uma classe. Isso significa que eles podem ser acessados diretamente através do nome da classe. O método `main` é declarado como estático porque é o ponto de entrada do programa e deve ser acessível pelo ambiente de execução do Java sem a necessidade de instanciar a classe, o que facilita o início da execução do programa.

2. Para que Serve a Classe Scanner:
 A classe `Scanner` é uma ferramenta do Java utilizada para ler a entrada de dados primitivos como strings e números. Em um sistema de cadastro em modo texto, `Scanner` permite ler a entrada do usuário a partir do console. Isso é essencial para coletar informações como nomes, identificações e outros dados relevantes durante a interação com o usuário.

3. Como o Uso de Classes de Repositório Impactou na Organização do Código:
As classes de repositório centralizam a lógica para manipular coleções de objetos, como criar, buscar, atualizar e deletar entidades. Isso ajuda a desacoplar a lógica de negócios da lógica de apresentação e armazenamento de dados. No nosso caso, `PessoaFisicaRepo` e `PessoaJuridicaRepo` fornecem uma abstração sobre como os objetos `PessoaFisica` e `PessoaJuridica` são mantidos, facilitando mudanças futuras na forma de armazenamento (por exemplo, migrar de arquivos para banco de dados) sem impactar o restante do código.
