package model;

import java.util.List;

import dao.RemindDAO;

public class PostRemindLogic {

	/*
	public void execute(Remind remindLatest, List<Remind> remindList) {

		remindList.add(0, remindLatest); //送信されたリマインドをリマインドリストの先頭に追加

	}
	*/

	//execute()メソッド書き換え(2020/05/07[kurahashi])
	public List<Remind> execute() {
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.findAll();

		return remindList;
	}



	public void create(Remind remindLatest) {

		RemindDAO dao = new RemindDAO();
		dao.create(remindLatest);

	}

}
