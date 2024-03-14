package com.bitcafe.menu.service;

import com.bitcafe.menu.domain.Menu;
import com.bitcafe.menu.dto.MenuResponse;
import com.bitcafe.menu.exception.MenuException;
import com.bitcafe.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.bitcafe.menu.exception.MenuErrorCode.NO_MENU;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<MenuResponse> getMenuList(Long id) {
        List<Menu> menuList = menuRepository.findAllByCategoryId(id);

        if (menuList.isEmpty()) {
            throw new MenuException(NO_MENU);
        }

        return menuList.stream()
                .map(MenuResponse::from)
                .collect(Collectors.toList());
    }

    public MenuResponse getMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuException(NO_MENU));

        return MenuResponse.from(menu);
    }
}
