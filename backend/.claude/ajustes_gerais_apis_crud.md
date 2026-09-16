# Projeto: Clínica Odontológica — Validators de Duplicata

Nas últimas APIs criadas, verificou-se que não houve a criação de um `Validator` para impedir a criação de duplicatas. Entre nos PRs já criados (por você)e adicionar mais um commit em cada um, incluindo essa regra de negócio.

## Regras de negócio

- Um dentista não pode ter dois atendimentos ao mesmo tempo.
- Um paciente não pode ter dois atendimentos ao mesmo tempo.
    - Considerar para o conflito apenas agendamentos com status `AGUARDANDO_CONFIRMACAO` ou `CONFIRMADO`. Agendamentos com status `CANCELADO` não bloqueiam a criação de um novo agendamento no mesmo horário.
    - Deve haver um intervalo mínimo de 10 minutos entre o fim de um agendamento e o início do próximo (para o mesmo dentista e para o mesmo paciente). Exemplo: se um agendamento vai das 14h às 15h, o próximo só pode ser criado a partir das 15h10.
- Um tratamento não pode ser cadastrado duas vezes.
    - A comparação de duplicidade deve ser feita pelo nome, ignorando diferenças de maiúsculas/minúsculas (case-insensitive).
- O mesmo material não pode ser cadastrado duas vezes.
    - A comparação de duplicidade deve ser feita pelo nome, ignorando diferenças de maiúsculas/minúsculas (case-insensitive), mesmo critério do tratamento.
## Processo

- Entrar nos PRs já criados (não abrir PRs novos) e adicionar um commit adicional em cada um contendo a regra de validação correspondente.
- Seguir o mesmo padrão de commit já utilizado no projeto.
- Realizar testes antes de realizar o commit.
- Conversar antes de qualquer decisão importante.
- As validações devem ser criadas na pasta /validator
- Crie um PessoaValidator e crie um validador de CPF e utilize-o no PacienteService e no DentistaService para validar o CPF dos mesmos como CPF válido. Não é necesário criar uma validação para números iguais pois o DTO já faz essa validação
- Realize testes e converse comigo antes de cada commit