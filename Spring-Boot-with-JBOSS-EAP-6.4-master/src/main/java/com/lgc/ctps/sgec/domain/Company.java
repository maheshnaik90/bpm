package com.lgc.ctps.sgec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author H199653
 *
 */
@Entity
@Table(name = "EMPRESA")
@Getter
@Setter
public class Company implements Serializable {

	private static final long serialVersionUID = 4480174467280231837L;

	@Id
	@Column(name = "EMP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "EMP_NOME", length = 100)
	private String nome;

	@Column(name = "EMP_ATIVO")
	private Boolean ativo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Company [id=").append(id).append(", nome=").append(nome).append(", ativo=")
				.append(ativo).append("]");
		return builder.toString();
	}
}