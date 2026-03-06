package clinico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinico.entity.Consulta;
import clinico.exception.Response;
import clinico.repository.ConsultaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    
    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public Response cadastrarConsulta(@Valid @RequestBody Consulta consulta){
        repository.save(consulta);
        return new Response(201, "Consulta cadastrada com sucesso!");
    }

    @GetMapping
    public List<Consulta> returnTodos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response Atualizar(@PathVariable Long id, @RequestBody Consulta entity){
         
        if (!repository.existsById(id)) {
        return new Response(404, "Consulta não encontrada");
    }

    Consulta consultaAntiga = repository.findById(id).get();

    if (entity.getMedico() != null) {
        consultaAntiga.setMedico(entity.getMedico());
    }

    if (entity.getPaciente() != null) {
        consultaAntiga.setPaciente(entity.getPaciente());
    }

    if (entity.getData_hora() != null) {
        consultaAntiga.setData_hora(entity.getData_hora());
    }

    if (entity.getDiagnostico() != null) {
        consultaAntiga.setDiagnostico(entity.getDiagnostico());
    }

    repository.save(consultaAntiga);

    return new Response(200, "Consulta atualizada!");
}
    }

