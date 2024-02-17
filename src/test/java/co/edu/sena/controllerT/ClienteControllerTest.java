package co.edu.sena.controllerT;


import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


import co.edu.sena.controllers.ClienteController;
import co.edu.sena.models.entity.Cliente;
import co.edu.sena.models.service.ClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
	
	@InjectMocks
	private ClienteController clienteController;
	
	@Mock
	private ClienteService clienteService;
	
	@Test
	public void pruebaBuscarPorId() {
		
		Cliente clienteSimulado = new Cliente();
		clienteSimulado.setIdCliente(1);
		clienteSimulado.setNombre("Edilberto");
		clienteSimulado.setApellido("Ortiz");
		clienteSimulado.setIdentificacion(3657890);
		clienteSimulado.setEdad(60);
		clienteSimulado.setTelefono(2356478);
		clienteSimulado.setEmail("ortized@gmail.com");
		
		
		//Configurar el m�todo simulado de clienteService
		when(clienteService.findById(1)).thenReturn(Optional.of(clienteSimulado));
		
		//Llamar al m�todo del controlador que se desea probar
		Optional<Cliente> resultado = clienteController.buscarPorId(1);
		
		//Verifica que el resultado sea el esperado
		assertNotNull(resultado);
		assertTrue(resultado.isPresent());
		

	}

}
