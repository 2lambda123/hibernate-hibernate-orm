/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.jpa.procedure;


/**
 * @author Strong Liu
 */
public class AnnotationTest extends AbstractStoredProcedureTest {
	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] { User.class };
	}
}
