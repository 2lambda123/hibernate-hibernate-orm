/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id$
package org.hibernate.orm.test.annotations.onetoone;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


/**
 * @author Emmanuel Bernard
 */
@Entity
public class Computer {

	private ComputerPk id;
	private String cpu;
	private SerialNumber serial;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "serialbrand", referencedColumnName = "brand")
	@JoinColumn(name = "serialmodel", referencedColumnName = "model")
	public SerialNumber getSerial() {
		return serial;
	}

	public void setSerial(SerialNumber serial) {
		this.serial = serial;
	}

	public boolean equals(Object o) {
		if ( this == o ) return true;
		if ( !( o instanceof Computer ) ) return false;

		final Computer computer = (Computer) o;

		if ( !id.equals( computer.id ) ) return false;

		return true;
	}

	public int hashCode() {
		return id.hashCode();
	}

	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name = "brand", column = @Column(name = "computer_brand")),
	@AttributeOverride(name = "model", column = @Column(name = "computer_model"))
			})
	public ComputerPk getId() {
		return id;
	}

	public void setId(ComputerPk id) {
		this.id = id;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
}
