package bankomat;
import java.io.IOException;

public class Bankomat {

	public static void main(String[] args) throws IOException {
		Menu optionMenu = new Menu();
		introduction();
		optionMenu.mainMenu();
	}

	public static void introduction() {
		System.out.println("Welcome to the ATM Project!");
	}
}