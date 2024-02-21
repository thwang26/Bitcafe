package com.bitcafe.menu.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{menuId}")
    ResponseEntity<List<MenuResponse>> getMenuList(
            @PathVariable(value = "menuId") Long id) {
        return ResponseEntity.ok(menuService.getMenuList(id));
    }
}
