package bgth.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(producto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id){
		Optional<Producto> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			Producto productoDb = optional.orElseThrow();
			productoDb.setName(producto.getName());
			productoDb.setDescription(producto.getDescription());
			productoDb.setPrice(producto.getPrice());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(productoDb));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id){
		Optional<Producto> o = service.buscarPorId(id);
		if (o.isPresent()) {
			service.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
