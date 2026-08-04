create table tb_agendamento(
    id UUID primary key,
    id_paciente UUID not null references tb_paciente(id),
    id_dentista UUID not null references tb_dentista(id),
    id_tratamento UUID not null references tb_tratamento(id),
    data_hora timestamptz not null,
    Status varchar(20) not null check (status in('CONFIRMADO', 'CANCELADO', 'AGUARDANDO CONFIRMACAO')),
    Observacao TEXT
);