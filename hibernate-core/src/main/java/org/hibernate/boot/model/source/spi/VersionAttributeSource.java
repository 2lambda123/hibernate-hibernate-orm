/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.boot.model.source.spi;

import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;

/**
 * @author Steve Ebersole
 */
public interface VersionAttributeSource
		extends SingularAttributeSource, RelationalValueSourceContainer, ImplicitBasicColumnNameSource {
	String getUnsavedValue();
	String getSource();
}
