# 📄 Gerenciador de Contatos — JDBC + DAO

![Java](https://img.shields.io/badge/Java-17+-red?logo=oracle&style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?logo=mysql&style=for-the-badge)
![JDBC](https://img.shields.io/badge/JDBC-API-green?style=for-the-badge)
![DAO Pattern](https://img.shields.io/badge/DAO-PATTERN-yellow?style=for-the-badge)

---

## 📌 Sobre o Projeto
Sistema simples de **CRUD de Contatos** desenvolvido em Java utilizando JDBC e o padrão **DAO (Data Access Object)**.

🎯 Objetivo: praticar acesso a banco de dados, organização de código e boas práticas de backend.

##🛠 Tecnologias
-Java 17+
-MySQL
-JDBC
-Padrão DAO

---

## ⚙️ Funcionalidades
- ➕ Inserir contato  
- ✏️ Atualizar contato  
- ❌ Excluir por ID  
- 🔎 Buscar por nome  
- 🔍 Buscar por ID  
- 📃 Listar todos  

---

## 🧱 Estrutura do Projeto
src/
├── db/
│ ├── DB.java
│ └── DbException.java
│
├── entities/
│ └── Contatos.java
│
├── model/dao/
│ ├── ContatosDao.java
│ └── ContatosDaoJDBC.java
│
└── application/
└── Program.java


---

## 🗄️ Banco de Dados

### Criar tabela
```sql
CREATE TABLE contatos (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Telefone VARCHAR(20),
    Email VARCHAR(120)
);

INSERT INTO contatos (Nome, Telefone, Email) VALUES
('Ana Silva', '1199999-1111', 'ana@email.com'),
('Bruno Santos', '1198888-2222', 'bruno@email.com'),
('Carla Oliveira', '1197777-3333', 'carla@email.com');


