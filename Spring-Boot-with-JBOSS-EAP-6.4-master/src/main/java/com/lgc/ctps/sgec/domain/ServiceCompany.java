package com.lgc.ctps.sgec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author H199653
 *
 */
@Entity
@Table(name = "SERVICO_EMPRESA")
@Getter
@Setter
public class ServiceCompany implements Serializable {

	private static final long serialVersionUID = 2644519152110348249L;

	@Id
	@Column(name = "SEV_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@OneToOne
	private Company company;

	@ManyToOne
	@JoinColumn(name = "TSV_ID")
	private ServiceTemplate serviceTemplate;

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
		ServiceCompany other = (ServiceCompany) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceCompany [");
		if (id != null) builder.append("id=").append(id).append(", ");
		if (company != null) builder.append("company=").append(company).append(", ");
		if (serviceTemplate != null) builder.append("serviceTemplate=").append(serviceTemplate);
		builder.append("]");
		return builder.toString();
	}
}
