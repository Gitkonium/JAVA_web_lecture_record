package model.dto;

public class ReplyDTO {
	private int rid;
	private String writer;
	private String content;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rid=" + rid + ", writer=" + writer + ", content=" + content + "]";
	}
}
