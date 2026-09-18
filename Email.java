import java.security.SecureRandom;
import java.util.Scanner;

public class Email {

	// FIX: magic numbers/values converted to static final constants.
	// They never change and don't belong to any single object, so they're
	// shared at the class level instead of being copied into every instance.
	private static final int DEFAULT_PASSWORD_LENGTH = 8;
	private static final int CODE_LENGTH = 5;
	private static final String COMPANY = "drngpit.ac.in";

	// FIX: missing 'D' added back into the character pool.
	private static final String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
	private static final String DIGIT_CHARS = "1234567890";

	// FIX: SecureRandom instead of Math.random(). Math.random() is predictable
	// enough that it should never be used to generate passwords or codes.
	private static final SecureRandom RANDOM = new SecureRandom();

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String Vcode;
	private String name;

	// FIX: the constructor now accepts the Scanner created in EmailApp instead
	// of creating its own. Only one Scanner should ever be open on System.in.
	public Email(String firstName, String lastName, Scanner sc) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Kindly ! Enter department for email creation dear " + this.firstName + " " + this.lastName);

		this.department = setDepartment(sc);
		System.out.println("Department:" + this.department);

		this.password = generateRandomString(PASSWORD_CHARS, DEFAULT_PASSWORD_LENGTH);
		System.out.println("New Password :" + this.password);

		// FIX: uses this.firstName/this.lastName consistently instead of the
		// bare constructor parameters.
		this.name = this.firstName + this.lastName;

		this.Vcode = generateRandomString(DIGIT_CHARS, CODE_LENGTH);
		System.out.println("Your verification code : " + this.Vcode);

		// FIX: consistent use of "this." on the final assignment too.
		this.email = this.name.toLowerCase() + "." + this.department + "@" + COMPANY;
		System.out.println("Official mail :" + this.email);
	}

	// FIX: takes the shared Scanner as a parameter (no more "new Scanner(System.in)"
	// created inside this method).
	// FIX: loops until valid input instead of silently returning "" on bad input,
	// which used to produce a broken email like "name.@drngpit.ac.in".
	private String setDepartment(Scanner sc) {
		while (true) {
			System.out.println("Enter the department Id\nSales : 1\nDevelopment : 2\nAccounting : 3");
			int dep = sc.nextInt();
			if (dep == 1) {
				return "sales";
			} else if (dep == 2) {
				return "dev";
			} else if (dep == 3) {
				return "acc";
			} else {
				System.out.println("Invalid department Id. Please enter 1, 2, or 3.");
			}
		}
	}

	// FIX: replaces the old duplicated randomPass() and vcode() methods with a
	// single reusable method (DRY) that works for any character pool and length.
	private String generateRandomString(String charPool, int length) {
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			int randomIndex = RANDOM.nextInt(charPool.length());
			result[i] = charPool.charAt(randomIndex);
		}
		return new String(result);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	// FIX: basic validation added. Previously this accepted absolutely anything,
	// including null or an empty string, with no check at all.
	public void setEmail(String email) {
		if (email == null || email.trim().isEmpty()) {
			System.out.println("Email cannot be empty. Update rejected.");
			return;
		}
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// FIX: firstName had both a getter and setter, but lastName had neither.
	// Added for consistent encapsulation across the class.
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVcode() {
		return Vcode;
	}

	public String getDept(String dep) {
		if (dep.equals("dev")) {
			return "Developers";
		} else if (dep.equals("acc")) {
			return "Accounts";
		} else if (dep.equals("sales")) {
			return "Sales";
		}
		return "";
	}

	public String showInfo() {
		return "Name : " + name + "\nOfficial email : " + email + "\nDepartment : " + getDept(department);
	}
}