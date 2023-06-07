package SEbackend.project.Menu.DTO;

import SEbackend.project.Menu.Entity.Menu;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
public class MenuDto {
    private Long menuId;
    private String cafeteria;
    private String menu;
    private String hashtag;
    private Integer date;
    private Integer price;

    public MenuDto(Menu entity) {
        menuId = entity.getMenuId();
        cafeteria = entity.getCafeteria();
        menu = entity.getMenu();
        hashtag = entity.getHashtag();
        date = entity.getDate();
        price = entity.getPrice();
    }
}


