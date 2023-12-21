package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public static ArrayList<BoardDTO> sample() {
		ArrayList<BoardDTO> datas=new ArrayList<BoardDTO>();
		final String url="http://www.cgv.co.kr/movies/?lt=1&ft=0";
		Document doc=null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elems=doc.select("strong.title");
		Iterator<Element> itr=elems.iterator();
		while(itr.hasNext()) {
			BoardDTO data=new BoardDTO();
			String str=itr.next().text();
			///System.out.println(str);
			data.setTitle(str);
			datas.add(data);
		}
		return datas;
	}

}
