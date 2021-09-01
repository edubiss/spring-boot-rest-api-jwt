
# Spring Boot Rest API JWT CRUD 

## Sobre o Projeto

Projeto desenvolvido para uma criação de uma API Rest utilizando Spring Boot utilizando de uma camada de segurança utilizando JWT.
Para a camada de dados é utilizado Hibernate e banco em memória (H2) para testes.
Na camada de segurança foi criado um serviço para gerar o Token JWT para fins de testes. Para uso em geral deve-se trocar para uma autenticação via usuário e senha cadastrados no banco de dados.

# Spring Boot JWT

![](https://img.shields.io/badge/build-success-brightgreen.svg)

# Stack

![](https://img.shields.io/badge/java_8-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/jwt-✓-blue.svg)

## Início

### Pré-requisitos

* `Java 8 ou superior`
* `Maven`
* `Postman ou outro API Client para chamadas HTTP`
* `$JAVA_HOME e $M2_HOME configurados`

### Instalação

1. Clonar o repositório
   ```sh
   git clone https://github.com/edubiss/spring-boot-rest-api-jwt.git
   ```
2. Navega para o diretório
   ```sh
   cd pring-boot-rest-api-jwt
   ```
3. Instale as dependências
   ```sh
   mvn install
   ```
4. Rodar o projeto
   ```sh
   mvn spring-boot:run
   ```
5. Verificar se o projeto está rodando
   ```sh
   http://localhost:8080/api/status
   ```

## Uso


### Rotas

Geração do Token JWT
```
$ curl -X GET http://localhost:8080/api/jwtGenerate 
```

Consulta de Candidatos
```
$ curl -X GET http://localhost:8080/api/candidatos -H 'Authorization: Bearer <JWT_TOKEN>'
```

Consulta de Candidato Específico
```
$ curl -X GET http://localhost:8080/api/candidato/{id} -H 'Authorization: Bearer <JWT_TOKEN>'
```

Inclusão de Candidatos
```
$ curl -X POST http://localhost:8080/api/candidato -H 'Authorization: Bearer <JWT_TOKEN>'
```
```javascript
{
  "nome": "João"
}
```

Atualização de Candidatos
```
$ curl -X PUT http://localhost:8080/api/candidato -H 'Authorization: Bearer <JWT_TOKEN>'
```
```javascript
{
  "id": "1",
  "nome": "João Update"
}
```

Remoção de Candidatos
```
$ curl -X DELETE http://localhost:8080/api/candidato/{id} -H 'Authorization: Bearer <JWT_TOKEN>'
```

Adicionar de Cartão Crédito
```
$ curl -X POST http://localhost:8080/api/candidato/{idCandidato}/adicionarCartao -H 'Authorization: Bearer <JWT_TOKEN>'
```
```javascript
{
    "numero": "12345",
    "validade": "10/22",
    "codigoSeguranca": 123
}
```

Atualização de Cartão Crédito
```
$ curl -X PUT http://localhost:8080/api/cartaoCredito -H 'Authorization: Bearer <JWT_TOKEN>'
```
```javascript
{
    "id": "2",
    "numero": "54321",
    "validade": "10/21",
    "codigoSeguranca": 321
}
```

Consulta de Cartões de Crédito
```
$ curl -X GET http://localhost:8080/api/candidatos/{idCandidato}/cartoes -H 'Authorization: Bearer <JWT_TOKEN>'
```

Consulta de Cartão de Crédito  Específico
```
$ curl -X GET http://localhost:8080/api/cartaoCredito/{id} -H 'Authorization: Bearer <JWT_TOKEN>'
```

Remoção de Cartão de Crédito
```
$ curl -X DELETE http://localhost:8080/api/cartaoCredito/{id} -H 'Authorization: Bearer <JWT_TOKEN>'
```
