/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id$
package org.hibernate.orm.test.sql;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/**
 * @author Emmanuel Bernard
 * @author Vlad MIhalcea
 */
//tag::sql-composite-key-entity-associations_named-query-example[]
@Entity
public class Captain {

    @EmbeddedId
    private Identity id;

    //Getters and setters are omitted for brevity

//end::sql-composite-key-entity-associations_named-query-example[]

    public Identity getId() {
        return id;
    }

    public void setId(Identity id) {
        this.id = id;
    }
//tag::sql-composite-key-entity-associations_named-query-example[]
}
//end::sql-composite-key-entity-associations_named-query-example[]
