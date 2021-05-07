package br.com.clebersouza.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clebersouza.entities.Empresa;
import br.com.clebersouza.entities.Funcionario;
import br.com.clebersouza.interfaces.IFuncionarioRepository;

@Service
@Transactional
public class FuncionarioRepository {
 
	@Autowired
	private IFuncionarioRepository funcionarioRepository;
	
	public void save(Funcionario funcionario) throws Exception {
		funcionarioRepository.save(funcionario);
	}
	
	public void delete(Funcionario funcionario) throws Exception {
		funcionarioRepository.delete(funcionario);
	}
	
	public Funcionario findById(Integer id) throws Exception {
		return funcionarioRepository.findById(id).get(); 
	}

	public Funcionario findBycpf(String cpf) throws Exception {
		return funcionarioRepository.findBycpf(cpf); 
	}

//	public Funcionario findAll() throws Exception {
//		return funcionarioRepository.findAllFuncionarios(); 
//	}
//	public List<Funcionario> findAllFuncionarios(Integer idEmpresa) throws Exception {
//		return funcionarioRepository.findAll  .findAllFuncionarios(idEmpresa);
//	}
}
