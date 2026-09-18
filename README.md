# Email Generator

A simple Java console application that generates organization email accounts for new employees. It collects a user's name and department, creates a random password and verification code, and provides a menu for viewing or updating account details.

## Features

- Generates an email address using the format `<firstname><lastname>.<department>@drngpit.ac.in`.
- Supports three departments:
  - `1` — Sales (`sales`)
  - `2` — Development (`dev`)
  - `3` — Accounting (`acc`)
- Generates an 8-character random password using `SecureRandom`.
- Generates a 5-digit verification code.
- Displays account information.
- Allows the user to change the email address.
- Allows the user to change or disclose the password after verification.
- Validates department selection and prevents empty email updates.

## Project structure

```text
.
├── Email.java       # Account model, email generation, password generation, and accessors
├── EmailApp.java    # Console entry point and interactive menu
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal or command prompt

Check that Java is installed:

```bash
java -version
javac -version
```

## How to run

Clone the repository and move into the project directory:

```bash
git clone https://github.com/shajiyakhan1309/Email-generator.git
cd Email-generator
```

Compile the Java source files:

```bash
javac Email.java EmailApp.java
```

Run the application:

```bash
java EmailApp
```

The application will ask for a first name, last name, and department. After the account is created, use the displayed menu to view information, change the email, update the password, disclose the password, or exit.

## Example email format

For a user named `Asha Khan` in Development, the generated address follows this pattern:

```text
ashakhan.dev@drngpit.ac.in
```

The exact password and verification code are generated randomly each time the application runs.

## Implementation notes

- `EmailApp` manages console input and the interactive menu.
- `Email` stores account information and generates credentials.
- `SecureRandom` is used instead of `Math.random()` for password and verification-code generation.
- The organization domain and credential lengths are defined as constants in `Email.java`.

## Security note

This project is intended for learning and console demonstrations. It stores credentials only in memory, prints the generated password, and includes an option to disclose the password after verification. Do not use it as-is for a production identity or email-management system.

## License

No license has been specified for this project yet.
