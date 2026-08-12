package io.github.projetopi.pi.controller;

import io.github.projetopi.pi.controller.dto.PacienteDTO;
import io.github.projetopi.pi.controller.dto.RespostaDeErroDTO;
import io.github.projetopi.pi.exeptions.RegistroDuplicadoException;
import io.github.projetopi.pi.model.Paciente;
import io.github.projetopi.pi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Object> cadastarPacienteController(@RequestBody PacienteDTO paciente) {

        try{
        Paciente pacienteEntidade = paciente.mapearPaciente();

        URI local = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pacienteEntidade.getId())
                .toUri();
        return ResponseEntity.created(local).build();
        } catch (RegistroDuplicadoException e) {
            var erroDTO = RespostaDeErroDTO.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable("id") String id){
        var idPaciente = UUID.fromString(id);
        Optional<Paciente> pacienteOptional = pacienteService.obterPorId(idPaciente);

        if(pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = new PacienteDTO(
                    paciente.getNomePessoa(),
                    paciente.getCpf(),
                    paciente.getTelefonePessoa(),
                    paciente.getEmailPessoa(),
                    paciente.getDataNascimento()
            );

            return ResponseEntity.ok(pacienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> buscarPorNomeOuEmailOuCpfController(@RequestParam(value = "nome",required = false) String nome,
                                                                                 @RequestParam(value = "email", required = false) String email,
                                                                                 @RequestParam(value = "cpf", required = false) String cpf){
        List<Paciente> pacienteBuscado = pacienteService.buscarPorNomeOuEmailOuCpfService(nome, email, cpf);
        List<PacienteDTO> pacienteDTO = pacienteBuscado.stream()
                                                        .map(paciente -> new PacienteDTO(paciente.getNomePessoa(),
                                                                paciente.getCpf(),
                                                                paciente.getEmailPessoa(),
                                                                paciente.getTelefonePessoa(),
                                                                paciente.getDataNascimento())).collect(Collectors.toList());
        return ResponseEntity.ok(pacienteDTO);
    }

    @DeleteMapping(params = "email")
    public void deletaPorEmailController(@RequestParam(required = false) String email){
        pacienteService.deletePorEmailService(email);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualiazPacienteController(@PathVariable("id") String id, @RequestBody PacienteDTO pacienteDTO){

        var idPaciente = UUID.fromString(id);
        Optional<Paciente> pacienteOptional = pacienteService.obterPorId(idPaciente);

        if(pacienteOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var paciente = pacienteOptional.get();
        paciente.setNomePessoa(pacienteDTO.nomePacienteDto());
        paciente.setCpf(pacienteDTO.cpfPacienteDto());
        paciente.setTelefonePessoa(pacienteDTO.telefonePacienteDto());
        paciente.setEmailPessoa(pacienteDTO.emailPacienteDto());
        paciente.setDataNascimento(pacienteDTO.dataNascimentoPacienteDto());

        pacienteService.atualizarPaciente(paciente);

        return ResponseEntity.noContent().build();
    }
}
