package de.schulung.bibliothek.administration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BibliothekTest {

    private Bibliothek bibliothek;
    private Member member = new Member("AB1","Hans", "Held", LocalDate.of(1990, 5, 23), "Hans@Held.de");

    @BeforeEach
    void setup() {
        bibliothek = new Bibliothek();
    }

    @Test
    void addMember(){
        assertTrue(bibliothek.addToMembers(member));
    }

    @Test
    void addDuplicateMember(){
        bibliothek.addToMembers(member);
        assertFalse(bibliothek.addToMembers(member));
    }

    @Test
    void testFindMemberById(){
        bibliothek.addToMembers(member);
        assertEquals(member, bibliothek.findMemberById("AB1"));
    }

}
