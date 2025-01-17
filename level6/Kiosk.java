package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // -----필드 영역-----
    // Menu 클래스 객체 생성
    private final Menu menu;

    // 장바구니 리스트
    private final List<MenuItem> cart = new ArrayList<>();

    // 프로그램 반복문 중단 변수 선언
    private boolean kioskRunning = true;

    // 각 화면 단계 관리 변 수
    // (0.카테고리, 1.버거, 2.드링크, 3.디저트 ... 이후 메뉴 카테고리 추가 시 확장 가능)
    // (100.장바구니 결제 확인 화면)
    int kioskStep = 0;

    // Scanner 선언
    Scanner scanner = new Scanner(System.in);


    // -----생성자 영역-----
    // 생성자
    public Kiosk(Menu menu) {
        this.menu = menu;
    }


    // -----메서드 영역-----
    // Main 클래스에서 실행 시킬 start 메서드
    public void start() {

        // 프로그램 반복문 출력
        while (kioskRunning) {


            // 단계별로 화면 출력
            switch (kioskStep) {

                // 0. 카테고리 메뉴 화면
                case 0 -> {
                    System.out.println("\n[ MAIN MENU ]");
                    for (int i = 0; i < menu.getCategories().size(); i++) {
                        System.out.println((i + 1) + ". " + menu.getCategories().get(i));
                    }
                    System.out.println("0. 종료 | 종료");

                    // cart 리스트가 비어있지 않으면 출력
                    if (!cart.isEmpty()) {
                        System.out.println("\n[ ORDER MENU ]");
                        System.out.println((menu.getCategories().size() + 1) + ". Orders | 장바구니 확인 후 주문합니다.");
                        System.out.println((menu.getCategories().size() + 2) + ". Cancel | 진행 중인 주문 취소합니다.");
                    }

                    System.out.print("\n번호를 입력하세요: ");

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

                            // 장바구니 메뉴에서 확인 입력
                        } else if (!cart.isEmpty() && choice == ((menu.getCategories().size()) + 1)) {
                            kioskStep = 100;
                            inputLoop = false;
                            
                            // 장바구니 메뉴에서 취소 입력
                        } else if (!cart.isEmpty() && choice == ((menu.getCategories().size()) + 2)) {
                            cart.clear();
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

                // 100. 장바구니 결제 화면
                case 100 -> {
                    System.out.println("\n[ Orders ]");
                    cart.forEach(System.out::println);

                    System.out.println("\n[ Total ]");
                    System.out.println("W " + totalPrice());

                    System.out.println("\n1. 주문하기  2. 메뉴판으로 돌아가기");

                    // 유효한 번호를 입력 받을 때까지 반복
                    // 입력 반복 변수 선언
                    boolean cartOderConfirmLoop = true;

                    // 입력 반복 출력
                    while (cartOderConfirmLoop) {

                        // 입력 부분
                        int cartOderConfirm = scanner.nextInt();

                        if (cartOderConfirm == 1) {
                            System.out.println("\n주문이 완료되었습니다. 금액은 W " + totalPrice() + " 입니다.");
                            cart.clear();
                            cartOderConfirmLoop = false;
                            kioskRunning = false;

                        } else if (cartOderConfirm == 2) {
                            System.out.print("주문이 취소되었습니다. 첫 화면으로 돌아갑니다.");
                            kioskStep = 0;
                            cartOderConfirmLoop = false;
                        } else {
                            System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
                        }

                    }
                }


            }

        }
    }

    // 1.버거 ~ 3.디저트 까진 과정이 동일 하므로 menuDisplay 메서드로 통일화
    private void menuDisplay(List<MenuItem> items, String category) {
        System.out.println("\n[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("0. 뒤로가기");
        System.out.print("\n번호를 입력하세요: ");

        // 유효한 번호를 입력 받을 때까지 반복
        // 입력 반복 변수 선언
        boolean inputLoop = true;
        boolean cartAddConfirmInputLoop = true;

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
                System.out.println("\n선택한 메뉴: " + choice + ". " + choiceMenu);
                System.out.println("이 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인     2. 취소");

                // 장바구니 추가 확인 반목문
                while (cartAddConfirmInputLoop) {

                    // 추가 확인 여부 변수
                    int cartAddConfirm = scanner.nextInt();

                    if (cartAddConfirm == 1) {
                        cart.add(choiceMenu);
                        kioskStep = 0;
                        cartAddConfirmInputLoop = false;
                        inputLoop = false;
                    } else if (cartAddConfirm == 2) {
                        kioskStep = choice;
                        cartAddConfirmInputLoop = false;
                        inputLoop = false;
                    } else {
                        System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
                    }
                }

                // 잘못된 번호 입력 시 재입력
            } else {
                System.out.print("잘못된 번호입니다. 다시 입력하세요: ");
            }
        }

    }


    // 개별 가격에 10000 곱한 후, 더한 후, 다시 10000 나눔 (바로 더 하면 메모리 문제로 연산값 부정확)
    private double totalPrice() {
        return cart.stream().mapToDouble(item -> item.getPrice() * 10000).sum() / 10000;
    }

}