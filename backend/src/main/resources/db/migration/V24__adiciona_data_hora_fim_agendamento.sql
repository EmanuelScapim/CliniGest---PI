ALTER TABLE tb_agendamento ADD COLUMN data_hora_fim timestamptz;

UPDATE tb_agendamento SET data_hora_fim = data_hora + interval '1 hour' WHERE data_hora_fim IS NULL;

ALTER TABLE tb_agendamento ALTER COLUMN data_hora_fim SET NOT NULL;
