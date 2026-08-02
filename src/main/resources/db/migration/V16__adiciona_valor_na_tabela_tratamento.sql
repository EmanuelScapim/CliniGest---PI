ALTER TABLE tb_tratamento ADD COLUMN valor numeric(10,2) not null;

ALTER TABLE tb_agendamento ADD COLUMN id_fatura UUID not null references tb_fatura(id);
