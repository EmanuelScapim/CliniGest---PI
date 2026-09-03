ALTER TABLE tb_fatura DROP CONSTRAINT tb_fatura_modo_pagamento_status_check;

ALTER TABLE tb_fatura ADD CONSTRAINT tb_fatura_modo_pagamento_check
    CHECK (modo_pagamento IN ('CARTAO_DE_DEBITO', 'CARTAO_DE_CREDITO', 'PIX', 'BOLETO'));

ALTER TABLE tb_fatura ADD CONSTRAINT tb_fatura_id_agendamento_key UNIQUE (id_agendamento);

ALTER TABLE tb_agendamento DROP COLUMN id_fatura;
