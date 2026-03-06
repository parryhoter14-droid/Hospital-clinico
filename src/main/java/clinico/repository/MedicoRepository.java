package clinico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinico.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
