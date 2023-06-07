package SEbackend.project.Menu.Entity;


import SEbackend.project.Menu.DTO.MenuDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor()
@Table(name= "Menu")
public class Menu {
    @Id@GeneratedValue
    private Long menuId;
    private String cafeteria;
    private String menu;
    private String hashtag;
    private Integer date;
    private Integer price;

    public Menu(MenuDto dto) {
        menuId = dto.getMenuId();
        cafeteria = dto.getCafeteria();
        menu = dto.getMenu();
        hashtag = dto.getHashtag();
        date = dto.getDate();
        price = dto.getPrice();
    }

}