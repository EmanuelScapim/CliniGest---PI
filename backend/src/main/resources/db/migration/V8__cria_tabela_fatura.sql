create table tb_fatura(
    id UUID primary key,
    id_agendamento UUID not null references tb_agendamento(id),
    valor_total numeric(10,2) not null,
    data_emissao date not null,
    status varchar(20) not null check (status in ('APROVADO', 'PENDENTE', 'CANCELADO', 'PROCESSANDO')),
    modo_pagamento varchar(20) not null check (modo_pagamento in ('CARTÃO DE CREDITO', 'CARTAO DE DEBITO', 'PIX', 'BOLETO'))
 );