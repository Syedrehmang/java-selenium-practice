
public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		methods Data = new methods();
		String name = Data.getUserName();
		System.out.println(name);
		Data.getUserName();

	}

	public String getUserName() {
		System.out.println("Syed");
		return "Rehman";

	}

}
