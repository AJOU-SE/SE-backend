package SEbackend.project.Menu.DTO;

import SEbackend.project.Menu.Entity.Review;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
public class ReviewDto {
    private Long reviewId;
    private Long menuId;
    private Integer rate;
    private String content;
    public String name;

    public ReviewDto(Review entity) {
        reviewId = entity.getReviewId();
        menuId = entity.getMenuId();
        rate = entity.getRate();
        content = entity.getContent();
        name = entity.getName();
    }
}


