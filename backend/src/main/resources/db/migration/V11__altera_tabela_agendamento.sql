ALTER TABLE tb_agendamento DROP COLUMN id_tratamento;


ALTER TABLE tb_agendamento ALTER COLUMN status TYPE varchar(30);


ALTER TABLE tb_agendamento DROP CONSTRAINT tb_agendamento_status_check;

UPDATE tb_agendamento SET status = 'AGUARDANDO_CONFIRMACAO' WHERE status = 'AGUARDANDO CONFIRMACAO';

ALTER TABLE tb_agendamento ADD CONSTRAINT tb_agendamento_status_check
    CHECK (status IN ('AGUARDANDO_CONFIRMACAO', 'CONFIRMADO', 'CANCELADO'));