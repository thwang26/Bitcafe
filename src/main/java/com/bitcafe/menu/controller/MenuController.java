package com.bitcafe.menu.controller;

import com.bitcafe.menu.dto.MenuResponse;
import com.bitcafe.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{categoryId}")
    ResponseEntity<List<MenuResponse>> getMenuList(
            @PathVariable(value = "categoryId") Long id) {
        return ResponseEntity.ok(menuService.getMenuList(id));
    }

    @GetMapping("/detail/{menuId}")
    ResponseEntity<MenuResponse> getMenu(@PathVariable(value = "menuId") Long id) {
        return ResponseEntity.ok(menuService.getMenu(id));
    }
}
