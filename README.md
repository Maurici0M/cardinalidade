<h1 align='center'>Desafio API REST</h1>

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" height="50px"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original-wordmark.svg" height="50px"/>
  <img src="https://em-content.zobj.net/source/microsoft-teams/363/saluting-face_1fae1.png" alt="Emoji de saudação" height="50px" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/typescript/typescript-original.svg" height="50px"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angularjs/angularjs-original.svg" height="50px"/>
</p>

<h3>Objetivos:</h3>

<details>
<summary>Back-end</summary>
<br>

<details>
<br>

<summary><b>Fazer um fork do projeto Cardinalidade, e utilizar os conhecimentos obtidos em Java para:</b></summary>

<p>Desenvolver métodos nos controllers que utilizem os verbos:</p>
    
    * GET       ==>     Deve retornar dados de leitura ao realizar as requisições; 
    * POST      ==>     Deve permitir a inclusão de dados na API;
    * PUT       ==>     Deve ser utilizado para fazer mudanças de múltiplos campos;
    * DELETE    ==>     Deve ser utilizado para excluir informações da API;
    * PATCH     ==>     Deve ser utilizado para realizar mudanças de campos específicos;

</details>
<br>

<details>
<summary><b>Utilizar das boas práticas de programação:</b></summary>
<br>
  
<p>Cada classe, deve ter a sua responsabilidade única, para tornar o projeto mais simples e de fácil manutenção. A estrutura atual contém:</p>

    -> Classes DTO para controlar e formatar os dados de saída da aplicação;
    -> Classes de Utilidade (Util) onde atualmente temos métodos de formatação de texto e campos de data; 
    -> Classes de Validação (Validation) onde ficará toda a lógica de validação das informações recebidas;

</details>
<br>

<details>
<summary><b>"Testar antes de ir para o ar":</b></summary>
<br>

<p>Existem muitas possibilidades de testes para a aplicação, que vão desde verificar se os campos x, y ou z estão vazios ou nulos, até verificações em repositórios. É possível utilizar o Postman ou Insomnia para verificar os retornos, mas, isso seria muito demorado e custoso.</p>

<p>Para se ter ideia, somente para o desenvolvimento do método de cadastrar um comprador, mais de 20 cenários de testes foram necessários, e ainda outros cenários precisarão ser desenvolvidos, a medida que a aplicação vai se encorpando.</p>

<p>Por isso, é necessário a realização de testes unitários (inicialmente somente a nível de código), utilizando o JUnit e Mockito, e a regra da aplicação é realizar testes de todas as classes que contenham algum tipo de validação, como as classes <b>validation</b> e <b>service</b>, por exemplo, que terão contato com repositorys e regras de validação.</p>

<p>As classes mais críticas para testes, serão primeiramente as classes de serviço e de validação, mas, a medida em que a aplicação for sendo desenvolvida e ficando mais completa, outras possibilidades de testes serão avaliadas para tentar deixar o projeto menos propenso a falhas de desenvolvimento.</p>

    Para verificar os testes já existentes, basta acessar o seguinte diretório:

    -> src/test/java/com/pedidos

<details>
<summary><b>Entendendo a função de cada diretório do pacote de testes:</b></summary>
<br>

<details>
<summary><b>Factory:</b></summary>
<br>

<p>Aqui terá métodos com instâncias de classes, para facilitar na utilização de mocks durante os testes.</p>

<p>Por exemplo, em vez de fazermos isto sempre que tivermos que ter dados de um comprador cadastrado:</p>

    Comprador comprador = new Comprador(
    "nome", "sobrenome", LocalDate.of(1990, 11, 25)...
    );

<p>Basta utilizar os métodos das classes Factory, e lá já teremos as instâncias desenvolvidas e adaptadas para cada cenário de testes, tornando o código mais reutilizável e de fácil manutenção.</p>

</details>
<br>

<details>
<summary><b>Service:</b></summary>
<br>

<p>As classes de serviço ficarão responsáveis por conectar os dados recebidos dos controllers as classes de validação, e caso as validações apontem erros, deverá tratar os dados nos repository's.</p>

</details>
<br>

<details>
<summary><b>Util:</b></summary>
<br>

<p>Aqui ficarão classes úteis, atualmente ela disponibiliza métodos para padronização dos tipos de textos recebidos da API e disponibiliza métodos de formatação para campos de data.</p>

</details>
<br>

<details>
<summary><b>Validation:</b></summary>
<br>

<p>Aqui ficará localizado as regras de negócios. Geralmente as validações de dados recebidos da API passarão por essas classes. Nelas, temos uma estrutura preparada para validar cada método disponível nos controllers, e o seu objetivo é garantir que todos os dados necessários para a aplicação prosseguir com as requisições estão sendo recebidos da forma correta.</p>

</details>

</details>

</details>

</details>
<br>

<details>
<summary><b>Front-end (em breve)</b></summary>
<br>

<details>
<summary><b>Dar vida a aplicação!</b></summary>
<br>

<p>Através do framework Angular, o objetivo será conectar a API numa estrutura visual, onde seja possível utilizar de todos os métodos disponíveis nos controladores da aplicação back-end!</p>

<p>Algumas das ideias são:</p>

    -> Criar uma tela de HomePage que introduza o propósito da aplicação;
    -> Criar uma tela de formulário para cadastro do comprador;
    -> Criar uma seção para edição/atualização dos dados cadastrais;
    -> Deixar disponível uma seção para exclusão dos dados do comprador da aplicação;
    -> Criar uma listagem de compradores e utilizar dos recursos de paginação para organizar as informações recebidas;
    -> Tornar a aplicação personalizada, responsiva e que traga uma boa experiência aos acessantes;
    -> ...

</details>

</details>
<br>

<h1 align='center'>Informações técnicas</h1>

<p align='center'>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" style='height: 50px'/>

<img src="https://em-content.zobj.net/source/microsoft-teams/363/nerd-face_1f913.png" alt="Emoji nerd" style='height: 50px'>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/insomnia/insomnia-original.svg" style='height: 50px'/>

</p>
<br>

<details>
<summary><b>Como fazer requisições na API?</b></summary>
<br>

<p>É aconselhável que seja utilizado o <b>Postman</b> ou <b>Insomnia</b> para realizar as requisições, mas, sinta-se livre para utilizar das ferramentas que melhor preferir!</p>

<details>
<summary><b>Comprador Controller</b></summary>
<br>

<details>
<summary><b>Cadastrar</b></summary>
<br>

<p>Para cadastrar um comprador, precisamos fazer uma requisição do tipo POST e enviar os dados no formato JSON da seguinte forma: </p>

    POST -> http://localhost:8080/comprador
    
            {
                "nome" : "Heather",
                "sobrenome" : "Mason",
                "dataNascimento" : "1985-02-25",
                "cpf" : "12345678901",
                "endereco": {
                    "cep" : "01001-000",
                    "logradouro": "Praça da Sé",
                    "bairro": "Sé",
                    "numero": "4875",
                    "complemento": "CS 1",
                    "cidade": {
                        "nome": "São Paulo",
                        "estado": {
                            "nome": "São Paulo"
                        }
                    },
                    "uf": "sp"
                }
            }


</details>

</details>

</details>
<br>

<!--Comandos GIT-->
<details>
<summary><b>Comandos GIT</b></summary>
<br>

<details>
<summary>Enviar branch local para o repositório remoto</summary>
<br>

<p>
    Caso uma branch seja criada localmente, e não esteja disponível no repositório remoto, é possível enviá-la utilizando o seguinte comando:
</p>

    git push origin nome_branch_a_ser_enviada
</details>
<br>

<details>
<summary><b>Para verificar todas as branches remotas disponíveis, utilize o comando:</b></summary>
<br>

    git branch -r
</details>
<br>

<details>
<summary>
<b>
Para verificar todas as branches (locais e remotas), utilize o comando:
</b> 
</summary>
<br>

    git branch -a
</details>
<br>

<details>
<summary>
Para atualizar todas as branches do repositório local com as últimas alterações do repositório remoto, você pode usar o comando a seguir:
</summary>
<br>
        
    git fetch --all
</details>
<br>

<details>
<summary><b>Atualize as suas branches locais, uma por vez: Cada branch local precisa ser atualizada manualmente com o comando abaixo (enquanto você está dentro da branch local que deseja atualizar):
</b></summary>
<br>

    git pull origin nome-da-branch
</details>
<br>

</details>
<br>
