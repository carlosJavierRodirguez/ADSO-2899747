package com.SENA.FlightManagementSystem.AircraftManagement.Entity;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircraft", schema = "aircraft_management")
@Schema(name = "aircraft_management", description = "Entidad que representa la gestión de aeronaves")
@Data
@lombok.EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Arcraft extends AAircraftManagementBaseEntity {
	@Column(name = "code", nullable = false, length = 20)
	private String code;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	// Agrega aquí relaciones si las hay (por ejemplo, ids de otras entidades)
}
