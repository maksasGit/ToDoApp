
public class Main {
	public static void main(String[] args) {
		App mainApp = new App();
		try {
			mainApp.run();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
