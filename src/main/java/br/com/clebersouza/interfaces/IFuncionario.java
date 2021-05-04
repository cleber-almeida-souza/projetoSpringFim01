package br.com.clebersouza.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.clebersouza.entities.Funcionario;

public interface IFuncionario extends CrudRepository<Funcionario, Integer>{

	//JPQL Java persistence query lanquage
	@Query("select f from Funcionario f where f.IdFuncionario = :param1")
	Funcionario findByIdFuncionario(@Param("param1") Integer IdFuncionario);
	
	
	@Query("select f from Funcionario f where f.IdEmpresa = :param1")
	List<Funcionario> findAllFuncionarios(@Param("param1") Integer Idempresa);

}
