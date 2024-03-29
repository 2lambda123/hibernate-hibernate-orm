/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html.
 */
package org.hibernate.boot.jaxb.mapping;

import java.util.List;

/**
 * JAXB binding interface for natural-id definitions
 *
 * @author Steve Ebersole
 */
public interface NaturalId {
	/**
	 * The cache config associated with this natural-id
	 */
	JaxbCaching getCaching();

	List<JaxbBasic> getBasicAttributes();

	List<JaxbManyToOne> getManyToOneAttributes();
}
