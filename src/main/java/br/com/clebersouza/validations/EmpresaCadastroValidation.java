package br.com.clebersouza.validations;

import java.util.ArrayList;
import java.util.List;

import br.com.clebersouza.dtos.EmpresaCadastroDTO;

// validação para os campos enviados no serviço POST
public class EmpresaCadastroValidation {

	public static List<String> validate(EmpresaCadastroDTO dto) {

		List<String> mensagens = new ArrayList<String>();

		if (dto.getNomeFantasia() == null || dto.getNomeFantasia().length() == 0) {
			mensagens.add("Favor informar o nome fantasia da empresa");
		} else if (dto.getNomeFantasia().trim().length() < 10 || dto.getNomeFantasia().trim().length() > 150) {
			mensagens.add("Favor informar um nome de fantasia entre 10 e 150 caracteres.");
		}

		if (dto.getRazaoSocial() == null || dto.getRazaoSocial().length() == 0) {
			mensagens.add("Favor informar a razao social da empresa");
		} else if (dto.getRazaoSocial().trim().length() < 10 || dto.getRazaoSocial().trim().length() > 150) {
			mensagens.add("Favor uma razao social entre 10 e 150 caracteres.");
		}

		if (dto.getCnpj() == null || dto.getCnpj().length() == 0) {
			mensagens.add("Favor informar o CNPJ para a empresa");
		} else if (dto.getCnpj().trim().length() < 13 || dto.getCnpj().trim().length() > 14) {
			mensagens.add("Favor informar um CNPJ entre 10 e 14 caracteres.");
		}
		
		return mensagens;
	}
}
