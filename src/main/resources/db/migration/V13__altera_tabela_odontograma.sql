ALTER TABLE  tb_odontograma
ALTER COLUMN data_criacao TYPE timestamptz
USING data_criacao :: timestamptz