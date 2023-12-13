package team;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Cafe{
   private String name;
   private int pkNum; // PK값 받는 변수
   private int menuNum; // 사용자에게 보여지는 메뉴번호
   private int price;
   private String size; // R or L
   private String option; // Ice or Hot
   private int kcal; // 상세정보
   private int caffeine; // 상세정보
   private int bean;
   private int milk;
   private int ice;

   // 재고 맴버변수 : 초기값 5으로 설정
   private static int StockBean = 5;
   private static int StockMilk = 5;
   private static int StockIce = 5;

   Cafe(int pkNum, int menuNum, String name, int price, String size, String option, int kcal, int caffeine, int bean,
         int milk, int ice) {
      this.pkNum = pkNum;
      this.menuNum = menuNum;
      this.name = name;
      this.price = price;
      this.size = size;
      this.option = option;
      this.kcal = kcal;
      this.caffeine = caffeine;
      this.bean = bean;
      this.milk = milk;
      this.ice = ice; 
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPkNum() {
      return pkNum;
   }

   public void setPkNum(int pkNum) {
      this.pkNum = pkNum;
   }

   public int getMenuNum() {
      return menuNum;
   }

   public void setMenuNum(int menuNum) {
      this.menuNum = menuNum;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getSize() {
      return size;
   }

   public void setSize(String size) {
      this.size = size;
   }

   public String getOption() {
      return option;
   }

   public void setOption(String option) {
      this.option = option;
   }

   public int getKcal() {
      return kcal;
   }

   public void setKcal(int kcal) {
      this.kcal = kcal;
   }

   public int getCaffeine() {
      return caffeine;
   }

   public void setCaffeine(int caffeine) {
      this.caffeine = caffeine;
   }

   public int getBean() {
      return bean;
   }

   public void setBean(int bean) {
      this.bean = bean;
   }

   public int getMilk() {
      return milk;
   }

   public void setMilk(int milk) {
      this.milk = milk;
   }

   public int getIce() {
      return ice;
   }

   public void setIce(int ice) {
      this.ice = ice;
   }

   public static int getStockBean() {
      return StockBean;
   }

   public static void setStockBean(int stockBean) {
      StockBean = stockBean;
   }

   public static int getStockMilk() {
      return StockMilk;
   }

   public static void setStockMilk(int stockMilk) {
      StockMilk = stockMilk;
   }

   public static int getStockIce() {
      return StockIce;
   }

   public static void setStockIce(int stockIce) {
      StockIce = stockIce;
   }


   // 주문 --> 재고빠짐
   public void makeCoffee() { 
      if (this.bean > Cafe.getStockBean() || this.milk > Cafe.getStockMilk() || this.ice > Cafe.getStockIce()) {
         System.out.println("죄송합니다. 해당 상품은 품절되었습니다.");
         return;
      }
      Cafe.StockBean -= this.bean;
      Cafe.StockMilk -= this.milk; 
      Cafe.StockIce -= this.ice; 
   }

   @Override
   public String toString() {
      return this.option + this.name + this.size + " 가격: " + this.price + "원";
   }

   // 사용자 메뉴 출력 : 메뉴 삭제시 index번호가 달라져서 배열에서 index번호를 받아옴
   public String userMenuPrintInfo(int index) {
      return "[" + index + "] " + this.option + this.name + " " + this.size + " 가격: " + this.price + "원";
   }

   // 메뉴가격 변경때 사용
   public String adminMenuPrintInfo() {
      return "[" + this.pkNum + "] " + this.option + this.name + " " + this.size + " 가격: " + this.price + "원";
   }

}

public class Cafe1{
   // scanner 선언
   private static Scanner sc = new Scanner(System.in);

   // 사용자 키오스크 목록 출력()
   public static void userKioskListPrint() {
      System.out.println("====== 카   페 ======");
      System.out.println("1. 전체메뉴");
      System.out.println("2. 추천메뉴");
      System.out.println("3. 메뉴 상세정보");
      System.out.println("4. 장바구니");
      System.out.println("0. 종료");
      System.out.println("====================");
   }

   // 관리자 키오스크 목록 출력()
   public static void adminKioskListPrint() {
      System.out.println("===== 관리자 모드 =====");
      System.out.println("1. 재고 확인 및 추가");
      System.out.println("2. 메뉴 가격 변경");
      System.out.println("3. 메뉴 삭제");
      System.out.println("0. 관리자 모드 종료");
      System.out.println("====================");
   }

   //유효성 검사1 () 
   public static int validation(String msg, int minNum, int maxNum) { // 1-3번까지 입력하면 ok
      int num;
      System.out.print(msg);
      while (true) {
         try {
            num = sc.nextInt();
            if (num >= minNum && num <= maxNum) {
               return num;
            }
         } catch (InputMismatchException e) {
            System.out.println("숫자를 입력하세요!");
            sc.nextLine();

         }
         System.out.print("잘못입력했습니다. 다시 입력해주세요. >> ");
      }
   }

   // 유효성 검사2() : 관리자모드-119 받기위해 오버로딩
   public static int validation(String msg, int minNum, int maxNum, int exNum) {
      int num;
      System.out.println(msg);
      while (true) {
         try {
            num = sc.nextInt();
            if ((num >= minNum && num <= maxNum) || num == exNum) {
               return num;
            }

         } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요!\n");
            sc.nextLine();
            continue;
         }
         System.out.print("잘못입력했습니다. 다시 입력해주세요. >> ");
      }
   }

   // 전체메뉴출력()
   public static void menuPrintInfo(ArrayList<Cafe> datas, String type) {
      System.out.println("============= M e n u =============");
      for (Cafe data : datas) {
         // 사용자 메뉴판 출력
         if (type.equals("userMenu")) {
            System.out.println(data.userMenuPrintInfo(datas.indexOf(data) + 1)); //메뉴가 1번부터 시작하므로 +1
         }
         // 관리자 메뉴판 출력 (PK출력; 가격변경때 사용)
         else {
            System.out.println(data.adminMenuPrintInfo());
         }
      }
      System.out.println("===================================");
   }


   // 재고목록()
   public static void stock() {
      System.out.println("======= 재 고 =======");
      System.out.println("1. 원두 : " + Cafe.getStockBean());
      System.out.println("2. 우유 : " + Cafe.getStockMilk());
      System.out.println("3. 얼음 : " + Cafe.getStockIce());
      System.out.println("====================");
   }

   // 재고추가()
   public static void stockToAdd() {
      int stockNum = 0;
      int ans = 0;
      // 재고 확인
      stock();
      // 재고 추가
      System.out.print("재고를 추가 하시겠습니까?");
      System.out.println();
      ans = validation("1.네\n2.아니오\n>> ",1,2);
      while (true) {
         if (ans == 1) {
            String msg = "추가할 재고번호 입력 >> ";
            stockNum = validation(msg, 1, 3);
            if (stockNum == 1) {
               System.out.print("추가할 수량 입력 >> ");
               Cafe.setStockBean(Cafe.getStockBean() + sc.nextInt());
            } else if (stockNum == 2) {
               System.out.print("추가할 수량 입력 >> ");
               Cafe.setStockMilk(Cafe.getStockMilk() + sc.nextInt());
            } else if (stockNum == 3) {
               System.out.print("추가할 수량 입력 >> ");
               Cafe.setStockIce(Cafe.getStockIce() + sc.nextInt());
            } else {
               System.out.println("잘못입력하셨습니다");
            }
         } else {
            System.out.println("관리자 메인으로 돌아갑니다.");
            return;
         }
         break;
      }
      // 재고 확인
      stock();

   }

   public static void changePrice(ArrayList<Cafe> datas, int num) {

      System.out.print("변경할 번호 입력 >> ");
      int selectPkNum = sc.nextInt();
      for(Cafe data : datas) {
         if (selectPkNum == data.getPkNum()) {
            int changePrice = validation("변경할 가격 입력 >> ",-1,2000000000);
            System.out.println(selectPkNum + "번 가격이 변경되었습니다.");
            data.setPrice(changePrice);
            return;
         }
      }
      System.out.println("해당 번호의 데이터가 없습니다");
    }
   

   public static void deleteNumber(ArrayList<Cafe> datas) {
      if(datas.size()<=0) {
         System.out.println("삭제할 데이터가 없습니다..");
          //return;
      }
      System.out.print("삭제할 번호를 입력 >> ");
      int selectPkNum = sc.nextInt();

      for (Cafe data : datas) {
         if (selectPkNum == data.getPkNum()) {
            System.out.println(selectPkNum + "번이 삭제되었습니다.");
            datas.remove(data);
            return;
         }
      }
      System.out.println("해당 번호에 해당하는 데이터가 없습니다");
   }

   public static void detailedInfo(ArrayList<Cafe> datas) {
      System.out.println("=========== 메 뉴 상 세 정 보 ===========");
      for (int i = 0; i < datas.size(); i++) {
         System.out.println(datas.get(i).getOption()+ datas.get(i).getName() + datas.get(i).getSize() + " 칼로리:" + datas.get(i).getKcal()
               + "kcal" + " 카페인:" + datas.get(i).getCaffeine());
      }
      System.out.println("======================================");
   }

   public static void randomSell(ArrayList<Cafe> cart, ArrayList<Cafe> datas, int selectNum, int num) {
      if (selectNum == 1) {
         cart.add(datas.get(num));
         System.out.println("장바구니에 담겼습니다 *^__^*");
      } else if (selectNum == 2) {
         System.out.println("메인 화면으로 돌아갑니다 *^__^*");
      }
   }

   public static void main(String[] args) {

      ArrayList<Cafe> datas = new ArrayList<Cafe>();
      ArrayList<Cafe> cart = new ArrayList<Cafe>();
      int PK = 1001;
      int menuNum = 1;
      int action = 0;
      
      

      // 샘플데이터(배열에 추가 : Cafe생성자(PK, 메뉴번호, 이름, 가격, 사이즈, 옵션, 칼로리, 카페인, 원두, 우유, 얼음))
      datas.add(new Cafe(PK++, menuNum++, "에스프레소", 3000, "R", "[핫] ", 10, 100, 1, 0, 0));
      datas.add(new Cafe(PK++, menuNum++, "아메리카노", 4000, "R", "[핫] ", 15, 100, 1, 0, 0));
      datas.add(new Cafe(PK++, menuNum++, "아메리카노", 4000, "R", "[아이스] ", 15, 100, 1, 0, 1));
      datas.add(new Cafe(PK++, menuNum++, "아메리카노", 4500, "L", "[핫] ", 15, 200, 2, 0, 0));
      datas.add(new Cafe(PK++, menuNum++, "아메리카노", 4500, "L", "[아이스] ", 15, 200, 2, 0, 2));
      datas.add(new Cafe(PK++, menuNum++, "카페라떼", 5000, "R", "[핫] ", 170, 100, 1, 1, 0));
      datas.add(new Cafe(PK++, menuNum++, "카페라떼", 5000, "R", "[아이스] ", 170, 100, 1, 1, 1));
      datas.add(new Cafe(PK++, menuNum++, "카페라떼", 5500, "L", "[핫] ", 175, 200, 2, 2, 0));
      datas.add(new Cafe(PK++, menuNum++, "카페라떼", 5500, "L", "[아이스] ", 175, 200, 2, 2, 2));

      while (true) {
         // 사용자 목록 출력
         userKioskListPrint(); // 전체메뉴를 보여주는 함수
         action = validation("번호 입력 >> ", 0, 4, 119); // 경계값 검사, 사용자가 없는 번호 선택시

         // [0] 종료
         if (action == 0) {
            System.out.println("주문을 종료합니다.");
            break;
         }
         // [119] 관리자 모드
         else if (action == 119) {
            while (true) {
               // 관리자 키오스크 메뉴 출력()
               adminKioskListPrint();
               // 유효성 검사 & 올바른 번호 저장
               action = validation("번호 입력 >> ", 0, 3);
               // [0] 종료
               if (action == 0) {
                  System.out.println("관리자 모드 종료");
                  break;
               }
               // [1] 재고 확인 및 추가 
               else if (action == 1) {
                  stockToAdd();
               }
               // [2] 메뉴 가격 변경
               else if (action == 2) {
                  menuPrintInfo(datas, "adminMenu");
                  changePrice(datas, PK);
               }
               // [3] 메뉴 삭제 
               else if (action == 3) {
                  menuPrintInfo(datas, "adminMenu");
                  deleteNumber(datas);
               }
            }
         }

         // [1] 전체메뉴 출력 >> 
         else if (action == 1) {
            int num;
            // [1-1] 전체메뉴 출력
            while(true) {
               menuPrintInfo(datas, "userMenu");
               num = validation("선택할 메뉴 번호 입력 >> ", 1, datas.size());
               cart.add(datas.get(num - 1));
               System.out.println("장바구니에 담겼습니다 *^__^*");
               System.out.println("주문을 종료하시겠습니까?");
               num = validation("1.네\n2.아니오\n>> ", 1, 2);
               if(num==1) break;
               else if(num==2) continue;
               }
            }
            // [1-2] 메뉴 선택
            // 유효성 검사 & 올바른 번호 저장
            // 장바구니
         

         // [2] 추천메뉴 출력 >> 
         else if (action == 2) {
            int selectNum;
            System.out.print(" ♥ 오늘의 추천메뉴 ♥\n");
            int randNum = new Random().nextInt(datas.size());
            System.out.println(datas.get(randNum));
            System.out.println("추천메뉴를 구매하시겠습니까?");
            // 유효성 검사 & 올바른 번호 저장
            selectNum = validation(" 1.네 \n 2.아니요 \n 번호 입력 >> ", 1, 2);
            randomSell(cart, datas, selectNum, randNum);
         }

         // [3] 메뉴 상세정보 출력
         else if (action == 3) {
            detailedInfo(datas);
         } 
         //[4] 장바구니 
         else if (action == 4) {
            if (cart.size() <= 0) {
               System.out.println("장바구니가 비었습니다");
               continue;
            }
            int totalAmount = 0; //총 값을 담을 변수
            // 장바구니 목록 출력
            for (Cafe menu : cart) {
               System.out.println(menu);
               menu.makeCoffee(); //메뉴 선택 시 재고가 전체 빠짐
               totalAmount += menu.getPrice(); //총 가격
            }
            while (true) {
               System.out.println("총 금액: " + totalAmount+"원");
               System.out.println("결제하시겠습니까?");
               int ans = validation("1. 네\n2. 아니오\n>> ", 1, 2);
               if (ans == 1) {
                  // 장바구니 결제
                  System.out.println("결제완료!");
                  System.out.println("맛있게 드세요*^__^*");
                  cart.clear();
                  break;
               } else if (ans == 2) {
                  System.out.println("메인화면으로 돌아갑니다");
                  break;
               } else {
                  System.out.println("잘못누르셨습니다");
               }
            }
         }
      }
}}