package bgth.app.repository;

import org.springframework.data.repository.CrudRepository;
import bgth.app.model.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
