package model;

import java.io.Serializable;

public class Remind implements Serializable {

	private String remind; //リマインド内容

	//シリアライズ要件追加(2020/05/07[kurahashi])
	private String user_id; //ユーザID
	private String category; //カテゴリ
	private String created_date; //作成日
	private String target_date; //目標達成日
	private String important_mark; //重要マーク

	public Remind(String remind, String category, String target_date, String important_mark) { // (2020/05/07[kurahashi])
		this.remind = remind;
		this.category = category;
		this.target_date = target_date;
		this.important_mark = important_mark;
	}

	public Remind(String user_id, String remind, String category, String created_date, String target_date, String important_mark) { //setterの役割を持つコンストラクタ (202005/07[kurahashi])
		this.remind = remind;
		this.user_id = user_id;
		this.category = category;
		this.created_date = created_date;
		this.target_date = target_date;
		this.important_mark = important_mark;
	}

	public String getRemind() {
		return remind;
	}

	//getter追加(2020/05/07[kurahashi])
	public String getUser_id() {
		return user_id;
	}

	public String getCategory() {
		return category;
	}

	public String getCreated_date() {
		return created_date;
	}

	public String getTarget_date() {
		return target_date;
	}

	public String getImportant_mark() {
		return important_mark;
	}




}
