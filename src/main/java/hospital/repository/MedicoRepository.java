package hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
