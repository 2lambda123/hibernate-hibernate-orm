/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.service.spi;

import org.hibernate.service.JavaServiceLoadable;

/**
 * @author Steve Ebersole
 */
@JavaServiceLoadable
public interface SessionFactoryServiceContributor {
	/**
	 * Contribute services to the indicated registry builder.
	 *
	 * @param serviceRegistryBuilder The builder to which services (or initiators) should be contributed.
	 */
	void contribute(SessionFactoryServiceRegistryBuilder serviceRegistryBuilder);
}
