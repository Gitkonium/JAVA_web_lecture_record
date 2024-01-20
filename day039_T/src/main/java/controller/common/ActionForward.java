package controller.common;

public class ActionForward {

	private String path; // 어디로 가야하는지 == 경로
	private boolean redirect; // 어떻게 갈지 == 리다이렉트 or 포워드
	
	public ActionForward() {
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

}
