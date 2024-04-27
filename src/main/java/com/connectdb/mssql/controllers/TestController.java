package com.connectdb.mssql.controllers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connectdb.mssql.models.City;

@RestController
public class TestController {

	// private CityRepository cityRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@GetMapping("/get-city")
	public ResponseEntity<List<City>> getCity() {
		List<City> Citys = entityManager.createNamedStoredProcedureQuery("newGetCity").getResultList();
		return new ResponseEntity<>(Citys, HttpStatus.OK);
	}

	// @PostMapping("/city")
	// public ResponseEntity<String> createCity(@RequestBody City city) {
	// try {
	// StoredProcedureQuery query =
	// entityManager.createNamedStoredProcedureQuery("saveCity");
	// query.setParameter("id", city.getId());
	// query.setParameter("creation_timestamp", city.getCreation_timestamp());
	// query.setParameter("created_by_id", city.getCreated_by_id());
	// query.setParameter("state_id", city.getState_id());
	// query.setParameter("name", city.getName());
	// query.setParameter("deleted", city.isDeleted());
	// query.setParameter("deleted_timestamp", city.getDeleted_timestamp());
	// query.setParameter("deleted_by_id", city.getDeleted_by_id());
	// query.setParameter("status", city.getStatus());

	// // Register the output parameter
	// query.registerStoredProcedureParameter("message", String.class,
	// ParameterMode.OUT);

	// // Execute the stored procedure
	// query.getResultList();

	// // Get the output parameter value
	// String message = (String) query.getOutputParameterValue("message");

	// return new ResponseEntity<>(message, HttpStatus.CREATED);
	// } catch (PersistenceException e) {
	// // Handle JPA provider-specific exceptions
	// return new ResponseEntity<>(e.getMessage(),
	// HttpStatus.INTERNAL_SERVER_ERROR);
	// } catch (Exception e) {
	// // Handle other exceptions
	// return new ResponseEntity<>(e.getMessage(),
	// HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// }

	@PostMapping("/city")
	public ResponseEntity<String> createCity(@RequestBody City city) {
		try {
			StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("saveCity");
			// query.registerStoredProcedureParameter("id", Integer.class,
			// 		ParameterMode.IN);
			query.setParameter("id", city.getId());

			// query.registerStoredProcedureParameter("state_id", Integer.class,
			// 		ParameterMode.IN);
			query.setParameter("state_id", city.getState_id());

			// query.registerStoredProcedureParameter("name", String.class,
			// 		ParameterMode.IN);
			query.setParameter("name", city.getName());
			// query.GET

			// Register the output parameter
			// query.registerStoredProcedureParameter("message", String.class,
			// 		ParameterMode.OUT);

			// Execute the stored procedure
			query.execute();
			System.out.println(city);

			// Get the output parameter value
			String message = (String) query.getOutputParameterValue("message");

			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (PersistenceException e) {
			// Handle JPA provider-specific exceptions
			return new ResponseEntity<>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			// Handle other exceptions
			return new ResponseEntity<>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
