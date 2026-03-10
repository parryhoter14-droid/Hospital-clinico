package hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.entity.Paciente;
import hospital.exception.Response;
import hospital.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    private Response cadastrarPaciente(@Valid @RequestBody Paciente paciente){
        repository.save(paciente);
        return new Response(201, "Paciente cadastrado com sucesso!")
;    }

    @GetMapping
    private List<Paciente> returnTodos(){
        return repository.findAll();
    }

    @PutMapping
    public Response Atualizar(@PathVariable Long id,@RequestBody Paciente entity){

        if (!repository.existsById(id)) {
        return new Response(404, "Paciente não encontrado!");
        }

    Paciente pacienteAntigo = repository.findById(id).get();

    if (entity.getNome() != null) {
        pacienteAntigo.setNome(entity.getNome());
    }

    if (entity.getCpf() != null) {
        pacienteAntigo.setCpf(entity.getCpf());
    }

    if (entity.getData_nascimento() != null) {
        pacienteAntigo.setData_nascimento(entity.getData_nascimento());
    }
    
    repository.save(pacienteAntigo);
    return new Response(200, "Paciente atualizado!");
    }
    
    @DeleteMapping("/{id}")
  public Response deletePaciente(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Paciente não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Paciente deletado com sucesso");
  }
}
