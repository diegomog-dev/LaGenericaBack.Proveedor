package co.edu.unbosque.lagenerica.ProveedoresBack.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.lagenerica.ProveedoresBack.model.Proveedor;
import co.edu.unbosque.lagenerica.ProveedoresBack.repository.ProveedorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class ProveedorController {
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@PostMapping("/db_proveedores")
	public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor Proveedor) {
		try {
			Proveedor _prove = proveedorRepository.save(new Proveedor(Proveedor.getNit(), Proveedor.getdireccionProveedor(), Proveedor.getCiudad(), Proveedor.getnombreProveedor(), Proveedor.gettelefonoProveedor()));
			return new ResponseEntity<>(_prove, HttpStatus.CREATED);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping("/db_proveedores")
	  public ResponseEntity<List<Proveedor>> getAllProveedor(@RequestParam(required = false) String nit) {
		  try {
			    List<Proveedor> clients = new ArrayList<Proveedor>();

			    if (nit == null)
			      proveedorRepository.findAll().forEach(clients::add);
			    else
			      proveedorRepository.findByNit(nit).forEach(clients::add);

			    if (clients.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(clients, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	
	  @DeleteMapping("/db_proveedores")
	  public ResponseEntity<HttpStatus> deleteAllProveedor() {
		  try {
			    proveedorRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @DeleteMapping("/db_proveedores/{nit}")
	  public ResponseEntity<HttpStatus> deleteByNit(@PathVariable("nit") int nit) {
		  try {
			    proveedorRepository.deleteByNit(nit);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	  
	  @PutMapping("/db_proveedores/{nit}")
	  public ResponseEntity<Proveedor> updateProveedor(@PathVariable("nit") int nit, @RequestBody Proveedor Proveedor) {
		  Optional<Proveedor> ProveedorData = proveedorRepository.findByNit(nit);

		  if (ProveedorData.isPresent()) {
		    Proveedor _clients = ProveedorData.get();
		    _clients.setNit(nit);
		    _clients.setdireccionProveedor(Proveedor.getdireccionProveedor());
		    _clients.setCiudad(Proveedor.getCiudad());
		    _clients.setnombreProveedor(Proveedor.getnombreProveedor());
		    _clients.settelefonoProveedor(Proveedor.gettelefonoProveedor());
		    		    	       
		    return new ResponseEntity<>(proveedorRepository.save(_clients), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
	  
	  @GetMapping("/db_proveedores/{nit}")
	  public ResponseEntity<Proveedor> getProveedorByNit(@PathVariable("nit") int nit) {
		  Optional<Proveedor> ProveedorData = proveedorRepository.findByNit(nit);

		  if (ProveedorData.isPresent()) {
		    return new ResponseEntity<>(ProveedorData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }
}

