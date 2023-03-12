package bankmangement.pack;

public class TestBankMenu {

	public static void main(String[] args) {
		Login login=new Login();
		login.check();
		BankMenu bankmenu=new BankMenu();
		bankmenu.mainMenu();

	}

}
