Fora pedido para criar uma aplicação utilizando o eco sistema Spring Framework para desenvolver uma API que realiza requisição no link • https://storage.googleapis.com/juntossomosmais-code-challenge/inputbackend.json. 

1 - O Spring possui um container (Ioc container) que gerencia Beans (instâncias de classes) e ao executar a aplicação o Spring gerência um client que fora anotado com um @component e nessa hora é feito a requisição e armazenado em memória os dados.

2 - Utilizei o banco H2 para realizar persistência com o JPA e utilizei alguns dos recursos do Spring Data JPA para fazer filtragens de Regiões e Tipos de clientes, por exemplo.

3 - Configurei o CORS para cliente específico que irá consumir essa API.

Evidência realizando requisição para API e testando a paginação conforme proposto no requisito:
![2023-06-19 23-30-44](https://github.com/gabrielfilipy/defensoria-publica/assets/73559672/76f631cb-d65b-4679-b84e-c780a8a62afc)

URL de teste: localhost:8081/insumo/listar?classificacao=TRABALHOSO&regiao=CENTRO_OESTE&page=5
