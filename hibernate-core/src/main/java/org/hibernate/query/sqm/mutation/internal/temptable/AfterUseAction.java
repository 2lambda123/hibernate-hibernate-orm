/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.query.sqm.mutation.internal.temptable;

/**
 * Actions to perform in regard to a temporary table after each use.
 *
 * @author Steve Ebersole
 */
public enum AfterUseAction {
	CLEAN,
	DROP,
	NONE
}
