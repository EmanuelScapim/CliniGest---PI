drop table tb_paciente CASCADE;
drop table tb_dentista CASCADE;

create table tb_paciente(
    id_paciente UUID primary key references tb_pessoa(id_pessoa)
);

create table tb_dentista(
    id_dentista UUID primary key references tb_pessoa(id_pessoa),
    cro varchar(6) unique not null,
    especialidade varchar(20) not null
);