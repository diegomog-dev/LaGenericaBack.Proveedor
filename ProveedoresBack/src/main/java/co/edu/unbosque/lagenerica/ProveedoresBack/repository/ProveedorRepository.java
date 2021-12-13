package co.edu.unbosque.lagenerica.ProveedoresBack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.unbosque.lagenerica.ProveedoresBack.model.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor, String>{
	List<Proveedor> findByNit(String nit);

	Optional<Proveedor> findByNit(int nit);

	void deleteByNit(int nit);
	
	
}