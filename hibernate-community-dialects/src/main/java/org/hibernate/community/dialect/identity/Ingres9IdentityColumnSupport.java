/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.community.dialect.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

/**
 * @author Andrea Boriero
 */
public class Ingres9IdentityColumnSupport extends IdentityColumnSupportImpl {

	public static final Ingres9IdentityColumnSupport INSTANCE = new Ingres9IdentityColumnSupport();

	@Override
	public String getIdentitySelectString(String table, String column, int type) {
		return "select last_identity()";
	}
}
