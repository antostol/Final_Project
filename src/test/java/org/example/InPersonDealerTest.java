package org.example;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class InPersonDealerTest {
    @Test
    public void testIsLocated_ExactMatch_Montreal() {
        InPersonDealer dealer = new InPersonDealer("9-5", "123 Rue Sainte-Catherine Ouest, Montréal, QC", 10);
        assertTrue(dealer.isLocated("123 Rue Sainte-Catherine Ouest, Montréal, QC"));
    }

    @Test
    public void testIsLocated_CaseInsensitive_Montreal() {
        InPersonDealer dealer = new InPersonDealer("10-6", "456 Boulevard Saint-Laurent, Montréal, QC", 8);
        assertTrue(dealer.isLocated("456 boulevard saint-laurent, montréal, qc"));
    }

    @Test
    public void testIsLocated_WrongLocation_Montreal() {
        InPersonDealer dealer = new InPersonDealer("8-4", "789 Avenue du Mont-Royal Est, Montréal, QC", 12);
        assertFalse(dealer.isLocated("111 Rue Sherbrooke Ouest, Montréal, QC"));
    }

    @Test
    public void testIsLocated_EmptyString_Montreal() {
        InPersonDealer dealer = new InPersonDealer("9-5", "", 6);
        assertTrue(dealer.isLocated(""));
    }

    @Test
    public void testIsOpen_DuringHours() {
        Clock fixedClock = Clock.fixed(Instant.parse("2023-05-01T14:00:00Z"), ZoneId.of("America/Toronto"));
        InPersonDealer dealer = new InPersonDealer("09:00-17:00", "1234 Boulevard St-Laurent, Montreal, QC", 10);
        assertTrue(dealer.isOpen(fixedClock));
    }

    @Test
    public void testIsOpen_BeforeHours() {
        Clock fixedClock = Clock.fixed(Instant.parse("2023-05-01T07:00:00Z"), ZoneId.of("America/Toronto"));
        InPersonDealer dealer = new InPersonDealer("09:00-17:00", "4567 Rue Sainte-Catherine, Montreal, QC", 10);
        assertFalse(dealer.isOpen(fixedClock));
    }

    @Test
    public void testIsOpen_AfterHours() {
        Clock fixedClock = Clock.fixed(Instant.parse("2023-05-01T18:00:00Z"), ZoneId.of("America/Toronto"));
        InPersonDealer dealer = new InPersonDealer("09:00-17:00", "7890 Avenue du Parc, Montreal, QC", 10);
        assertFalse(dealer.isOpen(fixedClock));
    }

    @Test
    public void testIsOpen_InvalidFormat() {
        Clock clock = Clock.systemUTC();
        InPersonDealer dealer = new InPersonDealer("Invalid", "3210 Rue Sherbrooke Ouest, Montreal, QC", 10);
        assertFalse(dealer.isOpen(clock));
    }

    @Test
    public void testCompare_SameEmployees() {
        InPersonDealer d1 = new InPersonDealer("9-5", "123 Rue Sainte-Catherine Ouest, Montréal, QC", 10);
        InPersonDealer d2 = new InPersonDealer("10-6", "456 Avenue du Parc, Montréal, QC", 10);
        assertEquals(0, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_FirstHasFewer() {
        InPersonDealer d1 = new InPersonDealer("9-5", "789 Boulevard Saint-Laurent, Montréal, QC", 8);
        InPersonDealer d2 = new InPersonDealer("10-6", "101 Rue Sherbrooke Est, Montréal, QC", 12);
        assertEquals(-1, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_FirstHasMore() {
        InPersonDealer d1 = new InPersonDealer("9-5", "350 Avenue Mont-Royal Est, Montréal, QC", 15);
        InPersonDealer d2 = new InPersonDealer("10-6", "202 Rue Saint-Denis, Montréal, QC", 10);
        assertEquals(1, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_NonInPersonDealer() {
        InPersonDealer d1 = new InPersonDealer("9-5", "1600 Rue Notre-Dame Ouest, Montréal, QC", 15);
        Dealership d2 = new Dealership("Generic", 111, null) {};
        assertEquals(0, d1.compare(d1, d2));
    }
}