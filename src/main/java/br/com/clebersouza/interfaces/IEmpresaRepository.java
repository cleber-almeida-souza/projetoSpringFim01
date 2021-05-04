package br.com.clebersouza.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.clebersouza.entities.Empresa;

public interface IEmpresaRepository extends CrudRepository<Empresa, Integer>{

	//JPQL Java persistence query lanquage
	@Query("select e from Empresa e where e.IdEmpresa = :param1")
	Empresa findByIdEmpresa(@Param("param1") Integer IdEmpresa);
	
	@Query("select e from Empresa e where e.razaoSocial = :param1")
	Empresa findByrazaoSocial(@Param("param1") String razaoSocial);
	
}
