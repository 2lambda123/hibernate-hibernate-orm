/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.annotations.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

/**
 * @author Lukasz Antoniak
 */
@Entity
public class Box implements Serializable {
	@Id
	private int id;

	@OneToMany( mappedBy = "box" )
	@OrderBy( "sortField DESC, code" ) // Sorting by @Formula calculated field.
	private List<Item> items = new ArrayList<Item>();

	public Box() {
	}

	public Box(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) return true;
		if ( !( o instanceof Box ) ) return false;

		Box box = (Box) o;

		if ( id != box.id ) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Box(id = " + id + ")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
