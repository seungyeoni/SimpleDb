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
        simpleDb.run("""                                                
                CREATE TABLE article (
                    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                    PRIMARY KEY(id),
                    createdDate DATETIME NOT NULL,
                    modifiedDate DATETIME NOT NULL,
                    title VARCHAR(100) NOT NULL,
                    `body` TEXT NOT NULL,
                    isBlind BIT(1) NOT NULL DEFAULT 0
                )
                """);
    }
}
