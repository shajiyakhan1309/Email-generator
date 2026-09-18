
import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Generate Organization's Email ==>");
			System.out.println("Generating the email...");
			System.out.println("Enter firstname :");
			String first = sc.nextLine();
			System.out.println("Enter Lastname :");
			String second = sc.nextLine();

			Email em = new Email(first, second, sc);

			boolean running = true;
			while (running) {
				System.out.println("\n1 : Information ");
				System.out.println("2 : Change Email");
				System.out.println("3 : Change Password");
				System.out.println("4 : Disclose Password");
				System.out.println("5 : Exit");
				System.out.println("Enter operation code :");
				int choice = sc.nextInt();
				sc.nextLine(); 

				switch (choice) {
					case 1:
						System.out.println(em.showInfo());
						break;

					case 2:
						System.out.println("Enter alternate email prefix :");
						String alt = sc.nextLine();
						em.setEmail(alt + "@drngpit.ac.in");
						break;

					case 3:
						System.out.println("Enter the verification code :");
						String codeForPasswordChange = sc.nextLine();
						if (codeForPasswordChange.equals(em.getVcode())) {
							System.out.println("Enter alternate password :");
							String newPassword = sc.nextLine();
							em.setPassword(newPassword);
							
							System.out.println("Password updated successfully !!!");
						} else {
							System.out.println("Please Enter valid verification code !!!");
						}
						break;

					case 4:
						System.out.println("Password disclose warning !!!");
						System.out.println("Enter the verification code :");
						String codeForDisclose = sc.nextLine();
						if (codeForDisclose.equals(em.getVcode())) {
							System.out.println("Your password : " + em.getPassword());
						} else {
							System.out.println("Please Enter valid verification code !!!");
						}
						
						break;

					case 5:
						System.out.println("Have a great day ahead ! BYE ");
						running = false;
						break;

					default:
						
						System.out.println("Invalid option. Please enter 1-5.");
				}
			}
		} finally {
			sc.close();
		}
	}
}