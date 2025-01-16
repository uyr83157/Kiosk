package com.example.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List<MenuItem> 배열 선언
        List<MenuItem> menuItems = new ArrayList<>();

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);


        // List<MenuItem> 배열에 MenuItem 생성자를 이용하여
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


        // 반복문 중단 변수 선언
        boolean kioskFlag = true;

        // 반복문 출력
        while (kioskFlag) {

            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료 | 종료");
            System.out.println(" ");
            System.out.print("번호를 입력하세요: ");

            // 유효한 번호를 입력 받을 때까지 반복
            // 입력 반복 변수 선언
            boolean inputLoop = true;

            // 입력 반복 출력
            while (inputLoop) {

                // 입력 부분
                int choice = scanner.nextInt();

                // 0번 입력 시 종료
                if (choice == 0) {
                    System.out.println("0번을 입력하셨습니다.");
                    System.out.println("프로그램을 종료합니다.");
                    inputLoop = false;
                    kioskFlag = false;


                    // 메뉴 번호 입력 시 다음 로직
                } else if (choice > 0 && choice <= menuItems.size()) {
                    MenuItem choiceMenu = menuItems.get(choice - 1);
                    System.out.println("선택한 메뉴: " + choice + ". " + choiceMenu);
                    inputLoop = false;
                    kioskFlag = false;

                    // 잘못된 번호 입력 시 재입력
                } else {
                    System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
                }

            }
        }
    }
}

