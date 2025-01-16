package com.example.level4;

public class Main {
    public static void main(String[] args) {

        // Menu 클래스 객체 생성
        Menu menu = new Menu();

        // Menu 클래스의 addCategories 메서드로 categories 리스트에 추가
        menu.addCategories("Burgers");
        menu.addCategories("Drinks");
        menu.addCategories("Desserts");

//        // categories 리스트 정상 추가 확인 테스트
//        System.out.println("categories 리스트");
//        for (String item : menu.getCategories()) {
//            System.out.println(item);
//        }
//        System.out.println(" ");

        // Menu 클래스의 addBurger 메서드로 burger 리스트에 추가
        menu.addBurgers(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addBurgers(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addBurgers(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addBurgers(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

//        // burger 리스트 정상 추가 확인 테스트
//        System.out.println("burger 리스트");
//        for (MenuItem item : menu.getBurgers()) {
//            System.out.println(item);
//        }
//        System.out.println(" ");

        // Menu 클래스의 addDrink 메서드로 drink 리스트에 추가
        menu.addDrinks(new MenuItem("Fountain Soda", 2.9, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지 등"));
        menu.addDrinks(new MenuItem("Lemonade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드"));
        menu.addDrinks(new MenuItem("Fresh Brewed Iced Tea", 3.7, "직접 유기농 홍차를 우려낸 아이스 티"));
        menu.addDrinks(new MenuItem("Shack Latte", 4.5, "쉑 블렌드 원두로 내린 에스프레소에 부드러운 우유를 더한 라떼"));

//        // drink 리스트 정상 추가 확인 테스트
//        System.out.println("drink 리스트");
//        for (MenuItem item : menu.getDrinks()) {
//            System.out.println(item);
//        }
//        System.out.println(" ");

        // Menu 클래스의 addDessert 메서드로 dessert 리스트에 추가
        menu.addDesserts(new MenuItem("Floats", 6.8, "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료"));
        menu.addDesserts(new MenuItem("Cup & Cones", 6.8, "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림"));
        menu.addDesserts(new MenuItem("Classic Hand-Spun Shakes", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        menu.addDesserts(new MenuItem("Shack Attack", 6.2, "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"));

//        // dessert 리스트 정상 추가 확인 테스트
//        System.out.println("dessert 리스트");
//        for (MenuItem item : menu.getDesserts()) {
//            System.out.println(item);
//        }
//        System.out.println(" ");


        Kiosk kiosk = new Kiosk(menu);

        kiosk.start();
    }
}
