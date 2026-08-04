create table tb_pagamento(
    id UUID primary key,
    id_fatura UUID not null references tb_fatura(id),
    data_pagamento date not null,
    valor numeric(10,2) not null,
    num_fatura varchar(40) not null,
    num_boleto varchar(48) not null,
    status varchar(20) not null check (status in('APROVADO', 'CANCELADO', 'PENDENTE', 'PROCESSANDO'))
);