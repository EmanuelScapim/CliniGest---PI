create table tb_prontuario(
    id UUID primary key,
    data_registro timestamptz not null,
    id_odontograma UUID not null references tb_odontograma(id),
    id_anamnese UUID not null references tb_anamnese(id),
    id_paciente UUID not null references tb_paciente(id)
);