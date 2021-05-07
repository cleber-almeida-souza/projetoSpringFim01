package br.com.clebersouza.repositories;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clebersouza.entities.Empresa;
import br.com.clebersouza.interfaces.IEmpresaRepository;

@Service
@Transactional
public class EmpresaRepository {

	@Autowired
	private IEmpresaRepository empresaRepository;

	public void save(Empresa empresa) throws Exception {
		empresaRepository.save(empresa);
	}
	
	// método para excluir uma conta
	public void delete(Empresa empresa) throws Exception {
		  empresaRepository.delete(empresa);	
		}
	
	public Empresa findByrazaoSocial(String razaoSocial) throws Exception {
		return empresaRepository.findByrazaoSocial(razaoSocial);
	}

}
