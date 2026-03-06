package clinico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinico.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
