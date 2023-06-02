package SEbackend.project.Review.Controller;

import SEbackend.project.Review.DTO.ReviewDto;
import SEbackend.project.Review.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class WriteController {

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
    public ResponseEntity<List<ReviewDto>> reviewList(@PathVariable(name="menuId") Long menuId){
        log.info("in reviewList");
        List<ReviewDto> reviewDTOList = reviewService.getList(menuId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reviewDTOList);
    }
}
