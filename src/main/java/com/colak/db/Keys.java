/*
 * This file is generated by jOOQ.
 */
package com.colak.db;


import com.colak.db.tables.Persons;
import com.colak.db.tables.records.PersonsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * userdb.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PersonsRecord> KEY_PERSONS_PRIMARY = Internal.createUniqueKey(Persons.PERSONS, DSL.name("KEY_persons_PRIMARY"), new TableField[] { Persons.PERSONS.PERSON_KEY }, true);
}