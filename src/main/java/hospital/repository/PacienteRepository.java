package hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
