package bgth.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bgth.app.model.entities.Producto;
import bgth.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> mostrarRegistros() {
		return (List<Producto>)repository.findAll();
	}

}
