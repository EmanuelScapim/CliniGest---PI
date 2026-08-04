create table tb_paciente(
    id UUID primary key,
    nome_paciente VARCHAR(100) NOT NULL,
    cpf_paciente VARCHAR(11) NOT NULL UNIQUE,
    telefone_paciente VARCHAR(11) NOT NULL,
    emaill_paciente VARCHAR(50) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL
);

