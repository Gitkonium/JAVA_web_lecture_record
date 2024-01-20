package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.action.AlertAction;
import controller.action.ChangeNameAction;
import controller.action.ErrorAction;
import controller.action.GobackAction;
import controller.action.JoinPageAction;
import controller.action.LoginAction;
import controller.action.LoginPageAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.MemberDeleteAction;
import controller.action.MypageAction;
import controller.action.ReplyDeleteAction;
import controller.action.ReplyInsertAction;
import controller.action.ReplySelectOneAction;
import controller.action.ReplyUpdateAction;
import controller.action.TestPageAction;

// POJO
// 사용자의 요청정보에 알맞는 Controller(==Action 객체)를 반환
public class HandlerMapper {
	private Map<String,Action> mappings;
	
	public HandlerMapper() {
		mappings=new HashMap<String,Action>();
		
		mappings.put("/main.do", new MainAction());
		mappings.put("/login.do", new LoginAction());
		mappings.put("/joinPage.do", new JoinPageAction());
		mappings.put("/logout.do", new LogoutAction());
		mappings.put("/testPage.do", new TestPageAction());
		mappings.put("/loginPage.do", new LoginPageAction());
		mappings.put("/mypage.do", new MypageAction());
		mappings.put("/replySelectOne.do", new ReplySelectOneAction());
		mappings.put("/replyInsert.do", new ReplyInsertAction());
		mappings.put("/replyUpdate.do", new ReplyUpdateAction());
		mappings.put("/replyDelete.do", new ReplyDeleteAction());
		mappings.put("/changeName.do", new ChangeNameAction());
		mappings.put("/memberDelete.do", new MemberDeleteAction());
		mappings.put("/alert.do", new AlertAction());
		mappings.put("/goback.do", new GobackAction());
		mappings.put("/error.do", new ErrorAction());
	}
	
	public Action getAction(String commend) {
		return mappings.get(commend);
	}
}
