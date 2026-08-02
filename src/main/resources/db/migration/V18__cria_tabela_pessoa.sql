create table tb_pessoa(
    id_pessoa UUID primary key,
    nome_pessoa VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone_pessoa VARCHAR(11) NOT NULL,
    email_pessoa VARCHAR(50) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL
);