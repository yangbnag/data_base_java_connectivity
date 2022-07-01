package com.jdbc.basic.account.view;

import com.jdbc.basic.account.controller.ExpenseController;
import com.jdbc.basic.account.controller.IncomeController;
import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.score.controller.ScoreController;
import com.jdbc.basic.score.domain.Score;

import java.util.List;
import java.util.Scanner;

// 화면 출력창
public class AccountMenu {

    private final IncomeController incomeController;
    private final ExpenseController expenseController;
    Scanner sc;


    public AccountMenu() {
        incomeController = new IncomeController();
        sc = new Scanner(System.in);

        expenseController = new ExpenseController();
    }



    public void mainMenu() {
        while (true) {

            System.out.println("\n ====== 가계부 [수입/지출관리] ======= ");
            System.out.println("# 1. 수입 내역 관리");
            System.out.println("# 2. 지출 내역 관리");
            System.out.println("# 9. 끝내기");

            int menu = inputN("\n메뉴입력 : ");

            switch (menu) {
                case 1:
                    incomMenu();
                    break;
                case 2:
                    expenseMenu();
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

    // 2번 메뉴
    private void expenseMenu() {
        while (true) {
            System.out.println("# 1. 지출 내역 전체 조회");
            System.out.println("# 2. 지출 항목별 조회");
            System.out.println("# 3. 지출 정보 입력");
            System.out.println("# 4. 지출 정보 삭제");
            System.out.println("# 9. 끝내기");

            int menu = inputN("\n메뉴입력 : ");

            switch (menu) {
                case 1:
                    exFindAllMenu();
                    break;

                case 2:
                    exFindCategoryMenu();
                    break;

                case 3:

                    break;
                case 4:

                    break;

                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("\n# 메뉴를 다시 입력하세요.");
            }
        }

    }

    // 2-2번
    private void exFindCategoryMenu() {

        int whereNum = inputN("확인 하실 카테고리 번호를 입력하세요.\n[ #식비 : 1번 / # 식재료 : 2번 / # 외식비 : 3번 / # 공과금 : 4번 / # 쇼핑 : 5번 ]");

        String category = null;
        if (whereNum == 1) {
            category = "식비";
        } else if (whereNum == 2) {
            category = "식재료";
        } else if (whereNum == 3) {
            category = "외식비";
        }else if (whereNum == 4) {
            category = "공과금";
        }else if (whereNum == 5) {
            category = "쇼핑";
        }
        else {
            System.out.println("카테고리 번호를 다시 확인해주세요.");
            return;
        }

        List<Expense> expenses = expenseController.findCategory(whereNum);

        System.out.printf("\n=============== %s 카테고리 수입 금액 ================\n"
                , category);
        System.out.printf("%5s %8s %13s %8s\n"
                , "일련번호", "일자", "상세내역", "금액");
        System.out.println("----------------------------------------------");

        for (Expense e : expenses) {
            System.out.printf("%5d %15s %10s %8d  \n",
                    e.getOutSerial(), e.getOutDate(), e.getOutDetail()
                    , e.getOutAmount());
        }


    }

    //2-1번 메뉴
    private void exFindAllMenu() {
        List<Expense> expense = expenseController.findAllExpense();

        System.out.printf("\n=============== 총 수입 금액 ( 금액 : %d) ================\n",
                incomeController.calClassSum());
        System.out.printf("%5s %8s %13s %8s\n"
                , "일련번호", "일자", "상세내역", "금액");
        System.out.println("----------------------------------------------");

        for (Expense e : expense) {
            System.out.printf("%5d %15s %10s %8d  \n",
                    e.getOutSerial(), e.getOutDate(), e.getOutDetail()
                    , e.getOutAmount());

        }
    }


        // 1번 메뉴
        private void incomMenu () {
            while (true) {
                System.out.println("# 1. 수입 내역 전체 조회");
                System.out.println("# 2. 수입 항목별 조회");
                System.out.println("# 3. 수입 정보 입력");
                System.out.println("# 4. 수입 정보 수정");
                System.out.println("# 5. 수입 정보 삭제");
                System.out.println("# 9. 끝내기");

                int menu = inputN("\n메뉴입력 : ");

                switch (menu) {
                    case 1:
                        inFindAllMenu();
                        break;

                    case 2:
                        inFindCategoryMenu();
                        break;

                    case 3:
                        inInsertMenu();
                        break;
                    case 4:
                        inModifyMenu();
                        break;
                    case 5:
                        inRemoveIncome();
                        break;

                    case 9:
                        System.out.println("프로그램을 종료합니다.");
                        return;

                    default:
                        System.out.println("\n# 메뉴를 다시 입력하세요.");
                }
            }
        }

        private void inModifyMenu () {
            System.out.println("\n 수정할 수입내역의 일련번호를 입력하세요!");
            int whereNum = inputN(">>>>");

            if (incomeController.hasIncome(whereNum)) {

                System.out.println("\n# 수정할 내역의 항목을 입력하세요.\n");
                sc.nextLine();
                String date = inputSt("날짜");
                String detail = inputSt("상세내역");
                int amt = inputN("금액");

                boolean flag = incomeController.updateIncome(whereNum, date, detail, amt);

                if (flag) {
                    System.out.println("#수정이 완료되었습니다.");
                } else {
                    System.out.println("수정이 실패했습니다.");
                }

            } else {
                System.out.println("\n# 해당 수입 내역이 존재하지 않습니다.");

            }
        }

        // 1-5번 메뉴
        private void inRemoveIncome () {
            System.out.println("#삭제하실 수입내역의 일련번호를 입력하세요.");
            int whereNum = inputN(">>>");

            if (incomeController.hasIncome(whereNum)) {

                boolean flag = incomeController.deleteIncome(whereNum);
                if (flag) {
                    System.out.println("#삭제가 완료되었습니다.");
                } else {
                    System.out.println("#삭제에 실패했습니다.");
                }

            } else {
                System.out.println("해당 내역은 존재하지 않습니다.");
            }
        }

        // 1-3번 메뉴
        public void inInsertMenu () {
            System.out.println("\n 수입 내역을 입력하세요. \n 먼저 카테고리 번호를 선택해주세요 \n[1번 : 월급 // 2번 : 기타소득]\n");
            int caNum = inputN("카테고리 번호");
            sc.nextLine();

            String date = inputSt("일자");
            String detail = inputSt(" 상세내역 ");
            int amt = inputN("금액");

            Income income = new Income();

            income.setInDate(date);
            income.setInDetail(detail);
            income.setInAmount(amt);


            incomeController.insertIncome(income, caNum);

            System.out.println("\n 수입 내역이 입력 되었습니다.");

        }

        // 1-2번 메뉴
        private void inFindCategoryMenu () {

            int whereNum = inputN("확인 하실 카테고리 번호를 입력하세요.\n[ #월급 : 1번 / # 기타수입 : 2번 ]");

            String category = null;
            if (whereNum == 1) {
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
            System.out.printf("%5s %8s %13s %8s\n"
                    , "일련번호", "일자", "상세내역", "금액");
            System.out.println("----------------------------------------------");

            for (Income i : incomes) {
                System.out.printf("%5d %15s %10s %8d  \n",
                        i.getInSerial(), i.getInDate(), i.getInDetail()
                        , i.getInAmount());
            }
        }

        // 1-1번 메뉴
        private void inFindAllMenu () {
            List<Income> incomes = incomeController.findAllIncome();

            System.out.printf("\n=============== 총 수입 금액 ( 금액 : %d) ================\n",
                    incomeController.calClassSum());
            System.out.printf("%5s %8s %13s %8s\n"
                    , "일련번호", "일자", "상세내역", "금액");
            System.out.println("----------------------------------------------");

            for (Income i : incomes) {
                System.out.printf("%5d %15s %10s %8d  \n",
                        i.getInSerial(), i.getInDate(), i.getInDetail()
                        , i.getInAmount());
            }
        }


        // 입력 메서드
        private int inputN (String msg){
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

        private String inputSt (String msg){
            String s;
            while (true) {
                try {
                    System.out.println(msg);
                    s = sc.nextLine();
                    break;
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("# 문자로만 입력하세요");
                }
            }
            return s;
        }

    }

