package br.com.clebersouza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.clebersouza.dtos.cadastroFuncionarioDTO;
import br.com.clebersouza.dtos.consultaFuncionarioDTO;
import br.com.clebersouza.dtos.editarFuncionarioDTO;
import br.com.clebersouza.entities.Funcionario;
import br.com.clebersouza.repositories.FuncionarioRepository;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	private static final String ENDPOINT = "/api/funcionarios";

	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody

	public ResponseEntity<List<String>> cadastrarFuncionario(cadastroFuncionarioDTO dto) {

		List<String> mensagens = new ArrayList<String>();

		try {

			Funcionario funcionario = new Funcionario();

			funcionario.setNome(dto.getNome());
			funcionario.setCpf(dto.getCpf());
			funcionario.setDataAdmissao(dto.getDataAdmissao());
			funcionario.setSalario(dto.getSalario());

			funcionarioRepository.save(funcionario);
			mensagens.add("Empresa cadastrada com sucesso");

			return ResponseEntity.status(HttpStatus.OK).body(mensagens);

		} catch (Exception e) {
			mensagens.add("Ocorreu um erro:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagens);
		}

	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<String>> atualizarFuncionario(editarFuncionarioDTO dto) {

		List<String> mensagens = new ArrayList<String>();

		try {

			Funcionario funcionario = new Funcionario();

			funcionario.setIdFuncionario(dto.getIdFuncionario());
			funcionario.setNome(dto.getNome());
			funcionario.setCpf(dto.getCpf());
			funcionario.setDataAdmissao(dto.getDataAdmissao());
			funcionario.setSalario(dto.getSalario());

			funcionarioRepository.save(funcionario);
			mensagens.add("Empresa atualizada com sucesso");

			return ResponseEntity.status(HttpStatus.OK).body(mensagens);

		} catch (Exception e) {
			mensagens.add("Ocorreu um erro:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagens);
		}

	}

	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<String>> excluirFuncionario(@PathVariable("id") Integer id) {
		List<String> mensagens = new ArrayList<String>();

		try {
			Funcionario funcionario = funcionarioRepository.findById(id);
			funcionarioRepository.delete(funcionario);

			mensagens.add("Funcionario excluído com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).body(mensagens);

		} catch (Exception e) {

			mensagens.add("Ocorreu um erro:" + e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagens);
		}
	}

//	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<String>> consultarFuncionario(consultaFuncionarioDTO dto) {
		//todoo
//		return null;
//	}

}
