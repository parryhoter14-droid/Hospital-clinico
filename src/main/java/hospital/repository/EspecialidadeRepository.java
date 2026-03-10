package hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
    
}
