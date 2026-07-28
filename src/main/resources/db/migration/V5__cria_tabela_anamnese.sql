create table tb_anamnese(
    id UUID primary key,
    id_paciente UUID not null references tb_paciente(id),
    alergias_paciente TEXT not null,
    historico_medico TEXT not null,
    medicamentos TEXT not null,
    detalhes TEXT not null,
    data_registro date
);