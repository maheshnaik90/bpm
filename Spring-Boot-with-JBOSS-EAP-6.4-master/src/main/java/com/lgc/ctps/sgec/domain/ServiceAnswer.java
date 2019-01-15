/**
 * 
 */
package com.lgc.ctps.sgec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.lgc.ctps.sgec.domain.enumeration.AnswerType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author H199653
 *
 */
@Entity
@Table(name = "RESPOSTA_SERVICO")
@Getter
@Setter
public class ServiceAnswer implements Serializable {

	private static final long serialVersionUID = -2758615660067929064L;

	@Id
	@Column(name = "RSV_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@OneToOne
	private ServiceTemplate serviceTemplate;

	@OneToOne
	private QuestionServiceTemplate questionServiceTemplate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "RESE_RESPOSTA")
	private AnswerType answer;

	@Column(name = "RESE_DESCRIPTION", length = 4000)
	private String description;

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
		ServiceAnswer other = (ServiceAnswer) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceAnswer [");
		if (id != null) builder.append("id=").append(id).append(", ");
		if (serviceTemplate != null)
			builder.append("serviceTemplate=").append(serviceTemplate).append(", ");
		if (questionServiceTemplate != null)
			builder.append("questionServiceTemplate=").append(questionServiceTemplate).append(", ");
		if (answer != null) builder.append("answer=").append(answer).append(", ");
		if (description != null) builder.append("description=").append(description);
		builder.append("]");
		return builder.toString();
	}
}
