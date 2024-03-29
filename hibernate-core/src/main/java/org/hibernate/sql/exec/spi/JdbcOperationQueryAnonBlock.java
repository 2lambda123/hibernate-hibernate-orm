/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.exec.spi;

import org.hibernate.sql.results.jdbc.spi.JdbcValuesMappingProducer;

/**
 * An anonymous call block (sometimes called an anonymous procedure) to be executed
 * on the database.  The format of this various by database, but it is essentially an
 * unnamed procedure without OUT, INOUT or REF_CURSOR type parameters
 *
 * @author Steve Ebersole
 */
public interface JdbcOperationQueryAnonBlock extends JdbcOperationQuery {
	/**
	 * Retrieve the "result set mappings" for processing any ResultSets returned from
	 * the JDBC call.  We expose multiple because JPA allows for an application to
	 * define multiple such mappings which are (unclearly) intended to describe the mapping
	 * for each ResultSet (in order) returned from the call.
	 */
	JdbcValuesMappingProducer getJdbcValuesMappingProducer();
}
