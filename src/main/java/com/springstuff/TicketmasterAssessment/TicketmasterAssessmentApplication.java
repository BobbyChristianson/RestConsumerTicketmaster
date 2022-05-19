package com.springstuff.TicketmasterAssessment;

import com.springstuff.TicketmasterAssessment.model.Artist;
import com.springstuff.TicketmasterAssessment.model.Event;
import com.springstuff.TicketmasterAssessment.model.Venue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class TicketmasterAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketmasterAssessmentApplication.class, args);
	}

	@GetMapping("/artist")
	public String getUpcomingEvents(@RequestParam(value = "name", defaultValue = "") String name) {

		ResponseEntity<Artist[]> response ;
		try{
			response = getArtists();
		} catch(Exception e){
			System.out.println(e.getMessage());
			return e.getMessage();
		}

		if(response.getStatusCodeValue() != 200){
			return response.getStatusCode().getReasonPhrase();
		}

		Artist[] artistList = response.getBody();
		Artist artist;
		try{
			artist = Arrays.stream(artistList)
					.filter(artist1 -> artist1.getName().equalsIgnoreCase(name))
					.findFirst()
					.orElseThrow();
		} catch(NoSuchElementException e){
			return Arrays.stream(artistList).map(artist1 -> artist1.getName())
					.reduce("ARTISTS: \n",(partialString, element) -> partialString + element + "\n");
		} catch(Exception e){
			return String.format("Did not find %s!", name);
		}

		List<Event> eventList;
		try{
			eventList = getEvents(artist);
		} catch(Exception e){
			return e.getMessage();
		}

		Map<Integer, Venue> venueMap;
		try{
			venueMap = getVenueMap();
		} catch(Exception e){
			return e.getMessage();
		}

		String output = artist.toString() + "\n";
		for(Event event : eventList){
			output+=event.toString(venueMap);
		}
		return String.format(output);
	}

	public static ResponseEntity<Artist[]> getArtists() throws Exception {

		ResponseEntity<Artist[]> response = new RestTemplate().getForEntity(
				"https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/artists.json",
				Artist[].class);
		return response;
	}

	public static List<Event> getEvents(Artist artist) throws Exception {

		ResponseEntity<Event[]> response = new RestTemplate().getForEntity(
				"https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/events.json",
				Event[].class);

		if(response.getStatusCodeValue() != 200){
			throw new Exception("Couldn't load events for "
					+ artist.getName()
					+ " got response code "
					+ response.getStatusCode().getReasonPhrase());
		}

		return Arrays.stream(response.getBody())
				.filter(event -> Arrays.stream(event.getArtists())
						.anyMatch(artistID -> artistID.getId()==artist.getId()))
				.collect(Collectors.toList());
	}

	public static Map<Integer, Venue> getVenueMap() throws Exception {

		ResponseEntity<Venue[]> response = new RestTemplate().getForEntity(
				"https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681/venues.json",
				Venue[].class);

		if(response.getStatusCodeValue() != 200){
			throw new Exception("Couldn't load venues. "
					+ "Received response status of: "
					+ response.getStatusCode().getReasonPhrase());
		}

		return Arrays.stream(response.getBody())
				.collect(Collectors.toMap(Venue::getId, Function.identity()));


	}

}
