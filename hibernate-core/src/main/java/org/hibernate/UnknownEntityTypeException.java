/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate;

/**
 * Indicates an attempt was made to refer to an unknown entity name or class.
 * <p>
 * @implNote This class extends {@link MappingException} for legacy reasons.
 * Longer term I think it makes more sense to have a different hierarchy for
 * runtime-"mapping" exceptions.
 *
 * @author Steve Ebersole
 */
public class UnknownEntityTypeException extends MappingException {
	public UnknownEntityTypeException(String message, Throwable cause) {
		super( message, cause );
	}

	public UnknownEntityTypeException(String message) {
		super( message );
	}
}
