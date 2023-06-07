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

import java.net.URI;
import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class ReviewController {

    private final MenuService menuService;
    private final ReviewService reviewService;

/*
    @Autowired
    public WriteController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
*/

    @PostMapping("/{menuId}/write")
    public ResponseEntity<ReviewDto> postReview(@PathVariable(name="menuId") Long menuId, @RequestBody ReviewDto reviewDto){
        reviewDto.setMenuId(menuId);
        log.info(reviewDto.toString());
        reviewService.save(reviewDto);
        return ResponseEntity.created(URI.create("/" + menuId + "/review")).build();
    }

    @GetMapping("/{menuId}/review")
    public ResponseEntity<Map<String, Object>> reviewList(@PathVariable(name="menuId") Long menuId){
        log.info("in read all");
        MenuDto menuInfo = menuService.getMenuInfo(menuId);
        List<ReviewDto> reviewList = reviewService.getList(menuId);
        Map<String, Object> ret = new HashMap<>();
        ret.put("menu", menuInfo);
        ret.put("review", reviewList);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ret);
    }
}
