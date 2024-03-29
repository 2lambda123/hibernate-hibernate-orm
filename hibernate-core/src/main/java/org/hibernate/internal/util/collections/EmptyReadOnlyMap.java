/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.internal.util.collections;

final class EmptyReadOnlyMap<K,V> implements ReadOnlyMap<K,V> {

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public void dispose() {
		//no-op
	}

}
