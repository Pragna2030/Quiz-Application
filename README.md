# 🧠 Quiz Application (Spring Boot)

A full-stack Quiz Application built using Spring Boot that allows users to create, manage, and attempt quizzes with real-time scoring and result evaluation.

---

## 🚀 Features

* Create and manage quizzes
* Add, update, and delete questions
* Attempt quizzes with multiple-choice questions
* Automatic score calculation
* RESTful APIs for all operations
* Clean layered architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Language:** Java
* **Database:** MySQL / H2
* **ORM:** Hibernate (JPA)
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 📂 Project Structure

```
com.acciojob.QuizApplication
│
├── Controller        # Handles API requests
├── Service           # Business logic
├── Repository        # Database interaction
├── Entity            # Database models
├── DTO               # Data transfer objects
```

---

## ⚙️ API Endpoints

### 🎯 Quiz APIs

* `POST /quiz/create` → Create a new quiz
* `GET /quiz/{id}` → Get quiz questions
* `POST /quiz/submit/{id}` → Submit quiz & get score

### ❓ Question APIs

* `POST /question/add` → Add question
* `GET /question/all` → Get all questions

---

## ▶️ How to Run

1. Clone the repository

```
git clone https://github.com/your-username/your-repo-name.git
```

2. Open in IntelliJ

3. Configure database in `application.properties`

4. Run the application

5. Access APIs via Postman or browser

---

## 📊 Example Response

```
Score: 4/5
```

---

## 💡 Future Enhancements

* Add authentication (JWT)
* UI with React
* Timer-based quizzes
* Leaderboard system




