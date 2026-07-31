ALTER TABLE tb_fatura DROP CONSTRAINT tb_fatura_modo_pagamento_check;

UPDATE tb_fatura SET modo_pagamento = 'CARTAO_DE_CREDITO' WHERE modo_pagamento = 'CARTÃO DE CREDITO';

UPDATE tb_fatura SET modo_pagamento = 'CARTAO_DE_DEBITO' WHERE modo_pagamento = 'CARTAO DE DEBITO';

ALTER TABLE tb_fatura ADD CONSTRAINT tb_fatura_modo_pagamento_status_check
    CHECK (status IN ('CARTAO_DE_DEBITO', 'CARTAO_DE_CREDITO','PIX', 'BOLETO'));