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
<br>

<details>
<summary><b>Cadastrar vários compradores (método para testes)</b></summary>
<br>

<p>Caso deseje testar a paginação da aplicação, ou mesmo, verificar o funcionamento dos métodos disponíveis, pense em utilizar a criação de compradores em massa.</p>

<p>Esse método aceita um array de compradores, o que permite fazer vários cadastros de uma só vez.</p>

    POST -> http://localhost:8080/test

<br>

<details>
<summary><b>JSON para criar cadastros</b></summary>

<p>Dez registros para realizar testes de povoamento dos dados na aplicação:</p>

    [
        {
        "nome": "Asuma",
        "sobrenome": "Sarutobi",
        "dataNascimento": "1980-05-10",
        "cpf": "12345678901",
        "endereco": {
        "cep": "01001-001",
        "logradouro": "Rua das Kunais",
        "bairro": "Konoha Centro",
        "numero": "101",
        "complemento": "Ap 1",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Boruto",
        "sobrenome": "Uzumaki",
        "dataNascimento": "2005-03-27",
        "cpf": "12345678902",
        "endereco": {
        "cep": "01001-002",
        "logradouro": "Avenida Chakra",
        "bairro": "Konoha Sul",
        "numero": "202",
        "complemento": "Casa 2",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Choji",
        "sobrenome": "Akimichi",
        "dataNascimento": "1992-06-11",
        "cpf": "12345678903",
        "endereco": {
        "cep": "01001-003",
        "logradouro": "Travessa Ichiraku",
        "bairro": "Bairro da Folha",
        "numero": "303",
        "complemento": "Fundos",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Deidara",
        "sobrenome": "Iwagakure",
        "dataNascimento": "1988-12-05",
        "cpf": "12345678904",
        "endereco": {
        "cep": "01001-004",
        "logradouro": "Alameda da Arte Explosiva",
        "bairro": "Vila da Pedra",
        "numero": "404",
        "complemento": "Ateliê",
        "cidade": {
        "nome": "Iwa",
        "estado": {
        "nome": "País da Terra"
        }
        },
        "uf": "pt"
        }
        },
        
        {
        "nome": "Gaara",
        "sobrenome": "Sabaku",
        "dataNascimento": "1993-01-19",
        "cpf": "12345678905",
        "endereco": {
        "cep": "01001-005",
        "logradouro": "Rua da Areia Vermelha",
        "bairro": "Vila Oculta da Areia",
        "numero": "505",
        "complemento": "Residência Kazekage",
        "cidade": {
        "nome": "Suna",
        "estado": {
        "nome": "País do Vento"
        }
        },
        "uf": "pv"
        }
        },
        
        {
        "nome": "Hinata",
        "sobrenome": "Hyuga",
        "dataNascimento": "1991-07-28",
        "cpf": "12345678906",
        "endereco": {
        "cep": "01001-006",
        "logradouro": "Avenida Byakugan",
        "bairro": "Vila Hyuga",
        "numero": "606",
        "complemento": "Térreo",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Ino",
        "sobrenome": "Yamanaka",
        "dataNascimento": "1993-09-03",
        "cpf": "12345678907",
        "endereco": {
        "cep": "01001-007",
        "logradouro": "Rua das Flores Mentais",
        "bairro": "Vila Flor",
        "numero": "707",
        "complemento": "Loja",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Jiraiya",
        "sobrenome": "Sannin",
        "dataNascimento": "1960-02-14",
        "cpf": "12345678908",
        "endereco": {
        "cep": "01001-008",
        "logradouro": "Travessa dos Sábios",
        "bairro": "Monte Myoboku",
        "numero": "808",
        "complemento": "Casa 8",
        "cidade": {
        "nome": "Monte Myoboku",
        "estado": {
        "nome": "Terras Sábias"
        }
        },
        "uf": "ts"
        }
        },
        
        {
        "nome": "Kakashi",
        "sobrenome": "Hatake",
        "dataNascimento": "1983-09-15",
        "cpf": "12345678909",
        "endereco": {
        "cep": "01001-009",
        "logradouro": "Rua do Sharingan",
        "bairro": "Colina Kakashi",
        "numero": "909",
        "complemento": "Sala de Leitura",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        },
        
        {
        "nome": "Lee",
        "sobrenome": "Rock",
        "dataNascimento": "1994-03-18",
        "cpf": "12345678910",
        "endereco": {
        "cep": "01001-010",
        "logradouro": "Alameda da Juventude",
        "bairro": "Vila da Força",
        "numero": "1010",
        "complemento": "Dojo",
        "cidade": {
        "nome": "Konoha",
        "estado": {
        "nome": "País do Fogo"
        }
        },
        "uf": "pf"
        }
        }
    ]


</details>

</details>
<br>

<details>
<summary><b>Listar todos os compradores</b></summary>
<br>

<p>Para obtermos a lista de todos os compradores cadastrados na aplicação, precisamos fazer uma requisição GET da seguinte forma:</p>

    GET -> http://localhost:8080/comprador

<p>Essa listagem trará dez registros por vez, por conta da configuração de paginação padrão aplicada no projeto, e a ordem de exibição será com base no nome, ou seja, primeiro os compradores com nome <b>A</b> depois os com nome <b>B</b> e assim por diante.</p>

<p>Porém, é possível personalizar o modo de exibição da lista de compradores da seguinte forma:</p>

    Infos sobre os parâmetros passados na URL de requisição:

    size -> É a quantidade de arquivos que desejamos trazer ao listar os compradores, por exemplo, 10 compradores por página (page = 10)
    page -> É o número da página que desejamos visualizar (lembrando que os registros começam de page = 0)
    sort -> É o parâmetro de ordenação que desejamos levar em conta, por exemplo, ordenar     
    
    Exemplos de requisições possíveis:

    Listar pela ordenação do parâmetro em forma decrescente Z-A ou Maior número ao Menor
    GET -> http://localhost:8080/comprador?sort=nome_parametro,desc 

    Listar pela ordenação do parâmetro em forma crescente (padrão) A-Z Menor número ao Maior
    GET -> http://localhost:8080/comprador?sort=nome_parametro

    Listar somente uma quantidade específica de dados por vez, por exmeplo, 3 registros por cada página
    GET -> http://localhost:8080/comprador?size=3
    
    Listar iniciando de uma página específica (o padrão trará 10 registros por página, caso tenhamos 20 cadastros somente seriam vistos na próxima página)
    GET -> http://localhost:8080/comprador?page=1

    Listar personalizando vários parâmetros (10 registros por página, iniciando da página "2" e organizando em ordem crescente (padrão) pelo parâmetro nome):
    GET -> http://localhost:8080/comprador?size=10&page=1&sort=nome

</details>
<br>

<details>
<summary><b>Listar comprador por CPF</b></summary>

<p>Diferente do método de listar todos os compradores, a listagem por CPF permitirá a visualização das informações únicas de um comprador em específico. Para utilizar desse método, basta fazer a seguinte requisição:</p>

    GET -> http://localhost:8080/comprador/listar/cpf
    
    No corpo da requisição, envie o seguinte JSON:

    {
        "cpf": "numero_do_cpf_com_11_digitos"
    }

</details>
<br>

<details>
<summary><b>Excluir cadastro do comprador por CPF</b></summary>

<p>Caso queira excluir os dados do comprador da aplicação, basta fazer a seguinte requisição:</p>

    DELETE -> http://localhost:8080/comprador
    
    No corpo da requisição, envie o seguinte JSON:

    {
        "cpf": "numero_do_cpf_com_11_digitos"
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
