package clinico.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Receita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O médico é obrigatório")
    private Medico medico;

    @NotNull(message = "O paciente é obrigatório")
    private Paciente paciente;

    @NotNull(message = "A data de emissão é obrigatória")
    private LocalDate data_emissao;

    @NotBlank(message = "A descrição dos medicamentos é obrigatória")
    @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres")
    private String descric_medicamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(LocalDate data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getDescric_medicamento() {
        return descric_medicamento;
    }

    public void setDescric_medicamento(String descric_medicamento) {
        this.descric_medicamento = descric_medicamento;
    }

}

//id medico_id paciente_id data_emissao descricao_medicamentos