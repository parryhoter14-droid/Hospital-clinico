package hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
