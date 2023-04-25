package com.ll.simpleDb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class SimpleDbTest {
    private SimpleDb simpleDb;

    @BeforeAll
    public void beforeAll() {
        simpleDb = new SimpleDb("localhost", "root", "", "simpleDb__test");
        simpleDb.setDevMode(true);
    }

    @Test
    public void t1() {
    }
}
