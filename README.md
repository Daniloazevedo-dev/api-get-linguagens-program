# Rodar api com o docker:
* Criar imagem: docker build . -t api-get-linguagens-program:latest
* Rodar em container: docker run  -p 8080:8080 -d --name api-get-linguagens-program  api-get-linguagens-program 

# Rodar com docker compose:
* docker compose up -d --build

# Criar Banco
* acessar mongo-express: http://localhost:8081/
* criar banco: linguagens-programacao
* criar collection: linguagens

# Swagger
* http://localhost:8082/api/swagger-ui/index.html#/
