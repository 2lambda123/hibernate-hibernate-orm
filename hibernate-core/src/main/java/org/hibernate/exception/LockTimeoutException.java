/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.exception;

import org.hibernate.JDBCException;

import java.sql.SQLException;

/**
 * A {@link JDBCException} indicating that a lock request
 * timed out on the database.
 *
 * @author Steve Ebersole
 */
public class LockTimeoutException extends LockAcquisitionException {
	public LockTimeoutException(String string, SQLException root) {
		super( string, root );
	}

	public LockTimeoutException(String string, SQLException root, String sql) {
		super( string, root, sql );
	}
}
