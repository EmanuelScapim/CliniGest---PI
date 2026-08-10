CREATE OR REPLACE FUNCTION fn_atualiza_data_atualizacao()
RETURNS TRIGGER AS $$
BEGIN
    NEW.data_atualizacao = now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

ALTER TABLE tb_pessoa
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_pessoa_atualiza
    BEFORE UPDATE ON tb_pessoa
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_anamnese
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_anamnese_atualiza
    BEFORE UPDATE ON tb_anamnese
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_odontograma
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_odontograma_atualiza
    BEFORE UPDATE ON tb_odontograma
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_prontuario
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_prontuario_atualiza
    BEFORE UPDATE ON tb_prontuario
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_tratamento
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_tratamento_atualiza
    BEFORE UPDATE ON tb_tratamento
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_material
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_material_atualiza
    BEFORE UPDATE ON tb_material
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_agendamento
    ALTER COLUMN data_hora TYPE TIMESTAMPTZ USING data_hora::timestamptz;

ALTER TABLE tb_agendamento
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_agendamento_atualiza
    BEFORE UPDATE ON tb_agendamento
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_fatura
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_fatura_atualiza
    BEFORE UPDATE ON tb_fatura
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_consumo_material
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_consumo_material_atualiza
    BEFORE UPDATE ON tb_consumo_material
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();

ALTER TABLE tb_pagamento
    ADD COLUMN data_criacao     TIMESTAMPTZ NOT NULL DEFAULT now(),
    ADD COLUMN data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT now();

CREATE TRIGGER trg_tb_pagamento_atualiza
    BEFORE UPDATE ON tb_pagamento
    FOR EACH ROW
    EXECUTE FUNCTION fn_atualiza_data_atualizacao();