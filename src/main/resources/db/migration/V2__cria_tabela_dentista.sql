create table tb_dentista(
    id UUID primary key,
    cro varchar(6) unique not null,
    especialidade varchar(20) not null,
    email_dentista varchar(50) not null unique,
    cpf_dentista varchar(11) not null unique,
    telefone_dentista varchar(11) not null
);