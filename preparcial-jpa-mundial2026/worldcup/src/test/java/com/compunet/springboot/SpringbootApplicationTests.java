package com.compunet.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.compunet.springboot.controller.Partial2Controller;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    Partial2Controller c;

    @Test
    void q1() {
        assertEquals(8, c.partial2japQ1PlayersByClub("Real Madrid").size());
    }

    @Test
    void q2() {
        assertEquals(Set.of("Luis Diaz", "James Rodriguez"),
                Set.copyOf(c.partial2japQ2PlayersByCountryAndClub("Colombia", "Bayern Munich")));
    }

    @Test
    void q3() {
        assertEquals(List.of("COL vs COD", "COL vs POR"), c.partial2japQ3HomeMatchesByCurrentClub("Bayern Munich", "Colombia"));
    }

    @Test
    void q4() {
        assertEquals(8, c.partial2japQ4ClubsByMatch(70L, null).size());
    }

    @Test
    void q5() {
        assertEquals(List.of("Argentina", "Francia", "Noruega", "Bélgica", "Inglaterra", "Portugal"),
                c.partial2japQ5TopCountries().subList(0, 6));
    }

}
