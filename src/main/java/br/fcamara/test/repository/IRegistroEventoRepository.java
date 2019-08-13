package br.fcamara.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fcamara.test.domain.RegistroEventos;

public interface IRegistroEventoRepository extends JpaRepository<RegistroEventos, Long> {
	
	@Query(value = "SELECT TOP 1 * FROM [dbo].[registro_eventos] WHERE estabelecimento_id = :estabelecimentoId AND veiculo_id = :veiculoId ORDER BY id DESC", nativeQuery = true)
	RegistroEventos findbyEstabelecimentoVeiculoId(Long estabelecimentoId, Long veiculoId); 
	
	
	List<RegistroEventos> findByEstabelecimentoId(Long id);
}
