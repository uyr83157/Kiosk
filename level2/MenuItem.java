package com.example.level2;

public class MenuItem {

    // 필드 3개 선언 (버거이름, 가격, 설명)
    private final String burgerName;
    private final double price;
    private final String description;

    // 생성자 MenuItem 선언 (인자는 버거이름, 가격, 설명)
    public MenuItem(String burgerName, double price, String description) {
        this.burgerName = burgerName;
        this.price = price;
        this.description = description;
    }

    // toString 재정의
    @Override
    public String toString() {
        return burgerName + " | W " + price + " | " + description;
    }

}

