package io.github.projetopi.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_anamnese")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anamnese {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "alergias_paciente", nullable = false, columnDefinition = "TEXT")
    private String alergiasPaciente;

    @Column(name = "historico_medico", nullable = false, columnDefinition = "TEXT")
    private String historicoMedico;

    @Column(name = "medicamentos", nullable = false, columnDefinition = "TEXT")
    private String medicamentos;

    @Column(name = "detalhes", nullable = false, columnDefinition = "TEXT")
    private String detalhes;

    @CreationTimestamp
    @Column(name = "data_registro", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataRegistro;
}
