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

# SonarQube
* http://localhost:9000/projects
* user: admin
* password: admin
* Alterar senha padrão ao logar pela primeira vez
* token: Acessar Sonarqube > My Account > Security > Generate Tokens > gerar token > copiar token > colar no arquivo pom.xml
* Testar cobertura: mvn clean verify  "-Dsonar.token=${TokenGerado}"
