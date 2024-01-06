package team;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Book {
   private int id;// key
   private String publisher;// 출판사
   private String writer;// 작가
   private int price;// 가격
   private String bookTitle;// 책제목
   private String genre;// 장르
   private int inventory;// 재고

   public Book(int id, String publisher, String writer, int price, String bookTitle, String genre, int inventory) {
      this.id = id;
      this.publisher = publisher;
      this.writer = writer;
      this.price = price;
      this.bookTitle = bookTitle;
      this.genre = genre;
      this.inventory = inventory;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getInventory() {
      return inventory;
   }

   public String getPublisher() {
      return publisher;
   }

   public String getWriter() {
      return writer;
   }

   public void setInventory(int inventory) {
      this.inventory = inventory;
   }

   public String getBookTitle() {
      return bookTitle;
   }

   public String getGenre() {
      return genre;
   }

   public void sell(int cnt) {// 판매
      this.inventory -= cnt;

   }

   public void addInventory(int inventory) {// 재고 추가
      this.inventory += inventory;
   }

   public int getId() {
      return id;
   }

   public void printInfo() {
      System.out.println(this.bookTitle + " " + this.price + " " + this.writer);
   }

   @Override
   public String toString() {
      return "제목 : " + this.bookTitle + "\n출판사 : " + this.publisher + "\n작가 : " + this.writer + "\n가격 : " + this.price
            + "\n장르 : " + this.genre + "\n재고 : " + this.inventory + "\n";
   }

}

class Comic extends Book {

   public Comic(int id, String publisher, String writer, int price, String bookTitle, int inventory) {
      super(id, publisher, writer, price, bookTitle, "코믹", inventory);
   }

}

class Novel extends Book {
   private String conte;// 장/단편 소설

   public Novel(int id, String publisher, String writer, int price, String bookTitle, int inventory, String conte) {
      super(id, publisher, writer, price, bookTitle, "소설", inventory);
      this.conte = conte;
   }

   public String getConte() {
      return conte;
   }

   @Override
   public String toString() {
      return "제목 : " + getBookTitle() + "\n장/단편 : " + this.conte + "\n출판사 : " + getPublisher() + "\n작가 : "
            + getWriter() + "\n가격 : " + getPrice() + "\n장르 : " + getGenre() + "\n재고 : " + getInventory() + "\n";
   }
}


public class BookStore {

   static Scanner sc = new Scanner(System.in);

   public static int dummy(ArrayList<Book> book, int id) {
      book.add(new Comic(id++, "A", "박현구", 1000, "마블", 10));
      book.add(new Novel(id++, "A", "박현구", 1000, "어린왕자", 20, "장편"));
      book.add(new Comic(id++, "A", "박현민", 2000, "집", 10));
      book.add(new Novel(id++, "A", "박현민", 3000, "마가자", 20, "단편"));
      book.add(new Comic(id++, "B", "노승현", 1000, "나는", 10));
      book.add(new Novel(id++, "B", "노승현", 1000, "잔다", 20, "장편"));
      book.add(new Comic(id++, "B", "박현민", 2000, "수고", 10));
      book.add(new Novel(id++, "B", "박현민", 3000, "안녕", 20, "단편"));
      return id;
   }

   public static void notFound() { // 검색결과 없음
      System.out.println("검색결과가 없습니다.");
   }

   public static void bookAdd(ArrayList<Book> book, int PK) {
      String publisher;// 출판사
      String writer;// 작가
      int price;// 가격
      String bookTitle;// 책제목
      int inventory;// 재고
      int actionConte;// 장-단
      String conte = "";
      int actionAddBook = genreMenu();
      System.out.println(actionAddBook == 1 ? "코믹" : "소설" + "을 추가합니다.");
      System.out.print("책제목 : ");
      bookTitle = sc.next();
      sc.nextLine();
      if (actionAddBook == 2) {
         System.out.println("1.장편 2.단편");
         System.out.print(">>> ");
         actionConte = numCk(1, 2);
         if (actionConte == 1)
            conte = "장편";
         else if (actionConte == 2)
            conte = "단편";
      }
      System.out.print("작가 : ");
      writer = sc.next();
      sc.nextLine();
      System.out.print("가격 : ");
      price = minCk(0);
      System.out.print("출판사 : ");
      publisher = sc.next();
      sc.nextLine();
      System.out.print("재고 : ");
      inventory = minCk(0);
      if (actionAddBook == 1) {
         book.add(new Comic(PK, publisher, writer, price, bookTitle, inventory));
      } else if (actionAddBook == 2) {
         book.add(new Novel(PK, publisher, writer, price, bookTitle, inventory, conte));
      }
   }

   public static int genreMenu() {
      System.out.println("1. 코믹");
      System.out.println("2. 소설");
      System.out.print("장르를 선택해주세요 : ");
      return numCk(1, 2);
   }

   public static int detail(ArrayList<Book> searchList) { // 상세보기
      System.out.println("0. 돌아가기");
      System.out.print("책 선택 : ");
      int action = numCk(0, searchList.size());

      if (action == 0) { // 돌아가기
         return -1;
      }
      System.out.println(searchList.get(action - 1));
      return searchList.get(action - 1).getId(); // PK값
   }

   public static int searchTitle(ArrayList<Book> book, ArrayList<Book> searchList) { // 제목 검색
      boolean flag = false;// 검색한 책이 있는지 진위형으로 판단

      System.out.print("검색하고 싶은 제목을 입력하세요 : ");
      String search = sc.next();
      sc.nextLine();
      for (int i = 0; i < book.size(); i++) {
         if (book.get(i).getBookTitle().contains(search)) {// contains로 한 글자라도 맞을 시 if문 실행
            System.out.print(searchList.size() + 1 + ". ");// 검색 하여 나온 책들 검색 리스트의 크기로 번호 출력
            book.get(i).printInfo();// 검색 결과 나온 책 출력
            searchList.add(book.get(i));// 검색 리스트에 추가
            flag = true;// 책이 있기 때문에 true 대입
         }
      }
      int pkValue = -1;// pk 최소가 0이라서
      if (!flag) {// 책이 없을 경우 호출
         notFound();
      } else {
         pkValue = detail(searchList);// 책의 상세 정보 확인를 위한 사용자 선택을 받기 위해 detail 함수 호출
         // input : 검색해서 나온 저장된 책 검색리스트를 인자로 넘김
         // output : 사용자가 선택한 책의 pkValue(PK)를 반환
      }
      return pkValue;
   }

   public static int searchWriter(ArrayList<Book> book, ArrayList<Book> searchList) { // 작가 검색
      boolean flag = false;
      System.out.print("검색하고 싶은 작가를 입력하세요 : ");
      String search = sc.next();
      sc.nextLine();
      for (int i = 0; i < book.size(); i++) {
         if (book.get(i).getWriter().contains(search)) {
            System.out.print(searchList.size() + 1 + ". ");
            book.get(i).printInfo();
            searchList.add(book.get(i));
            flag = true;
         }
      }
      int pkValue = -1;
      if (!flag) {
         notFound();
      } else {
         pkValue = detail(searchList);
      }
      return pkValue;
   }

   public static int searchPublisher(ArrayList<Book> book, ArrayList<Book> searchList) { // 출판사 검색
      boolean flag = false;
      System.out.print("검색하고 싶은 출판사를 입력하세요 : ");
      String search = sc.next();
      sc.nextLine();
      for (int i = 0; i < book.size(); i++) {
         if (book.get(i).getPublisher().contains(search)) {
            System.out.print(searchList.size() + 1 + ". ");
            book.get(i).printInfo();
            searchList.add(book.get(i));
            flag = true;
         }
      }
      int pkValue = -1;
      if (!flag) {
         notFound();
      } else {
         pkValue = detail(searchList);
      }
      return pkValue;
   }

   public static int searchGenre(ArrayList<Book> book, ArrayList<Book> searchList) { // 장르 검색
      boolean flag = false;
      System.out.println("검색하실 장르를 선택하세요");
      int option = genreMenu();
      flag = searchGenreFunc(book, searchList, option == 1 ? "코믹" : "소설");
      //함수화 한 이유 코믹과 소설 장르를 출력할때 같은 방식으로 출력하기때문이다 [예상질문답변]
      //저희 서점은 코믹과 소설만 취급하기 때문에 삼항연산자를 사용
      //input : 책리스트,검색리스트,장르를 인자로 넘김
      //output: 진위형으로 성공 실패 판단 searchList 반환 하지 않는 이유는 call by reference 이기 때문
      
      int pkValue = -1;
      if (!flag) {
         notFound();
      } else {
         pkValue = detail(searchList);
      }
      return pkValue;
   }

   public static boolean searchGenreFunc(ArrayList<Book> book, ArrayList<Book> searchList, String option) {
      boolean flag = false;
      for (int i = 0; i < book.size(); i++) {
         if (book.get(i).getGenre().equals(option)) {//인자로 넘어온 option(장르)와 비교해서
            System.out.print(searchList.size() + 1 + ". ");// 해당 장르의 데이터를 출력
            book.get(i).printInfo();
            searchList.add(book.get(i));
            flag = true;
         }
      }
      return flag;
   }

   public static int search(ArrayList<Book> book, ArrayList<Book> searchList) { // 전체 검색
      boolean flag = false;
      for (int i = 0; i < book.size(); i++) {
         System.out.print(searchList.size() + 1 + ". ");
         book.get(i).printInfo();
         searchList.add(book.get(i));
         flag = true;
      }
      int pkValue = -1;
      if (!flag) {
         notFound();
      } else {
         pkValue = detail(searchList);
      }
      return pkValue;
   }



   public static int numCk(int min, int max) {

      int input = -1;
      while (true) {
         try {
            input = sc.nextInt();
            sc.nextLine();
         } catch (Exception e) {
            sc.nextLine();
         }

         if (min <= input && input <= max) {
            break;
         }
         System.out.println("입력이 잘못 되었습니다");
         // System.out.println(min + "~" + max + " 사이의 숫자를 입력해 주세요");
         System.out.print(">>> ");
      }
      return input;
   }

   public static int minCk(int min) {
      int input = -1;
      while (true) {
         try {
            input = sc.nextInt();
            sc.nextLine();
         } catch (Exception e) {
            sc.nextLine();
         }

         if (min <= input) {
            break;
         }
         System.out.println("입력이 잘못 되었습니다");
         System.out.println(min + "이상의 정수 입력해 주세요");
         System.out.print(">>> ");
      }
      return input;
   }

   public static int mainMenu() {
      int action = -1;
      System.out.println("=====도서 프로그램=======");
      System.out.println("1. 책 검색");
      System.out.println("2. 장르별 베스트셀러");
      System.out.println("3. 장바구니 및 구매");
      System.out.println("0. 프로그램 종료");
      System.out.print("메뉴를 선택하세요 : ");
      while (true) {
         try {
            action = sc.nextInt();
            sc.nextLine();
         } catch (Exception e) {
            System.out.println("정수를 입력하세요!");
            sc.nextLine();
         }
         if (0 <= action && action <= 3 || action == 19991001) {
            break;
         }
         System.out.println("입력이 잘못 되었습니다");
         System.out.println("0~3 사이의 숫자를 입력해 주세요");
         System.out.print(">>> ");
      }
      return action;
   }

   public static int searchMenu(ArrayList<Book> book, ArrayList<Book> searchList) {
      int pkValue = -1;// PK는 0부터 시작이기 때문에 0보다 작은 숫자인 -1로 초기화
      int actionBookSearch;// 검색 방식 저장 변수
      if (book.size() <= 0) {// 책이 단 한권도 없을 때 실행
         System.out.println("등록된 책이 없습니다");
         return pkValue;
      }
      System.out.println("======도서 검색======");
      System.out.println("1. 제목 검색");
      System.out.println("2. 작가 검색");
      System.out.println("3. 출판사 검색");
      System.out.println("4. 장르 검색");
      System.out.println("5. 전체 검색");
      System.out.println("0. 돌아가기");
      System.out.print("검색할 방식을 선택해주세요 : ");
      actionBookSearch = numCk(0, 5);// 0~5사이의 값을 받기위해 유효성 검사
      // input : 도서 검색의 최소 값인 0,최대 값인 5를 인자로 넘김
      // output : 선택한 정수를 리턴 받는다
      // 검색 방식 변수에 리턴 받은 정수를 저장
      if (actionBookSearch == 1) { // 1. 제목 검색
         pkValue = searchTitle(book, searchList);
         // 메인에서 검색리스트를 사용하기 위해 인자로 넘김
         // 책 pk 반환
         //나머지도 같은 방법
      } else if (actionBookSearch == 2) { // 2. 작가 검색
         pkValue = searchWriter(book, searchList);

      } else if (actionBookSearch == 3) { // 3. 출판사 검색
         pkValue = searchPublisher(book, searchList);

      } else if (actionBookSearch == 4) { // 4. 장르 검색
         pkValue = searchGenre(book, searchList);

      } else if (actionBookSearch == 5) { // 5. 전체 검색
         pkValue = search(book, searchList);

      }
      return pkValue;
   }

   public static int managerMenu() {
      System.out.println("======관리자 모드======");
      System.out.println("1. 책 등록");
      System.out.println("2. 총 매출");
      System.out.println("3. 전체 검색");
      System.out.println("4. 책 관리");
      System.out.println("5. 책 폐기");
      System.out.println("6. 베스트셀러 선정하기");
      System.out.println("0. 관리자모드 종료");
      System.out.print("메뉴를 선택하세요 : ");
      int actionManager = numCk(0, 6); // 관리자모드 메뉴 선택
      return actionManager;

   }

   public static void bookDelete(ArrayList<Book> book, ArrayList<Book> searchList, ArrayList<Book> bestSeller,ArrayList<Book> shoppingBasket) {
      int pkValue = searchMenu(book, searchList);
      if (pkValue >= 0) {
         System.out.println("폐기하시겠습니까? 1. 예 2. 아니오");
         System.out.print(">>> ");
         int actionDelete = numCk(1, 2);
         if (actionDelete == 1) {
            bookDeleteFunc(book, pkValue);
            bookDeleteFunc(bestSeller, pkValue);
            bookDeleteFunc(shoppingBasket, pkValue);
            System.out.println("책 폐기 완료");
         } else if (actionDelete == 2) {
            System.out.println("폐기를 취소합니다");
         }
      }
   }

   public static void bookDeleteFunc(ArrayList<Book> book, int pkValue) {
      for (int i = 0; i < book.size(); i++) {
         if (book.get(i).getId() == pkValue) {
            book.remove(i);
         }
      }
   }

   public static void bookUpdate(ArrayList<Book> searchList, int pkValue) {
      System.out.println("1. 재고 추가  2. 가격 변경");
      System.out.print(">>> ");
      int option, actionBookManegeOption = numCk(1, 2);
      if (actionBookManegeOption == 1) {
         System.out.print("추가할 재고 입력 : ");
         option = minCk(1);
         for (Book data : searchList) {
            if (data.getId() == pkValue) {
               data.addInventory(option);
            }
         }
      } else if (actionBookManegeOption == 2) {
         System.out.print("가격 입력 : ");
         option = minCk(0);
         for (Book data : searchList) {
            if (data.getId() == pkValue) {
               data.setPrice(option);
            }
         }
      }
   }

   public static void bestSellerAdd(ArrayList<Book> book, ArrayList<Book> searchList, ArrayList<Book> bestSeller) {
      int pkValue = -1;
      int cnt = 0;
      String type = null;
      Random rand = new Random();
      // 6. 베스트셀러 추출
      System.out.println("1. 랜덤으로 뽑기");// 1.랜덤으로 뽑기
      System.out.println("2. 직접 뽑기");// 2.직접뽑기
      System.out.print(">>> ");
      int actionBestSeller = numCk(1, 2);
      if (actionBestSeller == 1) {// 랜덤으로 뽑기 선택시
         int option = genreMenu();
         if (option == 1) {
            type = "코믹";
         } else if (option == 2) {
            type = "소설";
         }
         for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getGenre().equals(type)) {
               searchList.add(book.get(i));
               cnt++;
            }
         }
         int i = 0;
         int duplicateCnt = cnt;
         while (true) {

            int randNum = rand.nextInt(cnt);
            Boolean flag = true;
            pkValue = searchList.get(randNum).getId();
            for (i = 0; i < bestSeller.size(); i++) {
               if (bestSeller.get(i).getId() == pkValue) {
                  duplicateCnt--;
                  flag = false;
               }
            }
            if (duplicateCnt < 0) {
               pkValue = -1;
               System.out.println("배스트셀러로 선정 할 수 있는 책이 없습니다");
               break;
            }
            if (flag) {
               break;
            }
         }
      } else if (actionBestSeller == 2) {// 직접 뽑기 선택시
         pkValue = searchMenu(book, searchList);// 검색
      }

      if (pkValue >= 0) {// 베스트셀러 등록
         boolean flag = true;
         for (Book data : bestSeller) {
            if (data.getId() == pkValue) {
               System.out.println("이미 " + data.getBookTitle() + "은(는) 베스트셀러입니다");
               flag = false;
            }

         }
         if (flag) {
            for (Book data : book) {
               if (data.getId() == pkValue) {
                  System.out.println(data.getBookTitle() + "이(가) 베스트셀러로 선정 되었습니다 ");
                  bestSeller.add(data);
               }
            }
         }
      }
   }

   public static void cart(int pkValue, ArrayList<Book> searchList, ArrayList<Book> shoppingBasket) {
      // 선택한 책의 PK , 검색하여 나온 책 리스트, 장바구니 리스트
      int inventoryCnt = 0;// 장바구니에 담을 개수
      int mainInventory = 0;// 판매가능한 재고 수
      boolean flag = false;//장바구니에 해당 책이 있는지 확인하는 변수
      boolean bookFlag=false;//책이 리스트에 있는지 확인하는 변수
      for (Book data : searchList) {//재고를 확인을 위한 반복문
         if (data.getId() == pkValue) {//찾고자 하는 책이 있다면
            mainInventory = data.getInventory();//현재 재고를 변수에 저장
            bookFlag=true;
         }
      }
      if(!bookFlag) {//리스트에서 책을 찾지 못하면 리턴
         System.out.println("해당 책을 찾을 수 없습니다");
         return;
      }
      if (mainInventory <= 0) {//재고가 0보다 작거나 같으면 품절 출력후 리턴 
         System.out.println("품절 입니다");
         return;
      }

      System.out.println("장바구니에 담으시겠습니까? 1. 예  / 2. 아니오");
      System.out.print(">>> ");
      int aciton = numCk(1, 2);// 유효성
      if (aciton == 1) {
         System.out.println("몇 개 담으시겠습니까?");
         System.out.print(">>> ");
         int cnt = minCk(1);//장바구니에 담을땐 1개 이상이어야 하기 때문에 최솟값을 1로 설정

         for (Book data : shoppingBasket) {//장바구니 확인
            if (data.getId() == pkValue) {//장바구니에 해당 책의 PK가 있으면
               inventoryCnt = data.getInventory() + cnt;//장바구니에 담겨있는 물품 갯수와 추가로 넣고 싶은 물품 갯수를 더해 변수에 저장
               if (mainInventory - inventoryCnt >= 0) {//총 재고 수에서 장바구니에 총 들어가게될 숫자를 빼서 0보다 크거나 같다면
                  data.setInventory(inventoryCnt);//장바구니에 담겨있는 물품 갯수와 추가로 넣고 싶은 물품 갯수를 더한 값을 저장 
                  System.out.println("장바구니에 " + data.getBookTitle() + "이(가) 추가완료 되었습니다");
               } else {//0보다 작으면 출력
                  System.out.println("재고 보다 많이 담을 수 없습니다 ");
               }
               flag = true;
            }
         }
         if (!flag) {//장바구니에 해당 책이 담겨 있지 않으면
            int i;
            for (i = 0; i < searchList.size(); i++) {
               if (searchList.get(i).getId() == pkValue && mainInventory - cnt >= 0) {
                  // 해당 책의 객체를 찾고 총 재고에 장바구니에 담고 싶어 하는 갯수를 빼서 0보다 크거나 같으면 
                  // 장바구니에 담고 싶어 하는 갯수를 넣어 책 객체 생성
                  shoppingBasket.add(new Book(searchList.get(i).getId(), searchList.get(i).getPublisher(),
                        searchList.get(i).getWriter(), searchList.get(i).getPrice(),
                        searchList.get(i).getBookTitle(), searchList.get(i).getGenre(), cnt));
                  
                  System.out.println("장바구니에 " + searchList.get(i).getBookTitle() + "이(가) 추가완료 되었습니다");
                  break;
               }
            }
            //pkValue는 이미 유효성을 거쳐 내려왔기때문에 무조건 참으로 책 객체를 만들수있지만 
            if (i >= searchList.size()) {//반복문이 끝까지 돌고 끝났으면 총 재고수 때문에 실패한 것이기에 아래 문구 출력
               System.out.println("재고 보다 많이 담을 수 없습니다 ");
            }
         }

      } else {
         System.out.println("돌아갑니다.");
      }
   }

   public static int cartPrint(ArrayList<Book> shoppingBasket,ArrayList<Book> book) {
      int totalSales=0;
      if (shoppingBasket.size() <= 0) {//장바구니 크기가 0보다 작으면 없는 것
         System.out.println("장바구니가 비었습니다.");
      } else {
         for (Book data : shoppingBasket) {//장바구니에 담긴 데이터를 간단하게 출력
            System.out.println(data.getBookTitle() + " / 담은 개수 : " + data.getInventory());
         }
         //구매여부 물어보기
         System.out.println("1. 구매");
         System.out.println("2. 초기화");
         System.out.println("0. 돌아가기");
         System.out.print(">>> ");
         int actionSell = numCk(0, 2);
         if (actionSell == 0) {//돌아가기
            return 0;
         } else if (actionSell == 1) {//구매시
            totalSales += sellBook(shoppingBasket, book);//장바구니 ,책리스트 
         } else if (actionSell == 2) {//초기화
            shoppingBasket.clear();//리스트 초기화
         }
      }
      return totalSales;//구매결과 반환
      
   }
   public static int sellBook(ArrayList<Book> shoppingBasket, ArrayList<Book> book) {
	      int totalBookPrice = 0; // 구매할 책의 총 가격
	      for (Book data : shoppingBasket) {//장바구니에 담긴 객체들을 돌면서
	         totalBookPrice += (data.getPrice() * data.getInventory()); // 총 구매 가격을 증가 시킨다
	      }
	      while (true) {
	         System.out.println("총 가격은 " + totalBookPrice + "원 입니다.");
	         System.out.println("구매하시겠습니까? 1.예 / 2. 아니오 ");
	         System.out.print(">>> ");
	         int action = numCk(1, 2);
	         if (action == 2) {//아니오시 반복문 멈추고 바로 반환
	            totalBookPrice=0;
	            break;
	         } else if (action == 1) {
	            System.out.println("얼마를 내시겠습니까?");
	            System.out.print(">>> ");
	            int money = minCk(0);
	            if (money < totalBookPrice) { // 돈이 부족한 상황
	               System.out.println("돈이 부족합니다.");
	               continue;
	            } else {
	               System.out.println("구매 완료되었습니다.");
	               System.out.println("총 금액 : " + totalBookPrice + "원");
	               System.out.println("내신 금액 : " + money + "원");
	               int change = money - totalBookPrice; // 거스름돈
	               System.out.println("거스름돈 : " + change + "원");

	               // 장바구니랑 book이랑 키값 비교해서 같은게 있으면 재고감소
	               for (int i = 0; i < shoppingBasket.size(); i++) {
	                  for (Book data : book) {
	                     if (shoppingBasket.get(i).getId() == data.getId()) {
	                        int cnt = shoppingBasket.get(i).getInventory();
	                        data.sell(cnt);
	                     }
	                  }

	               }
	               shoppingBasket.clear();
	               break;
	            }
	         }

	      }
	      return totalBookPrice;

	   }
   public static void main(String[] args) {
      int PK = 0;
      int action, actionManager; // 메뉴 선택 action
      int pkValue; // detail함수 -> searchList PK값
      int totalSales = 0; // 총 매출
      ArrayList<Book> book = new ArrayList<Book>();
      ArrayList<Book> searchList = new ArrayList<Book>();
      ArrayList<Book> bestSeller = new ArrayList<Book>();
      ArrayList<Book> shoppingBasket = new ArrayList<Book>();
      PK = dummy(book, PK);

      while (true) {
         action = mainMenu();
         if (action == 0) { // 프로그램 종료
            System.out.println("프로그램이 종료되었습니다.");
            break;
         } else if (action == 1) { // 1. 책 검색
            pkValue = searchMenu(book, searchList);// input : 북리스트,검색리스트
            // output : 검색후 나온 정수형 책의 PK를 반환, 검색리스트는 call by reference 이기 때문에 따로 반환을 하지 않아도 된다
            if (pkValue >= 0) {// PK는 처음에 0로 초기화를 해두었기에 무조건 0보다 크거나 같기에 이외의 값이 있을 경우 돌아가기로 판단
               cart(pkValue, searchList, shoppingBasket);//검색리스트를 인자로 넘긴 이유 book보다 searchList가 반복 횟수가 적을 확률이 높기 때문이다[예상질문답변]
               //intput : 책의 PK, 검색 리스트,장바구니 리스트
               //리턴이 없는 이유 shoppingBasket는 call by reference 이기 때문에 따로 반환을 하지 않아도 된다
            }
         } else if (action == 2) { // 2. 장르별 베스트셀러 
            searchGenre(bestSeller, searchList);//장르별 베스트셀러이기 때문에 장르 출력 함수를 재사용하여 베스트셀러를 출력한다
         } else if (action == 3) {// 3. 장바구니 및 구매
            totalSales +=cartPrint(shoppingBasket,book);//input : 장바구니 , 책리스트 
            //output : 구매완료된 정수 금액 반환 
            //장바구니 확인후 구매를 거쳐 총매출 저장
         } 
         else if (action == 19991001) { // 관리자모드
            while (true) {
               actionManager = managerMenu();
               if (actionManager == 0) { // 관리자모드 종료
                  break;
               } else if (actionManager == 1) { // 1. 책 등록[관리자]
                  bookAdd(book, PK++);
               } else if (actionManager == 2) { // 2. 총 매출[관리자]
                  System.out.println("총 매출은 " + totalSales + "원 입니다.");
               } else if (actionManager == 3) { // 3. 전체 검색[관리자]
                  search(book, searchList);
               } else if (actionManager == 4) { // 4. 책 관리[관리자]
                  pkValue = searchMenu(book, searchList);
                  if (pkValue >= 0) {
                     bookUpdate(searchList, pkValue);
                  }
               } else if (actionManager == 5) { // 5. 책 폐기[관리자]
                  bookDelete(book, searchList, bestSeller,shoppingBasket);
               } else if (actionManager == 6) { // 6. 베스트셀러 선정[관리자]
                  bestSellerAdd(book, searchList, bestSeller);
               }
               searchList.clear();
            }
         }
         searchList.clear();
      }
   }
}