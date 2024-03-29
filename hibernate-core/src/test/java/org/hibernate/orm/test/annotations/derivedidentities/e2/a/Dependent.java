/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.annotations.derivedidentities.e2.a;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Emmanuel Bernard
 */
@Entity
@Table(name = "`Dependent`")
@IdClass(DependentId.class)
public class Dependent {
	@Id
	String name;
	
	@Id @ManyToOne
	@JoinColumn(name="FK1", referencedColumnName="firstName")
	@JoinColumn(name="FK2", referencedColumnName="lastName")
	Employee emp;
}
