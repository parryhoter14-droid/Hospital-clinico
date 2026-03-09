package clinico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinico.entity.Receita;
import clinico.exception.Response;
import clinico.repository.ReceitaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class ReceitaController {
    
    @Autowired
    private ReceitaRepository repository;

    @PostMapping
    private Response cadastrarReceita(@Valid @RequestBody Receita receita){
        repository.save(receita);
        return new Response(201, "Receita cadastrada com sucesso");
    }

    @GetMapping
    private List<Receita> returnTodos(){
        return repository.findAll();
    }

    @PutMapping
    public Response Atualizar(@PathVariable Long id;@RequestBody Receita entity){

         if (!repository.existsById(id)) {
        return new Response(404, "Receita não encontrada!");
        }

    Receita receitaAntiga = repository.findById(id).get();

    if (entity.getPaciente() != null) {
        receitaAntiga.setPaciente(entity.getPaciente());
    }

    if (entity.getMedico() != null) {
        receitaAntiga.setMedico(entity.getMedico());
    }

    if (entity.getDescric_medicamento() != null) {
        receitaAntiga.setDescric_medicamento(entity.getDescric_medicamento());
    }

    if (entity.getData_emissao() != null) {
        receitaAntiga.setData_emissao(entity.getData_emissao());
    }

    repository.save(receitaAntiga);
    return new Response(200, "Receita atualizada com sucesso!")
    }
}
