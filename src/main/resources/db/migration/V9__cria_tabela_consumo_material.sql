create table tb_consumo_material(
    id UUID primary key,
    id_tratamento UUID not null references tb_tratamento(id),
    id_material UUID not null references tb_material(id),
    quantidade INTEGER not null
    );