package br.com.algaworks.algalog.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.algaworks.algalog.model.Cliente;
import br.com.algaworks.algalog.model.exception.NegocioException;
import br.com.algaworks.algalog.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalagoClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(()-> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUSo = clienteRepository.findByEmail(cliente.getEmail()).stream()
		.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if (emailEmUSo) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}


}
