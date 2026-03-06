package clinico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clinico.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
