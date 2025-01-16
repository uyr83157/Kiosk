package com.example.level5;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 카테고리 이름 리스트 (Burgers, Drinks, Desserts)
    private final List<String> categories = new ArrayList<>();

    // 각 카테고리별 세부 메뉴 리스트
    private final List<MenuItem> burgers = new ArrayList<>();
    private final List<MenuItem> drinks = new ArrayList<>();
    private final List<MenuItem> desserts = new ArrayList<>();

    // Menu 생성자: 카테고리 이름 리스트에 각 카테고리 추가
    public Menu() {
    }

    // 각 리스트 추가 메서드 (Setter)
    public void addCategories(String item) {
        categories.add(item);
    }

    public void addBurgers(MenuItem item) {
        burgers.add(item);
    }

    public void addDrinks(MenuItem item) {
        drinks.add(item);
    }

    public void addDesserts(MenuItem item) {
        desserts.add(item);
    }

    // 각 리스트 조회 메서드 (Getter)
    public List<String> getCategories() {
        return categories;
    }

    public List<MenuItem> getBurgers() {
        return burgers;
    }

    public List<MenuItem> getDrinks() {
        return drinks;
    }

    public List<MenuItem> getDesserts() {
        return desserts;
    }


}