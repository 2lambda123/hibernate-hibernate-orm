/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.mapping;


import java.util.Map;

/**
 * Common interface for things that can handle meta attributes.
 * 
 * @since 3.0.1
 */
public interface MetaAttributable {

	Map<String, MetaAttribute> getMetaAttributes();

	void setMetaAttributes(Map<String, MetaAttribute> metas);
		
	MetaAttribute getMetaAttribute(String name);

}
