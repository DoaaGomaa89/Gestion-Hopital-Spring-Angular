# 🏥 Hospital Management Application

Welcome to the **Hospital Management Application**—a comprehensive, secure system with both **Spring Boot** backend and **Angular** frontend. This application is tailored for managing complex relationships within a healthcare environment, facilitating interactions between **Hospitals**, **Doctors**, **Patients**, and **Appointments**. Equipped with secure, role-based access and a user-friendly interface, it provides seamless healthcare management and integration capabilities.

---

## 🌟 Key Features

- **Entity Relationship Modeling**: Manage relationships between hospitals, doctors, patients, and appointments with ease.
- **Role-Based Security**: Protect data through role-based permissions, JWT, and Keycloak, ensuring secure API and frontend access.
- **Comprehensive CRUD Operations**: Effortlessly perform Create, Read, Update, and Delete actions on all entities.
- **Data Persistence**: Uses **JPA** for consistent data storage and retrieval.
- **API and Frontend Ready**: Optimized for frontend interactions and integration with detailed endpoints and user interfaces.

---

## 🚀 Getting Started

1. **Clone the Repositorie**:
   - Application : `git clone https://github.com/aminebkk/Gestion-Hospital-Spring-Angular.git`

   
2. **Set up the Backend and Frontend**: Follow instructions in each repository’s README for setting up locally.

---

## 🛠️ Project Structure

### Backend
- **Controllers**: Handles API requests and responses for each entity.
- **Services**: Contains the logic for managing entities.
- **Repositories**: Utilizes JPA repositories for database interactions.
- **Security Configuration**: JWT and Keycloak role-based security for endpoint protection.

### Frontend (Angular)
- **Components**: Modular Angular components for each feature.
- **Services**: Handles API interactions between frontend and backend.
- **Routing**: Smooth navigation between features like hospitals, doctors, and appointments.
- **Styling**: Modern UI elements with Angular Material for a clean look.

---

## 📚 API and UI Documentation

Both the backend API and frontend interface support CRUD operations on **Hospitals**, **Doctors**, **Patients**, and **Appointments**. See the **API documentation** for backend endpoint details, and explore the intuitive Angular interface to manage data seamlessly.

---

## 🔧 Technologies Used

- **Backend**: Spring Boot, Spring Security (OAuth2, Keycloak), JPA/Hibernate, MySQL, JWT
- **Frontend**: Angular, Angular Material, TypeScript, JWT-based Authentication

---

## 🤝 Contributions

Contributions are welcome! To contribute:

1. **Fork** the repositories.
2. **Create a new branch** for your feature.
3. **Submit a pull request**.

---

## 📖 JSON Response Example

The following JSON response shows the nested structure for retrieving hospitals, along with associated doctors, patients, and appointments. This is designed for both backend data processing and frontend UI rendering.

```json
[
    {
        "id": 1,
        "name": "CHU",
        "location": "Oujda City",
        "capacity": 200,
        "doctors": [
            {
                "id": 1,
                "nom": "Dr Amara",
                "dateNaissane": "2001-02-02",
                "specialite": "Generalist",
                "patients": [
                    {
                        "id": 1,
                        "nom": "Amine",
                        "dateNaissane": "1990-01-01",
                        "malade": true,
                        "score": 75,
                        "appointments": [
                            {
                                "id": 1,
                                "title": "Follow-up Appointment",
                                "description": "Ask the Doctor",
                                "date": "2024-11-05"
                            }
                        ]
                    }
                ]
            }
        ]
    }
]
