/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.mapping.joinformula;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ParentEntity {

    @Id
    private Long id;

    @OneToOne(targetEntity = ChildEntity.class, optional = false)
    @JoinColumnOrFormula(column = @JoinColumn(name = "ID", referencedColumnName = "PARENT_ID", insertable = false, updatable = false))
    @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "NAME", value = "'Tom'"))
    private ChildEntity tom;

    @OneToOne(targetEntity = ChildEntity.class, optional = false)
    @JoinColumnOrFormula(column = @JoinColumn(name = "ID", referencedColumnName = "PARENT_ID", insertable = false, updatable = false))
    @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "NAME", value = "'Ben'"))
    private ChildEntity ben;

}
