package io.github.projetopi.pi.controller;


import io.github.projetopi.pi.controller.dto.DentistaDTO;
import io.github.projetopi.pi.controller.mappers.DentistaMapper;
import io.github.projetopi.pi.model.Dentista;
import io.github.projetopi.pi.service.DentistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dentistas")
@RequiredArgsConstructor
public class DentistaController implements GenericController {

    private final DentistaService dentistaService;
    private final DentistaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> cadastraDentistaController(@RequestBody @Valid DentistaDTO dto){
        Dentista dentistaEntidade = mapper.toEntity(dto);
        dentistaService.cadastraDeentistaService(dentistaEntidade);
        URI location = gerarHeaderLocation(dentistaEntidade.getId());
        return  ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> pesquisarPorUsuário(@RequestParam(value = "nome", required = false) String nome,
                                                                 @RequestParam(value = "cpf", required = false) String cpf,
                                                                 @RequestParam(value = "cro", required = false) String cro,
                                                                 @RequestParam(value = "email", required = false) String email,
                                                                 @RequestParam(value = "especialidade", required = false) String especialidade){

        List<Dentista> dentistaBuscado = dentistaService.pesquisaByExample(nome, cpf, cro, email, especialidade);
        List<DentistaDTO> lista = dentistaBuscado.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping
    public void deletarDentista(@RequestParam(value = "nome", required = false) String nome,
                                @RequestParam(value = "cpf", required = false) String cpf,
                                @RequestParam(value = "cro", required = false) String cro,
                                @RequestParam(value = "email", required = false) String email){

        dentistaService.deletarDentistaPorCpfOuId(cpf, cro, email, nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDentista(@PathVariable("id") String id, @RequestBody @Valid DentistaDTO dentistaDTO){
        var idDentista = UUID.fromString(id);
        Optional<Dentista> dentistaOptional = dentistaService.encotrarPorId(idDentista);

        if(dentistaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var dentista = dentistaOptional.get();
        dentista.setNomePessoa(dentistaDTO.nomeDentistaDto());
        dentista.setCpf(dentistaDTO.cpfDentistaDto());
        dentista.setCro(dentistaDTO.croDentistaDto());
        dentista.setEmailPessoa(dentistaDTO.emailDentistaDto());
        dentista.setEspecialidade(dentistaDTO.especialidadeDentistaDto());

        dentistaService.atualizarDentista(dentista);

        return ResponseEntity.noContent().build();
    }
}
