package br.fcamara.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fcamara.test.domain.RegistroEventos;

public interface RegistroEventoRepository extends JpaRepository<RegistroEventos, Long> {
	
	@Query(value = "SELECT TOP 1 * FROM REGISTRO_EVENTOS WHERE estabelecimento_id = :estabelecimentoId AND veiculo_id = :veiculoId ORDER BY id DESC", nativeQuery = true)
	RegistroEventos findLastRegistroEventoVeiculo(long estabelecimentoId, Long veiculoId);

	List<RegistroEventos> findByEstabelecimentoId(long id);
}
