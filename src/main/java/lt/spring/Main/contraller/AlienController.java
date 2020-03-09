package lt.spring.Main.contraller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lt.spring.Main.dao.AlienRepo;
import lt.spring.Main.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("/alien")
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	
	@DeleteMapping("/alien/{id}")
	public String deleteAlien(@PathVariable int id) {
		Alien a = repo.getOne(id);
		
		repo.delete(a);
		
		return "Deleted";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int id) {
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(id).orElse(new Alien());
		mv.addObject(alien);
		System.out.println(repo.findByTech("Php"));
		System.out.println(repo.findByIdGreaterThan(03));
		System.out.println(repo.findByTechSorted("Java"));
		return mv;
	}
	
	@RequestMapping("/aliens")
	public List<Alien> getAliens() {

		return repo.findAll();
	}
	
	@RequestMapping("/alien/{id}")
	public Optional<Alien> getAliens(@PathVariable("id") int id) {

		return repo.findById(id);
	}

}
