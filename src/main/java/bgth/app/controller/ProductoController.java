package bgth.app.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bgth.app.model.entities.Producto;
import bgth.app.service.IProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping("/productos")
	public List<Producto> listaDeProductos(){
		return service.mostrarRegistros();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(Long id){
		Optional<Producto> opProducto = service.buscarPorId(id);
		if (opProducto.isPresent()) {
			return ResponseEntity.ok(opProducto.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
}
