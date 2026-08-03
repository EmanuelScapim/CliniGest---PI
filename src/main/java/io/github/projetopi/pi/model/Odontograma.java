package io.github.projetopi.pi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_odontograma")
@Getter
@Setter
public class Odontograma {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "img_odontograma", length = 25, nullable = false)
    private String imgOdontograma;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataCriacao;

    @OneToOne(mappedBy = "odontograma")
    private Prontuario prontuario;

    public Odontograma() {
    }

    public Odontograma(UUID id, Paciente paciente, String imgOdontograma, Instant dataCriacao, Prontuario prontuario) {
        this.id = id;
        this.paciente = paciente;
        this.imgOdontograma = imgOdontograma;
        this.dataCriacao = dataCriacao;
        this.prontuario = prontuario;
    }
}
