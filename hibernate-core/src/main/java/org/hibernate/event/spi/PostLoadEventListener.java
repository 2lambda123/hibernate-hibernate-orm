/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.event.spi;

/**
 * Occurs after an entity instance is fully loaded.
 *
 * @author Kabir Khan
 */
public interface PostLoadEventListener {
	void onPostLoad(PostLoadEvent event);
}
