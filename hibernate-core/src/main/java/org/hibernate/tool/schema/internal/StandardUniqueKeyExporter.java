/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.tool.schema.internal;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.dialect.Dialect;
import org.hibernate.mapping.Constraint;
import org.hibernate.mapping.UniqueKey;
import org.hibernate.tool.schema.spi.Exporter;

/**
 * An {@link Exporter} for {@link UniqueKey unique constraints}. The type argument is
 * {@link Constraint}, rather than {@link UniqueKey}, allowing for {@link Dialect}s
 * which create unique constraints for unique indexes.
 * 
 * @author Brett Meyer
 */
public class StandardUniqueKeyExporter implements Exporter<Constraint> {
	private final Dialect dialect;

	public StandardUniqueKeyExporter(Dialect dialect) {
		this.dialect = dialect;
	}

	@Override
	public String[] getSqlCreateStrings(Constraint constraint, Metadata metadata,
			SqlStringGenerationContext context) {
		return new String[] {
				dialect.getUniqueDelegate().getAlterTableToAddUniqueKeyCommand(
						(UniqueKey) constraint,
						metadata,
						context
				)
		};
	}

	@Override
	public String[] getSqlDropStrings(Constraint constraint, Metadata metadata,
			SqlStringGenerationContext context) {
		return new String[] {
				dialect.getUniqueDelegate().getAlterTableToDropUniqueKeyCommand(
						(UniqueKey) constraint,
						metadata,
						context
				)
		};
	}
}
