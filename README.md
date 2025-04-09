# LevelUp Study 🚀
Um projeto Java para gerenciar estudos de forma eficiente.

![Java](https://img.shields.io/badge/Java-17-blue)
![IntelliJ](https://img.shields.io/badge/IntelliJ-IDEA-orange)


## 📑 Índice
- [Sobre](#sobre)
- [Instalação](#instalação)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#-funcionalidades)
- [Clonando o projeto](#-clonando-o-repositório)


## 📖 Sobre


O **LevelUp Study** é uma aplicação de organização de estudos com gamificação, desenvolvido em Java. Ele permite que os usuários gerenciem suas tarefas acadêmicas por meio de listas dinâmicas, lembretes personalizados e um sistema de recompensas, onde a conclusão de atividades concede pontos e níveis.

**O projeto ainda está em desenvolvimento!** <br>
Porém as primeiras funcionalidades de *LOGIN* e *CADASTRO DE TAREFAS* já estão funcionando

## 🤖 Funcionalidades


No momento o  projeto possúi um **Sistema de Cadastro** de usuários e **Login** na plataforma. O banco de
dados é gerenciado pelo MySQL com módulo JDBC que armazena as informações do Usuario fornecidas
na tela de Cadastrar, juntamente com as Tarefas.

##  Estrutura do Projeto:

### Classes Modelos
- **Pessoa:** Contém atributos básicos da Pessoa
- **Usuario:** É o Usuario do sistema que contém atributos próprios e herda da classe *Pessoa*
- **Tarefa:** É a classe modelo da Tarefa, que contém as informações como nome da tarefa, descrição...
### Classes Serviço
- **CadastrarUsuarioServices:** Fornece o serviço de cadastro do Usuário, pegando as informações fornecidas e registrando no banco de dados
- **CadastrarTarefasServices:** Fornece o serviço de cadastro do Tarefas, pegando as informações fornecidas e registrando no banco de dados

### Classes Menus (views)
- **Menu:** Classe abstrata para modelo de menu (Todas classes baixo a herdam).
- **MenuPrincipal:** Menu inicial que exibe opções de *Cadastrar*,  *Login* e *Saída*. 
- **MenuCadastro:** Responsável por criar o menu de Cadastro de Usuário, chamando o serviço *CadastrarUsuarioServices*.
- **MenuLogin:** Menu de login que valida se o Usuario e senha fornecidos estão presentes no banco de dados, se sim, retorna uma instancia do Usuario para o *MenuLogado*.
- **MenuLogado**: É o menu que o usuario acessa ao fazer o Login, que contém  as funções de *Mostrar Perfil (Visualiza as informações do usuario logado)*, *Tarefas (Não implementado ainda)*, e *Logout*.
- **MenuTarefa**: Responsável por mostrar opções de gerenciamento das tarefas, como cadastrar tarefa, mostrar tarefas...

## 🛠 Tecnologias


- Java 17
- IntelliJ IDEA


## 💻 Instalação


### 🔹 Pré-requisitos
- Ter o [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalado
- Maven


### 🔹 Clonando o repositório
```sh
git clone https://github.com/seu-usuario/levelup-study.git
cd levelup-study
