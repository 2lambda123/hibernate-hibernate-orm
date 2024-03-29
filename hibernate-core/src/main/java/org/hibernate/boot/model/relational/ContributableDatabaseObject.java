/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.boot.model.relational;

import org.hibernate.mapping.Contributable;

/**
 * Database objects (table, sequence, etc) which are associated with
 * a {@linkplain #getContributor() contributor} (ORM, Envers, etc) and
 * can be selectively exported per contributor
 */
public interface ContributableDatabaseObject extends Contributable, Exportable {
}
