package hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
