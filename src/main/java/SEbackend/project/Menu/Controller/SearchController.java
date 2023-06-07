package SEbackend.project.Menu.Controller;

import SEbackend.project.Menu.DTO.MenuDto;
import SEbackend.project.Menu.DTO.ReviewDto;
import SEbackend.project.Menu.Service.MenuService;
import SEbackend.project.Menu.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final MenuService menuService;
    private final ReviewService reviewService;

    @GetMapping("/search")
    public ResponseEntity<List<MenuDto>> search(@RequestParam String key){
        log.info("key="+key);
        List<MenuDto> menuDTOList = menuService.searchList(key);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(menuDTOList);
    }

    @GetMapping("/hashtag")
    public ResponseEntity<List<MenuDto>> hashtag(@RequestParam String tag){
        log.info("tag="+tag);
        List<MenuDto> menuDTOList = menuService.hashtagList(tag);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(menuDTOList);
    }
}
