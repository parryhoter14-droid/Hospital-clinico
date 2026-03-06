package clinico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinico.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
    
}
