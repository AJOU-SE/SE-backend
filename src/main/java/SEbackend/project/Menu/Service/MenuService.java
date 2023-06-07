package SEbackend.project.Menu.Service;

import SEbackend.project.Menu.DTO.MenuDto;
import SEbackend.project.Menu.Entity.Menu;
import SEbackend.project.Menu.Repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuDto getMenuInfo(Long menuId) {
        Menu menu = menuRepository.findByMenuId(menuId);
        return (new MenuDto(menu));
    }

    public List<MenuDto> getWeekList(Integer week) {
        List<Menu> menuList = menuRepository.findByDateOrDate(week, -1);
        List<MenuDto> menuDtoList = new ArrayList<>();
        for (Menu menu : menuList) {
            menuDtoList.add(new MenuDto(menu));
        }
        return menuDtoList;
    }

    public List<MenuDto> searchList(String key) {
        List<Menu> menuList = menuRepository.findByMenuContainingOrCafeteriaContainingOrHashtagContaining(key, key, key);
        List<MenuDto> menuDtoList = new ArrayList<>();
        for (Menu menu : menuList) {
            menuDtoList.add(new MenuDto(menu));
        }
        return menuDtoList;
    }

    public List<MenuDto> hashtagList(String tag) {
        List<Menu> menuList = menuRepository.findByHashtagContaining(tag);
        List<MenuDto> menuDtoList = new ArrayList<>();
        for (Menu menu : menuList) {
            menuDtoList.add(new MenuDto(menu));
        }
        return menuDtoList;
    }
}
