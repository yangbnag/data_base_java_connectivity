package com.jdbc.basic.account.view;

import com.jdbc.basic.account.controller.IncomeController;
import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.score.controller.ScoreController;
import com.jdbc.basic.score.domain.Score;

import java.util.List;
import java.util.Scanner;

// 화면 출력창
public class AccountMenu {

    private final IncomeController incomeController;
    Scanner sc;


    public AccountMenu() {
        incomeController = new IncomeController();
        sc = new Scanner(System.in);
    }
    public void mainMenu() {
        while (true) {

            System.out.println("\n ====== 가계부 [수입/지출관리] ======= ");
            System.out.println("# 1. 수입 내역 전체 조회");
            System.out.println("# 2. 지출 내역 전체 조회");
            System.out.println("# 3. 수입 항목별 조회");
            System.out.println("# 4. 지출 항목별 조회");
            System.out.println("# 5. 수입 정보 입력");
            System.out.println("# 6. 지출 정보 입력");
            System.out.println("# 7. 수입 정보 삭제");
            System.out.println("# 8. 지출 정보 삭제");
            System.out.println("# 9. 끝내기");

            int menu = inputN("\n메뉴입력 : ");

            switch (menu) {
                case 1:
                    findAllMenu();
                    break;
                case 2:

                    break;
                case 3:
                   findCategoryMenu();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    return;

                default:
                    System.out.println("\n# 메뉴를 다시 입력하세요.");
            }
        }
    }

    // 3번 메뉴
    private void findCategoryMenu() {

       int whereNum = inputN("확인 하실 카테고리 번호를 입력하세요. \n [ #월급 : 1번 / # 기타수입 : 2번 ]");
       String category = null;
       if(whereNum == 1) {
            category = "월급";
        } else if (whereNum == 2) {
           category = "기타수입";
       } else {
           System.out.println("카테고리 번호를 다시 확인해주세요.");
           return;
       }

        List<Income> incomes = incomeController.findCategory(whereNum);

        System.out.printf("\n=============== %s 카테고리 수입 금액 ================\n"
               , category);
        System.out.printf("%5s%5s%5s%5s\n"
                , "일련번호", "일자", "상세내역", "금액");
        System.out.println("----------------------------------------------");

        for (Income i : incomes) {
            System.out.printf("%5d %5s %5s %5d  \n",
                    i.getInSerial(), i.getInDate(), i.getInDetail()
                    , i.getInAmount());
        }
    }

    // 1번 메뉴
    private void findAllMenu() {
        List<Income> incomes = incomeController.findAllIncome();

        System.out.printf("\n=============== 총 수입 금액 ( 금액 : %d) ================\n",
                incomeController.calClassSum());
        System.out.printf("%5s%5s%5s%5s\n"
                , "일련번호", "일자", "상세내역", "금액");
        System.out.println("----------------------------------------------");

        for (Income i : incomes) {
            System.out.printf("%5d %5s %5s %5d  \n",
                     i.getInSerial(), i.getInDate(), i.getInDetail()
                    , i.getInAmount());
        }
    }


// 입력 메서드
    private int inputN(String msg) {
        int n;
        while (true) {
            try {
                System.out.println(msg);
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 정수로만 입력하세요");
            }
        }
        return n;
    }

    private String inputSt(String msg) {
        String s;
        while (true) {
            try {
                System.out.println(msg);
                s = sc.nextLine();
                sc.next();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 문자로만 입력하세요");
            }
        }
        return s;
    }


}
