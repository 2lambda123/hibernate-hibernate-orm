/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.jpa.internal;

import jakarta.persistence.PersistenceException;
import jakarta.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;

/**
 * @author Steve Ebersole
 */
public class ExceptionMapperLegacyJpaImpl implements ExceptionMapper {
	/**
	 * Singleton access
	 */
	public static final ExceptionMapperLegacyJpaImpl INSTANCE = new ExceptionMapperLegacyJpaImpl();

	@Override
	public RuntimeException mapStatusCheckFailure(String message, SystemException systemException, SessionImplementor session) {
		throw new PersistenceException( message, systemException );
	}

	@Override
	public RuntimeException mapManagedFlushFailure(String message, RuntimeException failure, SessionImplementor session) {
		if (failure instanceof HibernateException) {
			throw session.getExceptionConverter().convert( failure );
		}
		if (failure instanceof PersistenceException) {
			throw failure;
		}
		throw new PersistenceException( message, failure );
	}
}
