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
 * @author Anil
 *
 */
@Entity
@Table(name = "SAMPLE")
@Getter
@Setter
public class Sample implements Serializable {

	private static final long serialVersionUID = 4480174467280231837L;

	@Id
	@Column(name = "ID")
	private String id;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sample [id=").append(id).append("]");
		return builder.toString();
	}
}