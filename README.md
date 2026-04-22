📌 Sobre o Projeto

Este projeto é um sistema simples de CRUD de Contatos utilizando:

Java (JDBC)
MySQL
Padrão DAO
Mapeamento manual entre ResultSet → Entidades

Foi criado com foco em aprendizado de backend Java e boas práticas de organização de código.

🧱 Estrutura do Projeto
src/
 ├── db/
 │    ├── DB.java
 │    ├── DbException.java
 │    └── DbIntegrityException.java
 │
 ├── entities/
 │    └── Contatos.java
 │
 ├── model/
 │    └── dao/
 │         ├── ContatosDao.java
 │         └── ContatosDaoJDBC.java
 │
 └── application/
      └── Program.java

⚙️ Funcionalidades
➕ Inserir contato
✏️ Atualizar contato
❌ Excluir contato por ID
🔎 Buscar por nome
🔍 Buscar por ID
📃 Listar todos
🗄️ Banco de Dados
Estrutura da tabela
CREATE TABLE contatos (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Telefone VARCHAR(20),
    Email VARCHAR(120)
);
Dados de exemplo
INSERT INTO contatos (Nome, Telefone, Email) VALUES
('Ana Silva', '1199999-1111', 'ana@email.com'),
('Bruno Santos', '1198888-2222', 'bruno@email.com'),
('Carla Oliveira', '1197777-3333', 'carla@email.com');
🛠 Tecnologias Utilizadas
Java 17+
MySQL 8
JDBC
Padrão DAO
Eclipse / IntelliJ
▶️ Exemplo de Uso
Inserindo:
Contatos c = new Contatos(null, "João Pedro", "1191234-5678", "joao@email.com");
dao.insert(c);
System.out.println("Novo ID gerado: " + c.getId());
Listando:
dao.findAll().forEach(System.out::println);
🧩 Padrão DAO

O projeto implementa DAO para separar responsabilidades:

ContatosDao → Interface
ContatosDaoJDBC → Implementação (JDBC)

Benefícios:

Código mais limpo
Facilidade para trocar a tecnologia (ex: migrar para Hibernate)
Testabilidade melhor
🚀 Como Executar
1️⃣ Criar banco no MySQL

Execute o script SQL mostrado acima.

2️⃣ Configurar db.properties
user=seu_usuario
password=sua_senha
dburl=jdbc:mysql://localhost:3306/nomedobanco
useSSL=false
3️⃣ Compilar e executar
javac *.java
java application.Program
🤝 Contribuições

Contribuições e sugestões são bem-vindas!
Sinta-se livre para abrir issues ou enviar PRs.

📜 Licença

Projeto livre para estudo e uso educacional.
      
