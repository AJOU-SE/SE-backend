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
    private Integer cafeteria;
    private String menu;
    private String hashtag;
    private Integer date;

    public Menu(MenuDto dto) {
        menuId = dto.getMenuId();
        cafeteria = dto.getCafeteria();
        menu = dto.getMenu();
        hashtag = dto.getHashtag();
        date = dto.getDate();
    }

}