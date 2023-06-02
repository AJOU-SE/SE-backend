package SEbackend.project.Review.Entity;


import SEbackend.project.Review.DTO.ReviewDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor()
@Table(name= "Review")
public class Review {
    @Id@GeneratedValue
    private Long reviewId;
    private Long menuId;
    private Integer rate;
    private String content;
    private String name;

    public Review(ReviewDto dto) {
        reviewId = dto.getReviewId();
        menuId = dto.getMenuId();
        rate = dto.getRate();
        content = dto.getContent();
        name = dto.getName();
    }

}