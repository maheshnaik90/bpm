/**
 * 
 */
package com.lgc.ctps.sgec.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author H199653
 *
 */
@Entity
@Table(name = "TIPO_PERGUNTA")
@Getter
@Setter
public class QuestionType implements Serializable {

	private static final long serialVersionUID = -2720550620223995540L;

	@Id
	@Column(name = "TPG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "TPG_DESCRICAO", length = 4000)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionType")
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();

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
		QuestionType other = (QuestionType) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionType [");
		if (id != null) builder.append("id=").append(id).append(", ");
		if (description != null) builder.append("description=").append(description).append(", ");
		if (questions != null) builder.append("questions=").append(questions);
		builder.append("]");
		return builder.toString();
	}
}
