package com.solvertic.disfruta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "petbl_VAtributos")
public class VAtributos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vatributo_id;

	@NotEmpty(message = "{vatributos.vatributo_desc.requerido}")
	private String vatributo_desc;

	@NotNull(message = "{vatributos.default_fl.almenosuno}")
	@Enumerated(value = EnumType.ORDINAL)
	private ValoresDeAtributos default_fl;

	//@NotNull(message = "{vatributos.tatributo_id.almenosuno}")
	//private int tatributo_id;
	
	private int estado_fl = 1;
	
	
	/*
	 * La anotación @ManyToOne cuenta con los siguientes atributos:
	 * 
	 * Optional: indica si la relación es opcional, es decir, si el objeto puede ser
	 * null. Esta propiedad se utiliza optimizar las consultas. Si JPA sabe que una
	 * relación es opcional, entonces puede realizar un RIGHT JOIN o realizar la
	 * consulta por separado, mientras que, si no es opcional, puede realizar un
	 * INNER JOIN para realizar una solo consulta. Cascade: Esta propiedad le indica
	 * que operaciones en cascada puede realizar con la Entidad relacionada, los
	 * valores posibles son ALL , PERSIST , MERGE , REMOVE , REFRESH , DETACH y
	 * están definidos en la enumeración javax.persistence.CascadeType . Fetch: Esta
	 * propiedad se utiliza para determinar cómo debe ser cargada la entidad, los
	 * valores están definidos en la enumeración javax.persistence.FetchType y los
	 * valores posibles son: EAGER (ansioso): Indica que la relación debe de ser
	 * cargada al momento de cargar la entidad. LAZY (perezoso): Indica que la
	 * relación solo se cargará cuando la propiedad sea leída por primera vez.
	 * targetEntity: Esta propiedad recibe una clase (Class ) la cual corresponde a
	 * la clase de la relación. No suele ser utilizada, pues JPA puede inferir la
	 * clase por el tipo de la propiedad.
	 */
	@NotNull
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "tatributo_id", nullable = false)
	private TAtributos tatributos;

	


	

}
