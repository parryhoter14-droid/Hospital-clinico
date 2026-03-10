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

import hospital.entity.Especialidade;
import hospital.exception.Response;
import hospital.repository.EspecialidadeRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
    
    @Autowired
    private EspecialidadeRepository repository;

    @PostMapping
    public Response cadastrarEspecialidade(@Valid @RequestBody Especialidade especialidade) {
        repository.save(especialidade);
        return new Response(201, "Especialidade cadastrada com sucesso!");
    }

    @GetMapping
    public List<Especialidade> returnTodos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response Atualizar(@PathVariable Long id, @RequestBody Especialidade entity){

        if (!repository.existsById(id)) {
        return new Response(404, "Especialidade não encontrada!");
        }
    
    Especialidade especialidadeAntiga = repository.findById(id).get();

    if (entity.getNome() != null) {
        especialidadeAntiga.setNome(entity.getNome());
    }

    if (entity.getDescricao() != null) {
        especialidadeAntiga.setDescricao(entity.getDescricao());
    }

    repository.save(especialidadeAntiga);

    return new Response(200, "Especialidade atualizada!");
}
@DeleteMapping("/{id}")
  public Response deleteEspecialidade(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Especialidade não encontrada");//Quando tentar deletar uma Especialidade que não existe
    }

    repository.deleteById(id);

    return new Response(204, "Especialidade deletada com sucesso");// A Especialidade foi deletada com sucesso mas recebe como se fosse um "erro"
  }
    }

