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
    public ResponseEntity<List<PacienteDTO>> listarTodosPacientesController(){

        List<PacienteDTO> pacientesListados = pacienteService.listarTodosPacientesService();

        return ResponseEntity.ok().body(pacientesListados);
    }

    @GetMapping(params = "termo")
    public ResponseEntity<List<PacienteDTO>> buscarPorNomeOuEmailController(@RequestParam(required = false) String termo){
        List<PacienteDTO> pacienteBuscado = pacienteService.buscarPorNomeOuEmailService(termo);
        return ResponseEntity.ok(pacienteBuscado);
    }

    @DeleteMapping(params = "email")
    public void deletaPorEmailController(@RequestParam(required = false) String email){
        pacienteService.deletePorEmailService(email);
    }


}
