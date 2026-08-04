create table tb_agendamento_tratamento(
    id_agendamento UUID not null references tb_agendamento(id),
    id_tratamento UUID not null references tb_tratamento(id),
    primary key (id_agendamento, id_tratamento)
);