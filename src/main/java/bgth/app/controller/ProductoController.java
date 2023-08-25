package bgth.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bgth.app.model.entities.Producto;
import bgth.app.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping("/productos")
	public List<Producto> listaDeProductos(){
		return service.mostrarRegistros();
	}
}
