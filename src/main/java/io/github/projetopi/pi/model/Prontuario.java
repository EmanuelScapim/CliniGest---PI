package io.github.projetopi.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "data_registro", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataRegistro;

    @OneToOne
    @JoinColumn(name = "id_odontograma", nullable = false)
    private Odontograma odontograma;

    @OneToOne
    @JoinColumn(name = "id_anamnese", nullable = false)
    private Anamnese anamnese;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
}
