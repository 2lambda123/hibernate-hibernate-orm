/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.bytecode.enhance.internal.tracker;

import org.hibernate.bytecode.enhance.spi.CollectionTracker;

/**
 * small low memory class to keep track of the number of elements in a collection
 *
 * @author Ståle W. Pedersen
 */
public final class NoopCollectionTracker implements CollectionTracker {

	public static final CollectionTracker INSTANCE = new NoopCollectionTracker();

	@Override
	public void add(String name, int size) {
	}

	@Override
	public int getSize(String name) {
		return -1;
	}

}
