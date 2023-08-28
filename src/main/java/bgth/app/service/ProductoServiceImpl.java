package bgth.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bgth.app.model.entities.Producto;
import bgth.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> mostrarRegistros() {
		return (List<Producto>)repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Producto guardar(Producto producto) {
		return repository.save(producto);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

}
