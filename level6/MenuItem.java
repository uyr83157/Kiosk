package com.example.level6;

public class MenuItem {

    // 필드 3개 선언 (버거이름, 가격, 설명)
    private final String foodName;
    private final double price;
    private final String description;

    // 생성자 MenuItem 선언 (인자는 버거이름, 가격, 설명)
    public MenuItem(String foodName, double price, String description) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
    }

    // 총 금액 계산 확인용 Getter
    public double getPrice() {
        return price;
    }

    // 장바구니 삭제용 Getter
    public String getFoodName() {
        return foodName;
    }


    // toString 재정의
    @Override
    public String toString() {
        return foodName + " | W " + price + " | " + description;
    }

}

