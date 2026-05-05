📘 Documentação do Sistema – API
📌 Visão Geral

Este projeto é uma API REST desenvolvida com Spring Boot para gerenciamento de dados (provavelmente também CRUD), estruturada em camadas bem definidas.

O sistema permite:

Criar registros
Consultar dados
Atualizar informações
Remover registros

Seguindo boas práticas de APIs RESTful.

🏗️ Estrutura do Projeto
src/main/java/com/... (pacote base)

├── Application.java            # Classe principal
│
├── controller/                # Camada de entrada (HTTP)
├── model/                     # Entidades (dados)
├── repository/                # Acesso ao banco
├── service/ (se existir)      # Regras de negócio
│
└── resources/
    └── application.properties # Configurações

💡 Diferença importante do anterior:
Esse projeto já indica uma separação mais clara de responsabilidades (possivelmente com service), o que é mais próximo de um padrão profissional.

🚀 Como Executar
Pré-requisitos
Java 17+
Maven
Passos
cd <pasta-do-projeto>
mvn spring-boot:run

Ou:

./mvnw spring-boot:run

A aplicação sobe em:

http://localhost:8080
🧩 Estrutura em Camadas
📌 Controller

Responsável por expor os endpoints HTTP.

Exemplo de responsabilidade:

Receber requisições (GET, POST, PUT, DELETE)
Retornar respostas (JSON)
📌 Service (se presente)

Camada intermediária com regras de negócio.

Exemplo:

Validações
Processamento de dados
Integração entre controller e repository

💡 Esse é um ponto de evolução em relação ao projeto anterior.

📌 Repository

Interface que comunica com o banco usando Spring Data JPA.

Exemplo:

public interface EntidadeRepository extends JpaRepository<Entidade, Long> {
}
📌 Model (Entidades)

Define os objetos persistidos no banco.

Exemplo:

@Entity
public class Entidade {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
}
🌐 Endpoints da API

⚠️ Como os nomes específicos variam, o padrão segue:

🔍 Listar todos
GET /<recurso>
🔎 Buscar por ID
GET /<recurso>/{id}
➕ Criar
POST /<recurso>

Body:

{
  "nome": "Exemplo"
}
✏️ Atualizar
PUT /<recurso>/{id}
❌ Deletar
DELETE /<recurso>/{id}
⚙️ Configurações

Arquivo:

application.properties

Configurações comuns:

Porta:
server.port=8080
Banco de dados (exemplo H2 ou MySQL)
Hibernate (JPA)
