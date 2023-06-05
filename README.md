# GUFPB
# Perspectiva do produto

Com a aplicação GUFPB, o usuário poderá obter informações relevantes para a sua vida acadêmica e profissional, tais como: a grade do curso onde estará ingresso, onde e como possivelmente poderá atuar e também, em caso de remanejamento, conferir quais disciplinas podem ser reaproveitadas.

A aplicação possibilitará que o usuário responda a um questionário contendo perguntas sobre seus interesses e sua personalidade, para assim poder dar-lhe alguma opções de curso para seguir.


# Padrões de Projetos:

## Padrão Singleton
**Padrão Singleton**: Está presente nas classes `UserManagerFacade`, `QuestionarioManagerFacade` e `CursoManagerFacade`.

O objetivo da implementação do padrão Singleton nestas Classes é garantir que apenas uma instância da classe seja criada durante a execução do programa.

Através do padrão Singleton, cada classe assegura que somente uma instância dela mesma é criada e utilizada em toda a aplicação. Isso garante consistência e evita a criação desnecessária de múltiplas instâncias.
O padrão Singleton permite que outras partes da aplicação, acessem a instância de cada Classe que ele foi implemento por meio do método getInstance, garantindo que sempre interajam com a mesma instância. Isso simplifica o gerenciamento do objeto e promove melhor coordenação e consistência em toda a aplicação.


## Padrão Facade
**Padrão Facade**: Está presente nas classes `UserManagerFacade`, `QuestionarioManagerFacade` e `CursoManagerFacade`.

O objetivo do padrão Facade no projeto como um todo é simplificar e unificar a interação com os diferentes subsistemas do sistema. As classes `UserManagerFacade`, `QuestionarioManagerFacade` e `CursoManagerFacade` atuam como fachadas para seus respectivos subsistemas, fornecendo uma interface simplificada para realizar operações relacionadas a usuários, questionários e cursos. Isso facilita o uso do sistema, reduz o acoplamento entre os clientes e os subsistemas, e simplifica a manutenção e evolução do sistema. Em resumo, o padrão Facade torna a interação com os subsistemas mais simples e coesa.

## Padrão Factory
**Padrão Factory**:  Está presente na classe `UserManager`.

O objetivo do padrão Factory nesse projeto, na classe `UserManager`, é encapsular a lógica de criação de objetos do tipo `User`. 

Através do método `createUser`, que implementa o padrão Factory, a classe `UserManager` define uma interface para criar instâncias da classe `User` de forma padronizada. A lógica detalhada de criação do objeto é encapsulada dentro desse método, permitindo que os detalhes de criação fiquem centralizados em um único local.

Isso facilita a manutenção do código, pois qualquer alteração na lógica de criação do `User` precisa ser feita apenas no método `createUser`, evitando que outras partes do código sejam impactadas. Além disso, o uso do padrão Factory promove o baixo acoplamento entre a classe `UserManager` e a classe `User`, uma vez que a criação do objeto é delegada a um método separado.

## Padrão Template
**Padrão Template** Está presente nas classes `Curso`, `ArquiteUrban`, `fisica` e `Computacao`, e também deve estar em todos os cursos que serão adicionados futuramente.

O objetivo do padrão Template nesse projeto é fornecer uma estrutura comum para a definição e exibição de informações e grade curricular de diferentes cursos. A classe abstrata `Curso` define um template que as subclasses devem seguir, fornecendo métodos como `imprimirInformacoesCurso()` e `exibirGradeCurricular()`. Esses métodos são implementados de forma específica pelas subclasses de `Curso`, que podem ser adicionadas no futuro. Dessa forma, o padrão Template permite a reutilização de código e garante que a estrutura e o comportamento básico dos cursos sejam consistentes.

## Padrão Adapter
**Padrão Adapter** Está presente nas classes `QuestionAdapter`, `AnswerAdapter` , `Answer`  e `Question`.

O objetivo do padrão Adapter nesse projeto é permitir a comunicação entre classes que possuem interfaces incompatíveis. As classes `AnswerAdapter` e `QuestionAdapter` atuam como adaptadores, permitindo que as classes `Resposta` e `Pergunta` sejam utilizadas através das interfaces `Answer` e `Question`, respectivamente.

O `AnswerAdapter` adapta a classe `Resposta` para a interface `Answer`, fornecendo uma implementação compatível do método `getValor()`. Isso permite que objetos do tipo `Resposta` sejam tratados como objetos do tipo `Answer` em outros contextos, simplificando a interação com esses objetos.

O `QuestionAdapter` atua como um adaptador entre a classe `Pergunta` e a interface `Question`. Ele encapsula uma instância de `Pergunta` e fornece implementações dos métodos `getText()` e `getResposta()` que delegam as chamadas aos métodos correspondentes da `Pergunta`. Isso permite que objetos do tipo `Pergunta` sejam tratados como objetos do tipo `Question`, facilitando a sua utilização em outros componentes do sistema que esperam uma interface `Question`.

## Padrão Command
**Padrão Command** Está presente nas classes `Command`, `ExecutarQuestionarioCommand` , `CleanRespostaQuestionario`  e `CalcularCursoRecomendadoCommand`, são executados pela Classe QuestionarioManager.

O objetivo do padrão Command nesse projeto é encapsular solicitações como objetos, permitindo que os parâmetros dessas solicitações sejam parametrizados com métodos específicos. 

As classes `ExecutarQuestionarioCommand`, `CleanRespostaQuestionario` e `CalcularCursoRecomendadoCommand` implementam a interface `Command` e representam diferentes comandos que podem ser executados pelo `QuestionarioManager`.
O `QuestionarioManager` recebe um comando como entrada e invoca o método `execute()` do comando correspondente. Isso permite que o `QuestionarioManager` seja flexível e possa executar diferentes comandos sem conhecer os detalhes específicos de implementação desses comandos.

No caso específico da classe `CalcularCursoRecomendadoCommand`, o comando encapsula a chamada ao método `calcularCursoRecomendado()` do objeto `Questionario`. Ao executar esse comando, o `QuestionarioManager` irá realizar o cálculo do curso recomendado com base nas respostas do questionário.

Em resumo, o padrão Command permite que solicitações sejam encapsuladas como objetos, possibilitando a parametrização de ações específicas. Isso proporciona maior flexibilidade, reusabilidade e desacoplamento entre os componentes do sistema.

## Padrão Memento
**Padrão Memento** Está presente nas classes `LoginManager`, `LoginMemento` e `LoginMementoCareTaker`.
O objetivo do padrão Memento nesse projeto é permitir que o login seja restaurado após o usuário ter feito o logout.

A classe `LoginManager` é responsável por gerenciar o login de usuários. O padrão Memento é aplicado para salvar o estado do usuário logado antes de realizar o logout e, em seguida, restaurar esse estado quando necessário.
Quando o usuário faz o logout, o método `saveState()` é chamado para salvar o estado atual do `LoginManager` em um objeto `LoginMemento`. Esse memento é armazenado em um caretaker, a classe `LoginMementoCareTaker`.

Quando o usuário deseja fazer o login novamente, o método `restoreState()` é utilizado para restaurar o estado anterior a partir do memento mais recente armazenado. Isso permite que o usuário seja autenticado novamente sem precisar inserir suas credenciais novamente.

Dessa forma, o padrão Memento possibilita que o login seja restaurado após o logout, mantendo a sessão do usuário e evitando a necessidade de fornecer as credenciais novamente.

Resumindo, o padrão Memento é utilizado para salvar e restaurar o estado do `LoginManager`, permitindo que o login seja restaurado após o usuário ter feito o logout, evitando a necessidade de autenticação adicional.

## Padrão Observer
**Padrão Observer** Está presente nas classes `UserObserverImpl`,`UserManagerFacade` e interface `UserObserver`. o objeto `UserObserver` e Criado pela Classe Principal MainScreenDesktop.

O objetivo do padrão Observer nesse projeto é permitir que objetos observadores sejam notificados quando eventos relacionados a usuários ocorrerem.
A classe `UserManagerFacade` é responsável por gerenciar as operações de usuário, como registrar, remover e listar usuários. Essa classe implementa o padrão Observer, onde os objetos observadores implementam a interface `UserObserver`.

Quando um usuário é registrado com sucesso através do método `registerUser()`, o método `notifyUserRegistered()` é chamado para notificar todos os observadores registrados de que um novo usuário foi adicionado. O mesmo ocorre quando um usuário é removido através do método `removeUser()`, onde o método `notifyUserRemoved()` é chamado para notificar os observadores de que um usuário foi removido.

Os objetos observadores, implementados na classe `UserObserverImpl`, podem reagir a esses eventos realizando ações específicas, como exibir uma mensagem na tela ou atualizar uma interface gráfica.

Dessa forma, o padrão Observer permite que os objetos observadores sejam notificados automaticamente quando eventos importantes ocorrem no sistema de gerenciamento de usuários. Isso facilita a comunicação e a atualização de diferentes partes do sistema, garantindo que estejam sincronizadas com as alterações nos usuários.

Resumindo, o padrão Observer é usado para permitir a notificação de objetos observadores quando eventos relacionados a usuários, como registro e remoção, ocorrem no sistema de gerenciamento de usuários.

## Padrão Builder
**Padrão Builder** Está presente nas classes `User` e `BuilderUser` que uma classe interna de `User`.

O objetivo do padrão Builder nesse projeto é fornecer uma maneira flexível e fácil de construir objetos User, permitindo a criação de objetos complexos passo a passo.

A classe User possui atributos como login, senha, data_nascimento e Curso_Recomendado. Em vez de ter um construtor com muitos parâmetros, é utilizado o padrão Builder para construir objetos User de forma mais intuitiva e legível.

A classe interna BuilderUser é responsável por fornecer os métodos para configurar os atributos do objeto User um por um. Por exemplo, o método dataNascimento() permite definir a data de nascimento, e o método cursoRecomendado() permite definir o curso recomendado.

Após configurar os atributos desejados, o método build() é chamado para criar o objeto User com as configurações realizadas. Essa abordagem permite que a construção do objeto seja flexível e modular, evitando a necessidade de criar vários construtores com combinações diferentes de parâmetros.