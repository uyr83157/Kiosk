package com.example.level6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // Menu 클래스 객체 생성
    private Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    // 반복문 중단 변수 선언
    private boolean kioskRunning = true;

    // 각 화면 단계 (0.카테고리, 1.버거, 2.드링크, 3.디저트)
    int kioskStep = 0;

    // Scanner 선언
    Scanner scanner = new Scanner(System.in);

    // Main 클래스에서 실행 시킬 start 메서드
    public void start() {

        // 반복문 출력
        while (kioskRunning) {

            // 단계별로 화면 출력
            switch (kioskStep) {

                // 0. 카테고리 메뉴 화면
                case 0 -> {
                    System.out.println(" ");
                    System.out.println("[ MAIN MENU ]");
                    for (int i = 0; i < menu.getCategories().size(); i++) {
                        System.out.println((i + 1) + ". " + menu.getCategories().get(i));
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

                        // 0번 입력 시 입력루프 종료 + 프로그램 종료
                        if (choice == 0) {
                            System.out.println("0번을 입력하셨습니다. 프로그램을 종료합니다.");
                            inputLoop = false;
                            kioskRunning = false;

                            // 메뉴 번호 입력 시 다음 로직
                        } else if (choice > 0 && choice <= menu.getCategories().size()) {
                            kioskStep = choice;
                            inputLoop = false;

                            // 잘못된 번호 입력 시 재입력
                        } else {
                            System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
                        }
                    }
                }

                // 1. 버거 메뉴 화면 (람다 형식)
                case 1 -> menuDisplay(menu.getBurgers(), "Burgers");

                // 2. 드링크 메뉴 화면 (람다 형식)
                case 2 -> menuDisplay(menu.getDrinks(), "Drinks");

                // 3. 디저트 메뉴 화면 (람다 형식)
                case 3 -> menuDisplay(menu.getDesserts(), "Desserts");


            }
        }
    }

    // 1.버거 ~ 3.디저트 까진 과정이 동일 하므로 menuDisplay 메서드로 통일화
    private void menuDisplay(List<MenuItem> items, String category) {
        System.out.println(" ");
        System.out.println("[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("0. 뒤로가기");
        System.out.println(" ");
        System.out.print("번호를 입력하세요: ");

        // 유효한 번호를 입력 받을 때까지 반복
        // 입력 반복 변수 선언
        boolean inputLoop = true;

        // 입력 반복 출력
        while (inputLoop) {

            // 입력 부분
            int choice = scanner.nextInt();

            // 0번 입력 시 입력루프 종료 + 프로그램 종료
            if (choice == 0) {
                System.out.println("0번을 입력하셨습니다. 이전 화면으로 이동합니다.");
                inputLoop = false;
                kioskStep = 0;

                // 메뉴 번호 입력 시 다음 로직
            } else if (choice > 0 && choice <= items.size()) {
                MenuItem choiceMenu = items.get(choice - 1);
                System.out.println(" ");
                System.out.println("선택한 메뉴: " + choice + ". " + choiceMenu);
                inputLoop = false;
                kioskRunning = false;

                // 잘못된 번호 입력 시 재입력
            } else {
                System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
            }
        }

    }
}