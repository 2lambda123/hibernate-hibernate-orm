/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies that the current persistent state of a detached entity instance
 * should be fetched from the database when the entity is reattached using
 * {@link org.hibernate.Session#update(Object)}.
 *
 * @deprecated Since {@link org.hibernate.Session#update(Object)} is deprecated
 *
 * @author Steve Ebersole
 */
@Target( TYPE )
@Retention( RUNTIME )
@Deprecated(since = "6.2")
public @interface SelectBeforeUpdate {
	/**
	 * @deprecated When {@code false}, this annotation has no effect.
	 */
	@Deprecated(since = "6.0")
	boolean value() default true;
}
