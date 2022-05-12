package com.springstuff.TicketmasterAssessment.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    String title;
    int id;
    String dateStatus;
    String timeZone;
    String startDate;
    ArtistID[] artists;
    VenueID venue;
    String hiddenFromSearch;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(String dateStatus) {
        this.dateStatus = dateStatus;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ArtistID[] getArtists() {
        return artists;
    }

    public void setArtists(ArtistID[] artists) {
        this.artists = artists;
    }

    public VenueID getVenue() {
        return venue;
    }

    public void setVenue(VenueID venue) {
        this.venue = venue;
    }

    public String getHiddenFromSearch() {
        return hiddenFromSearch;
    }

    public void setHiddenFromSearch(String hiddenFromSearch) {
        this.hiddenFromSearch = hiddenFromSearch;
    }

    @Override
    public String toString() {
        return "\"Event\": {\"" +
                "\n \"name\":\"" +title + "\"," +
                "\n \"venue\":{\"Could not fetch the venue or the venue has not been disclosed.\"}," +
                "\n \"dateStatus\":\"" + dateStatus + "\"," +
                "\n \"timeZone\":\"" + timeZone + "\"," +
                "\n \"startDate\":\"" + startDate +"\"\n}";
    }

    public String toString(Map<Integer,Venue> venueMap) {
        if(venue != null && venueMap.containsKey(venue.getId()))
            return "\"Event\": {\"" +
                    "\n \"name\":\"" +title + "\"," +
                    "\n \"venue\":{" + venueMap.get(venue.getId()).toString() + "}," +
                    "\n \"dateStatus\":\"" + dateStatus + "\"," +
                    "\n \"timeZone\":\"" + timeZone + "\"," +
                    "\n \"startDate\":\"" + startDate +"\"\n}";
        else
            return toString();
    }
}
