/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.testing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to identify a method as a callback to be executed whenever a {@link FailureExpected} is handled.
 *
 * @author Steve Ebersole
 * @deprecated No replacement with JUnit 5 at the moment.
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
@Deprecated(forRemoval = true)
public @interface OnExpectedFailure {
}
