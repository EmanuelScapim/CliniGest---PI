ALTER TABLE tb_agendamento
    ADD CONSTRAINT tb_agendamento_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES tb_paciente(id_paciente);

ALTER TABLE tb_agendamento
    ADD CONSTRAINT tb_agendamento_id_dentista_fkey FOREIGN KEY (id_dentista) REFERENCES tb_dentista(id_dentista);
