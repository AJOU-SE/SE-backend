package SEbackend.project.Menu.Controller;

import SEbackend.project.Menu.DTO.MenuDto;
import SEbackend.project.Menu.Service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menu")
    public ResponseEntity<List<MenuDto>> getWeekList(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 0=sun, 1=mon, ... , 6=sat
        log.info("in getWeekList : dayOfWeekNumber="+dayOfWeekNumber);
        List<MenuDto> menuDtoList = menuService.getWeekList(dayOfWeekNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(menuDtoList);
    }
}
