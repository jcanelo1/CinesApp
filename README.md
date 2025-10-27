🎭 Theatre Booking App

**Created in 2023** — A simple Android app for booking theatre tickets, built with Android Studio using Java and SQLite. This project demonstrates fundamental Android development skills, including user authentication, database integration, input validation, and basic UI handling.  

> **Note:** This is a partially completed project due to time constraints, but it includes functional login, registration, and ticket booking features.

---

## 📝 Features

### ✅ Completed Features
- **User Registration**
  - Users can register with full name, username, email, and password.
  - Input validation ensures all fields are filled.
  - Data is stored in a local SQLite database.

- **User Login**
  - Users can log in using a username and password.
  - Provides real-time feedback via Toast messages for successful or failed login.
  - Authentication currently uses SQLite-stored credentials.

- **Ticket Booking**
  - Users can book tickets for shows by entering their name, email, show title, and quantity.
  - Tickets are stored in a SQLite database.
  - Input validation ensures no fields are left empty.

- **Database Integration**
  - Single SQLite database managing both users and tickets.
  - Provides methods to add users, check login credentials, and book tickets.

- **UI & User Feedback**
  - Basic UI implemented with EditText, TextView, Button, and MaterialButton.
  - Toast notifications provide user feedback for all actions.

---

### ⚙️ Project Structure

| Activity | Description |

| `MainActivity` | Home screen placeholder and navigation hub. |
| `LoginPage` | Handles user login with validation and feedback. |
| `RegistrationActivity` | Handles user registration and stores new users in SQLite. |
| `BuyTicketActivity` | Allows users to book tickets and stores booking data in SQLite. |
| `DatabaseHelper` | Manages SQLite database creation, upgrades, and CRUD operations for users and tickets. |

---

### 🧩 Database Structure

#### **User Table**
| Column   | Type  | Description                    |
|----------|-------|--------------------------------|
| fullname | TEXT  | User's full name               |
| username | TEXT  | Unique username (PRIMARY KEY)  |
| email    | TEXT  | User's email                   |
| password | TEXT  | User's password (plain text)   |

#### **Ticket Table**
| Column   | Type    | Description                     |
|----------|---------|---------------------------------|
| name     | TEXT    | Name of ticket purchaser        |
| email    | TEXT    | Email of ticket purchaser       |
| quantity | INTEGER | Number of tickets booked        |
| title    | TEXT    | Title of the show/movie         |

---

### ⚠️ Known Limitations
- Passwords are stored in plain text (no encryption).  
- Login system uses SQLite only; no external authentication.  
- Basic UI design; no advanced navigation or Material Design components.  
- Ticket booking does not check for seat availability or showtimes.  
- App navigation between activities is minimal.  

---

### 🚀 Future Improvements
- Implement **hashed passwords** for security.  
- Add **email/username uniqueness checks** during registration.  
- Enhance UI with **Material Design** and RecyclerViews for ticket lists.  
- Add **seat selection and showtimes** functionality.  
- Implement **persistent login sessions** and better navigation.  
- Consider **Room database or Firebase** for scalability and cloud sync.  

---