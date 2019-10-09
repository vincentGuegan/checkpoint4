import java.util.List;

import com.checkpoint4.wildcircus.entities.Artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArtistController{

    @Autowired
    ArtistRepository artistRepository;
    
    @GetMapping("/artists")
    public List<Artist> browse() {
        return artistRepository.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist read(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }
}