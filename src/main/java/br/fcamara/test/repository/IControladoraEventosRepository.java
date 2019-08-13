package br.fcamara.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fcamara.test.domain.ControladoraEventos;
import br.fcamara.test.domain.tdo.RegistroEvento;

public interface IControladoraEventosRepository extends JpaRepository<ControladoraEventos, Long> {

	//@Query("SELECT * FROM [dbo].[controladora_eventos] WHERE estabelecimentoId = :estabelecimentoId AND date = :date")
	//List<ControladoraEventos> eventosOnDate(Long estabelecimentoId, LocalDateTime date);
	
	@Query(value = "SELECT TOP 1 * FROM [dbo].[controladora_eventos] WHERE estabelecimento_id = :estabelecimentoId AND veiculo_id = :veiculoId ORDER BY id DESC", nativeQuery = true)
	ControladoraEventos findbyEstabelecimentoVeiculoId(Long estabelecimentoId, Long veiculoId); 
}
