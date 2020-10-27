package com.solvertic.disfruta.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "petbl_TAtributos")
public class TAtributos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tatributo_id;

	@NotEmpty(message = "{tatributos.tatributo_desc.requerido}")
	private String tatributo_desc;

	@NotNull(message = "{tatributos.tatributo_fl.almenosuno}")
	@Enumerated(value = EnumType.ORDINAL)
	private TiposDeAtributos tatributo_fl;

	@NotNull(message = "{tatributos.persona_fl.almenosuno}")
	@Enumerated(value = EnumType.ORDINAL)
	private TiposDePersonas persona_fl;

	private int estado_fl = 1;

	public TAtributos(@NotEmpty(message = "{tatributos.tatributo_desc.requerido}") String tatributo_desc,
			@NotNull(message = "{tatributos.tatributo_fl.almenosuno}") TiposDeAtributos tatributo_fl,
			@NotNull(message = "{tatributos.persona_fl.almenosuno}") TiposDePersonas persona_fl, int estado_fl) {
		this.tatributo_desc = tatributo_desc;
		this.tatributo_fl = tatributo_fl;
		this.persona_fl = persona_fl;
		this.estado_fl = estado_fl;
	}

}
