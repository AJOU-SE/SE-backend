package SEbackend.project.Menu.Service;

import SEbackend.project.Menu.DTO.ReviewDto;
import SEbackend.project.Menu.Entity.Review;
import SEbackend.project.Menu.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
/*
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
*/
    public void save(ReviewDto dto) {
        Review entity = new Review(dto);
        reviewRepository.save(entity);
    }

    public List<ReviewDto> getList(Long menuId) {
        List<Review> reviewList = reviewRepository.findByMenuId(menuId);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            reviewDtoList.add(new ReviewDto(review));
        }
        return reviewDtoList;
    }
}
