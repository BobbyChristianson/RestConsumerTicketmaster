package com.springstuff.TicketmasterAssessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketmasterAssessmentApplicationTest {

    @Test
    void canConnectToResource() {
        try{
            int size = TicketmasterAssessmentApplication.getArtists().getBody().length;
        }catch (Exception e){
            assertFalse(true);
        }
        assertTrue(true);
    }

    @Test
    void testArtistPojo() {
        int size = 0;
        try{
            size = TicketmasterAssessmentApplication.getArtists().getBody().length;
        }catch (Exception e){
        }
        assertNotEquals(size,0);
    }
}