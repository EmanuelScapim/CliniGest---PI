# Projeto: Clínica Odontológica — API REST

Este é um projeto para uma clínica odontológica. O objetivo é criar o restante das APIs, seguindo o mesmo padrão das APIs já existentes no projeto e seguindo o padrão RESTful.

## Padrão de referência

O padrão a ser seguido (nomenclatura, estrutura de pacotes, formato de resposta HTTP, uso de mappers, etc.) deve ser extraído diretamente do código-fonte já existente no projeto, e não descrito manualmente aqui. Antes de gerar qualquer CRUD novo, inspecionar pelo menos um CRUD completo já pronto (Controller + Service + Repository + DTO + Mapper) para replicar o padrão.

## Regras de negócio

- **Exclusão de Dentista/Paciente**: bloquear a exclusão caso a pessoa possua algum agendamento vinculado com status `AGUARDANDO_CONFIRMACAO` ou `CONFIRMADO`.
- **Exclusão de Tratamento**: bloquear a exclusão caso o tratamento já esteja vinculado a algum agendamento (via tabela associativa `tb_agendamento_tratamento`). Um tratamento sem nenhum agendamento vinculado pode ser excluído normalmente.
- **Exclusão de Material**: bloquear a exclusão caso já exista algum `ConsumoMaterial` registrado para o material (ou seja, o material já foi efetivamente utilizado em algum procedimento). O registro de `ConsumoMaterial` é feito manualmente pelo dentista após a realização do procedimento (não é gerado automaticamente), mas a regra de bloqueio de exclusão independe de como o registro foi criado.
- Os erros devem seguir os padrões dos erros já cadastrados no `GlobalExceptionHandler` existente.
- Caso seja necessário, configurar os demais erros no `GlobalExceptionHandler`, seguindo o mesmo padrão dos erros já existentes.
- Sempre reutilizar os mappers já cadastrados no projeto, aplicando o mesmo padrão usado nas entidades existentes (os mappers já estão configurados — não é necessário criar um novo mecanismo).
- As transferências de dados devem ocorrer através de DTOs, assim como já ocorre nas APIs existentes.
- Serão construídos apenas os CRUDs que estão faltando (controllers, services, repositories) para as entidades que já possuem modelo/entidade JPA pronta.
- **Entidade `Pagamento`**: criar a entidade JPA e o repositório correspondentes (a tabela `tb_pagamento` já existe no banco via migração Flyway), mas **não** construir a API (controller/service) dela nesta etapa.

## Restrições técnicas

- Não é permitido injetar novas dependências no `pom.xml`.
- Criar um arquivo `.env` e remover do hardcode as credenciais do banco de dados usadas pela aplicação.
- Toda query criada deve ser segura, prevenindo SQL Injection.
- Nesta etapa, o sistema não terá Spring Security implementado (fica para uma etapa futura). O foco agora é apenas construir as APIs CRUD padrão, seguindo o que já está pronto no projeto, com boas práticas básicas de segurança (validação de entrada, prevenção de SQL Injection).

## Processo

- Conversar antes de qualquer decisão importante.
- O trabalho será dividido em PRs.
- Os PRs devem conter no máximo 200 linhas.
- Sempre que finalizar uma tarefa, criar um commit seguindo o padrão dos commits já usados no projeto.
- Realizar testes antes de realizar o commit.
