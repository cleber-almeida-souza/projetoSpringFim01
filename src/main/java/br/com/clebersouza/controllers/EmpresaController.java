package br.com.clebersouza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.clebersouza.dtos.EmpresaCadastroDTO;
import br.com.clebersouza.entities.Empresa;
import br.com.clebersouza.repositories.EmpresaRepository;
import br.com.clebersouza.validations.EmpresaCadastroValidation;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String ENDPOINT = "/api/empresas";

	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody // metodo retorna informações
	public ResponseEntity<List<String>> cadastrarEmpresa(@RequestBody EmpresaCadastroDTO dto) {
		List<String> mensagens = new ArrayList<String>();
		try {
			// aplicando as validações (método estatico) ... é uma lista
			mensagens = EmpresaCadastroValidation.validate(dto);
			// verificando se houve erro de validação
			if (mensagens.size() == 0) {
				if (empresaRepository.findByrazaoSocial(dto.getRazaoSocial()) != null) {
					throw new Exception("A razão Social já esta cadastrada.");
				}
				Empresa empresa = new Empresa();
				empresa.setNomeFantasia(dto.getNomeFantasia());
				empresa.setRazaoSocial(dto.getRazaoSocial());
				empresa.setCnpj(dto.getCnpj());
				empresaRepository.save(empresa);
				mensagens.add("Empresa cadastrada com sucesso");
				return ResponseEntity.status(HttpStatus.CREATED).body(mensagens);
			} else { // se houver erros de validação
				// retornar status de errp de requisição invalida 400 (BAD REQUEST)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagens);
			}
		} catch (Exception e) {
			mensagens.add("Ocorreu um erro: " + e.getMessage());
			// return "Erro: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagens);
		}
	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<String>> atualizarEmpresa() {
		return null;
	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<String>> excluirEmpresa() {
		return null;
	}

	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<String>> consultarEmpresa() {
		return null;
	}

}
