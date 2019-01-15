/**
 * 
 */
package com.lgc.ctps.sgec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author H199653
 *
 */
@Entity
@Table(name = "TEMPLATE_PERG_SERVICO")
@Getter
@Setter
public class QuestionServiceTemplate implements Serializable {

	private static final long serialVersionUID = -6824149355734831619L;

	@Id
	@Column(name = "TPS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@MapsId("id")
	@ManyToOne
	//	@JoinColumn(name = "PRG_ID")
	private Question question;

	@MapsId("id")
	@ManyToOne
	//	@JoinColumn(name = "TSV_ID")
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
		QuestionServiceTemplate other = (QuestionServiceTemplate) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionServiceTemplate [");
		if (id != null) builder.append("id=").append(id).append(", ");
		if (question != null) builder.append("question=").append(question).append(", ");
		if (serviceTemplate != null) builder.append("serviceTemplate=").append(serviceTemplate);
		builder.append("]");
		return builder.toString();
	}
}
