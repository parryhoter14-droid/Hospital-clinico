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

import hospital.entity.Medico;
import hospital.exception.Response;
import hospital.repository.MedicoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public Response cadastrarMedico(@Valid @RequestBody Medico medico){
        repository.save(medico);
        return new Response(201, "Médico cadastrado com sucesso!");
    }

    @GetMapping
    public List<Medico> returnTodos(){
        return repository.findAll();
    }

    @PutMapping
    public Response Atualizar(@PathVariable Long id,@RequestBody Medico entity){
        
        if (!repository.existsById(id)) {
        return new Response(404, "Medico não encontrado!");
        }
    
    Medico medicoAntiga = repository.findById(id).get();

    if (entity.getNome() != null) {
        medicoAntiga.setNome(entity.getNome());
    }

    if (entity.getCrm() != null) {
        medicoAntiga.setCrm(entity.getCrm());
    }

    if (entity.getEspecialidade() != null) {
        medicoAntiga.setEspecialidade(entity.getEspecialidade());
    }

    repository.save(medicoAntiga);

    return new Response(200, "Medico atualizado!");    
    }
    @DeleteMapping("/{id}")
  public Response deleteMedico(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Medico não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Medico deletado com sucesso");
  }
}
