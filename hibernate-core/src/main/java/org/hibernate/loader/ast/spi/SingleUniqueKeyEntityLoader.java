/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.loader.ast.spi;

import org.hibernate.LockOptions;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * Loader subtype for loading an entity by a single unique-key value.
 *
 * @author Steve Ebersole
 */
public interface SingleUniqueKeyEntityLoader<T> extends SingleEntityLoader<T> {
	/**
	 * Load by unique key value
	 */
	@Override
	T load(Object ukValue, LockOptions lockOptions, Boolean readOnly, SharedSessionContractImplementor session);

	/**
	 * Resolve the matching id
	 */
	Object resolveId(Object key, SharedSessionContractImplementor session);
}
