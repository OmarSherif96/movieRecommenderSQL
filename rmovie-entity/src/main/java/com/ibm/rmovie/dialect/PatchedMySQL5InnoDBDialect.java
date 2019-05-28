/*
 *
 *  *     Copyright    : Copyright notice - Licensed Materials - Property of IBM
 *  *     Restricted Materials of IBM. Reproduction, modification and
 *  *     redistribution are permitted under the terms of the associated license.
 *  *     © Copyright IBM Corporation [2018]. All Rights Reserved.
 *  *     U.S. Government Users Restricted Rights: Use, duplication or disclosure
 *  *     restricted by GSA ADP Schedule Contract with IBM Corp
 *  *
 *  *     Author: Hesham.AbdelRaouf.Elbadawi@IBM.com
 *
 */

package com.ibm.rmovie.dialect;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.internal.util.StringHelper;

import java.sql.Types;

public class PatchedMySQL5InnoDBDialect extends MySQL5InnoDBDialect {

    public PatchedMySQL5InnoDBDialect() {
        registerColumnType(Types.BOOLEAN, "bit");
    }

    // Avoid explicit creation of index, so MySQL will drop the implicit
    // created index on later explicit creation of another index that can be
    // used to enforce the foreign key constraint.
    @Override
    public String getAddForeignKeyConstraintString(String constraintName,
            String[] foreignKey, String referencedTable, String[] primaryKey,
            boolean referencesPrimaryKey) {
        String cols = StringHelper.join(", ", foreignKey);
        return new StringBuilder(30)
                .append(" add constraint ")
                .append(constraintName)
                .append(" foreign key (")
                .append(cols)
                .append(") references ")
                .append(referencedTable)
                .append(" (")
                .append( StringHelper.join(", ", primaryKey) )
                .append(')')
                .toString();
    }

}