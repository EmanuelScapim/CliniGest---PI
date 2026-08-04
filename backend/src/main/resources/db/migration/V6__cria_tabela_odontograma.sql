create table tb_odontograma(
    id UUID primary key,
    id_paciente UUID not null references tb_paciente(id),
    img_odontograma varchar(25) not null,
    data_criacao date
);