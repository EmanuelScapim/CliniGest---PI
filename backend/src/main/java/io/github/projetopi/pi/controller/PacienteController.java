package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.PacienteDTO;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public void cadastarPacienteController(@RequestBody PacienteDTO paciente) {
        Paciente pacienteEntidade = paciente.mapearPaciente();
        pacienteService.cadastrarPacienteService(pacienteEntidade);

    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarTodosPacientes(){

        List<PacienteDTO> pacientesListados = pacienteService.listarTodosPacientes();

        return ResponseEntity.ok().body(pacientesListados);
    }


}
