package com.connectdb.mssql.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

import java.sql.Timestamp;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@NamedStoredProcedureQuery(name = "newGetCity", procedureName = "newGetCity", resultClasses = {
		City.class })

@NamedStoredProcedureQuery(name = "saveCity", procedureName = "saveCity",
parameters = {
@StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type =
Integer.class),
@StoredProcedureParameter(name = "state_id", mode = ParameterMode.IN, type =
Integer.class),
@StoredProcedureParameter(name = "name", mode = ParameterMode.IN, type =
String.class),
@StoredProcedureParameter(name = "message", mode = ParameterMode.OUT, type =
String.class)
})

// @NamedStoredProcedureQuery(name = "saveCity", procedureName = "saveCity", parameters = {
// 		@StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type = Integer.class),
// 		@StoredProcedureParameter(name = "creation_timestamp", mode = ParameterMode.IN, type = Timestamp.class),
// 		@StoredProcedureParameter(name = "created_by_id", mode = ParameterMode.IN, type = Integer.class),
// 		@StoredProcedureParameter(name = "state_id", mode = ParameterMode.IN, type = Integer.class),
// 		@StoredProcedureParameter(name = "name", mode = ParameterMode.IN, type = String.class),
// 		@StoredProcedureParameter(name = "deleted", mode = ParameterMode.IN, type = Boolean.class),
// 		@StoredProcedureParameter(name = "deleted_timestamp", mode = ParameterMode.IN, type = Timestamp.class),
// 		@StoredProcedureParameter(name = "deleted_by_id", mode = ParameterMode.IN, type = Integer.class),
// 		@StoredProcedureParameter(name = "status", mode = ParameterMode.IN, type = String.class),
// 		@StoredProcedureParameter(name = "message", mode = ParameterMode.OUT, type = String.class)
// })

public class City {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private int state_id;

	@Column
	private String name;

	@Column
	private Timestamp creation_timestamp;

	@Column
	private int created_by_id;

	@Column
	private boolean deleted;

	@Column
	private Timestamp deleted_timestamp;

	@Column
	private Integer deleted_by_id;

	@Column
	private Integer status;
}
