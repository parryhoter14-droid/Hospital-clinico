package clinico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinico.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
