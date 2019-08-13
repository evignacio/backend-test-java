package br.fcamara.test.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fcamara.test.domain.ControladoraEventos;

public interface IControladoraEventosRepository extends JpaRepository<ControladoraEventos, Long> {

	@Query(value = "SELECT * FROM [dbo].[controladora_eventos] WHERE estabelecimento_id = :estabelecimentoId AND date_entrada = :date OR date_saida =:date", nativeQuery = true)
	List<ControladoraEventos> eventosInDate(Long estabelecimentoId, LocalDateTime date);
	
	@Query(value = "SELECT TOP 1 * FROM [dbo].[controladora_eventos] WHERE estabelecimento_id = :estabelecimentoId AND veiculo_id = :veiculoId ORDER BY id DESC", nativeQuery = true)
	ControladoraEventos findbyEstabelecimentoVeiculoId(Long estabelecimentoId, Long veiculoId); 
}
