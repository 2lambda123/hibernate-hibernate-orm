/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.jpa.internal.util;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

/**
 * @author Steve Ebersole
 */
public class PersistenceUnitTransactionTypeHelper {
	private PersistenceUnitTransactionTypeHelper() {
	}

	public static PersistenceUnitTransactionType interpretTransactionType(Object value) {
		if ( value == null ) {
			return null;
		}

		if ( value instanceof PersistenceUnitTransactionType ) {
			return (PersistenceUnitTransactionType) value;
		}

		final String stringValue = value.toString().trim();
		if ( stringValue.isEmpty() ) {
			return null;
		}
		else if ( stringValue.equalsIgnoreCase( "JTA" ) ) {
			return PersistenceUnitTransactionType.JTA;
		}
		else if ( stringValue.equalsIgnoreCase( "RESOURCE_LOCAL" ) ) {
			return PersistenceUnitTransactionType.RESOURCE_LOCAL;
		}
		else {
			throw new PersistenceException( "Unknown TransactionType: '" + stringValue + '\'' );
		}
	}
}
