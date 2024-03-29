/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.dialect.identity;

/**
 * @author Marco Belladelli
 */
public class MariaDBIdentityColumnSupport extends MySQLIdentityColumnSupport {
	public static final MariaDBIdentityColumnSupport INSTANCE = new MariaDBIdentityColumnSupport();

	@Override
	public String appendIdentitySelectToInsert(String identityColumnName, String insertString) {
		return insertString + " returning " + identityColumnName;
	}
}
