package bgth.app.service;

import java.util.List;
import java.util.Optional;

import bgth.app.model.entities.Producto;

public interface IProductoService {

	List<Producto> mostrarRegistros();
	Optional<Producto> buscarPorId(Long id);
	Producto guardar(Producto producto);
	Optional<Producto> actualizar(Producto producto, Long id);
	void eliminar(Long id);
}
