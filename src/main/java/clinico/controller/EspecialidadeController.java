package clinico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinico.entity.Especialidade;
import clinico.exception.Response;
import clinico.repository.EspecialidadeRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping
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
    }

