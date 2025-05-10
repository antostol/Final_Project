package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlineDealerTest {
    @Test
    public void testCompare_SameRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.automart.com", "30 days", 4.0);
        OnlineDealer d2 = new OnlineDealer("https://www.carhub.com", "15 days", 4.0);
        assertEquals(0, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_FirstLowerRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.quickcars.com", "15 days", 3.2);
        OnlineDealer d2 = new OnlineDealer("https://www.drivedirect.com", "30 days", 4.7);
        assertEquals(-1, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_FirstHigherRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.fastwheels.com", "Return OK", 4.9);
        OnlineDealer d2 = new OnlineDealer("https://www.autozone.com", "Strict Return", 3.5);
        assertEquals(1, d1.compare(d1, d2));
    }

    @Test
    public void testCompare_NonOnlineDealerInput() {
        OnlineDealer d1 = new OnlineDealer("https://www.motorworld.com", "Easy", 4.0);
        Dealership d2 = new Dealership("CityCars", 1234567890, null) {};
        assertEquals(0, d1.compare(d1, d2)); // should safely handle non-OnlineDealer
    }

    @Test
    public void testCompare_WrongTypes() {
        OnlineDealer d1 = new OnlineDealer();
        Dealership other = new InPersonDealer();
        assertDoesNotThrow(() -> d1.compare(d1, other));
    }

    @Test
    public void testGetRatingCategory_Great() {
        OnlineDealer d = new OnlineDealer("https://www.automart.com", "Policy", 4.5);
        assertEquals("Great", d.getRatingCategory());
    }

    @Test
    public void testGetRatingCategory_AverageExact3() {
        OnlineDealer d = new OnlineDealer("https://www.carhub.com", "Policy", 3.0);
        assertEquals("Average", d.getRatingCategory());
    }

    @Test
    public void testGetRatingCategory_AverageAbove3Below4() {
        OnlineDealer d = new OnlineDealer("https://www.drivedirect.com", "Policy", 3.7);
        assertEquals("Average", d.getRatingCategory());
    }

    @Test
    public void testGetRatingCategory_Terrible() {
        OnlineDealer d = new OnlineDealer("https://www.quickcars.com", "Policy", 2.9);
        assertEquals("Terrible", d.getRatingCategory());
    }
}