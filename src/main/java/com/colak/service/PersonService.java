package com.colak.service;

import com.colak.db.tables.daos.PersonsDao;
import com.colak.db.tables.pojos.Persons;
import com.colak.db.tables.records.PersonsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonsDao personsDao;
    private final DSLContext dslContext;

    public void create(PersonsRecord personsRecord) {
        // Create POJO from record
        var personPojo = new Persons(
                personsRecord.getPersonKey(),
                personsRecord.getName());

        personsDao.insert(personPojo);
    }

    // Returns lit of POJOs
    public List<Persons> getAll() {
        return personsDao.findAll();
    }

    // Additionally, it is possible to create more complex queries,using DSLContext.
    public List<Persons> getAllByKey(long personKey) {
        return dslContext
                .select()
                .from(com.colak.db.tables.Persons.PERSONS)
                .where(DSL.field(com.colak.db.tables.Persons.PERSONS.PERSON_KEY).eq(personKey))
                .fetchInto(Persons.class);
    }
}
