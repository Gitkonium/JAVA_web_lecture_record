package test;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 웹 크롤링
//  스크랩핑이란?
//   데이터를 많~이 모으는 작업
//  크롤링이란?
//   데이터를 정제하고 원하는 형태로 가공하는 작업
// => 데이터를 많이 모아서, 원하는 output으로 정제·가공하는 작업
// 빅데이터에서 많이 활용되는 기술
//  : 웹으로부터 데이터를 많이 모아서 가공할 예정

public class Test01 {
	public static void main(String[] args) {

		// 크롤링할 타켓 웹 페이지를 알아야한다!
		// "주소"를 알아야한다!
		// "URL"
		
		final String url="http://www.cgv.co.kr/movies/?lt=1&ft=0";
		
		// 말 그대로 해당 URL은 "페이지"로 구성되어있음!
		// 개발자가 페이지를 코드로 작성하면,
		// 웹 브라우저라는 sw가 코드(페이지)를 해석해서 UI로 구현해서 보여줌
		
		// 웹 페이지 정보를 JAVA에서는 Document라고 함
		Document doc=null;
		// 우리가 사용할 웹 페이지 정보(Document) 타입은 JAVA에서 기본제공 x
		// 외부로부터 Document를 지원해줄수있는 .jar파일을 추가해야함!
		//  == ojdbc6.jar
		// jsoup.jar
		
		try {
			doc=Jsoup.connect(url).get();
			// Jsoup.connect(url) => connection 객체가 반환됨
			// connection.get() => document 객체가 반환됨
			// JDBC와 유사
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/////System.out.println(doc);
		
		// 내가 확인하고 싶은 영화 제목은
		// <strong class="title">로 되어있다!
		Elements elems=doc.select("strong.title");
		
		// 웹 페이지는 "요소"들로 이루어져있음!
		
		
		
		
		// Elements 는 일종의 ResultSet 역할
	
		// 이터레이터
		// 복사체
		// 컬렉션의 한 종류
		Iterator<Element> itr=elems.iterator();
		// ResultSet 처럼 1개씩 보여줄수가없어서.
		// 1개씩 보여주려고 itr 를 사용함!
		
		while(itr.hasNext()) {
			String str=itr.next().text();
			
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
