/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html.
 */
package org.hibernate.procedure;

import org.hibernate.HibernateException;

/**
 * Indicates Hibernate is unable to determine the type details for a parameter.
 *
 * @author Steve Ebersole
 */
public class ParameterTypeException extends HibernateException {
	public ParameterTypeException(String message) {
		super( message );
	}
}
