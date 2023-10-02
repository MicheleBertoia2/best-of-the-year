package org.java.lessons.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.lessons.entertainment.Movie;
import org.java.lessons.entertainment.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	
	public String test(Model model) {
		
		final String name = "Michele";
		model.addAttribute("name", name);
		
		return "home"; 
	}
	
	private List<Movie> getBestMovies()
	{
		List<Movie> moviesList = new ArrayList<Movie>();
		
		moviesList.add(new Movie(1, "The Snatch"));
		moviesList.add(new Movie(2, "Fausto & Furio"));
		moviesList.add(new Movie(3, "SuXbad"));
		moviesList.add(new Movie(4, "Un weekend da bamboccioni"));
		
		return moviesList;
	}
	
	private List<Song> getBestSongs()
	{
		List<Song> songsList = new ArrayList<Song>();
		
		songsList.add(new Song(1, "La Vaca"));
		songsList.add(new Song(2, "Lose yourself"));
		songsList.add(new Song(3, "chop suey"));
		songsList.add(new Song(4, " i luv it"));
			
		return songsList;
	}
	
	@GetMapping("/movies")
	public String movies(Model model)
	{
		String list = getBestMovies().stream().map(String::valueOf).collect(Collectors.joining(" - "));
		model.addAttribute("list", list);
		return "movies";
		
	}
	
	@GetMapping("/songs")
	public String songs(Model model)
	{
		String list = getBestSongs().stream().map(String::valueOf).collect(Collectors.joining(" - "));
		model.addAttribute("list", list);
		return "songs";
	}
	
	@GetMapping("/songs/{id}")
	public String songById(Model model, @PathVariable int id)
	{
		Song song = null;
		for(Song s : getBestSongs())
		{
			if(s.getId() == id)
				song = s;
		}
		
		model.addAttribute("titolo", song.getTitolo());
		model.addAttribute("id", song.getId());
		
		return "song-detail";
	}
	
	@GetMapping("/movies/{id}")
	public String movieById(Model model,@PathVariable int id)
	{
		Movie movie = null;
		for(Movie s : getBestMovies())
		{
			if(s.getId() == id)
				movie = s;
		}
		
		model.addAttribute("titolo", movie.getTitolo());
		model.addAttribute("id", movie.getId());
		
		return "movie-detail";
	}
}









