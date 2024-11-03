# 🏥 Hospital Management Backend Application

Welcome to the **Hospital Management Backend Application**—an advanced, secure backend system built with **Spring Boot**, designed to manage and simplify complex relationships within a healthcare environment. This application models interactions between entities like **Hospitals**, **Doctors**, **Patients**, and **Appointments**. With robust data handling and secure, role-based access, it’s optimized for seamless integration with frontend applications or other healthcare systems.

---

## 🌟 Key Features

- **Entity Relationship Modeling**: Efficiently manage relationships between hospitals, doctors, patients, and their appointments.
- **Role-Based Security**: Protect sensitive data with role-based permissions using JWT and Keycloak, ensuring secure API access.
- **Comprehensive CRUD Operations**: Perform Create, Read, Update, and Delete actions on all entities for seamless data management.
- **Data Persistence**: Uses **JPA** to reliably store and retrieve data.
- **API-Ready Design**: Ready for frontend or system integration with detailed endpoints for all entities.

---

## 🚀 Getting Started

1. **Clone the Repository**: Clone this repository to your local machine.
   ```bash
   git clone https://github.com/aminebkk/hospital-management-backend.git

## 🛠️ Project Structure

- **Controllers**: Manages API requests and responses for each entity.
- **Services**: Contains business logic for handling operations.
- **Repositories**: Uses JPA repositories for database interactions.
- **Security Configuration**: Role-based security implemented with **JWT** and **Keycloak** for endpoint protection.

---

## 📚 API Documentation

The API is designed with REST principles and supports all CRUD operations on entities such as **Hospitals**, **Doctors**, **Patients**, and **Appointments**. See the **API documentation** for details on endpoints, parameters, and JSON response structures.

---

## 🔧 Technologies Used

- **Spring Boot**
- **Spring Security** with OAuth2 and Keycloak integration
- **JPA / Hibernate** for ORM
- **MySQL** database
- **JWT** for token-based authentication

---

## 🤝 Contributions

Contributions are encouraged! If you'd like to contribute:

1. **Fork** the repository.
2. **Create a new branch** for your feature.
3. **Submit a pull request**.



## 📖 JSON Response Example

The following JSON illustrates the nested structure for retrieving hospitals, complete with doctors, patients, and appointments. This structure is ideal for frontends needing complex healthcare data:

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
    },
    {
        "id": 2,
        "name": "el Farabi",
        "location": "Oujda City",
        "capacity": 200,
        "doctors": [
            {
                "id": 2,
                "nom": "Dr Boushaba",
                "dateNaissane": "2001-02-02",
                "specialite": "Generalist",
                "patients": [
                    {
                        "id": 2,
                        "nom": "Tariq",
                        "dateNaissane": "1990-01-01",
                        "malade": true,
                        "score": 75,
                        "appointments": [
                            {
                                "id": 2,
                                "title": "Follow-up Appointment",
                                "description": "Talk with the doctor About a Fever",
                                "date": "2024-12-05"
                            },
                            {
                                "id": 52,
                                "title": "Follow-up Appointment",
                                "description": "Take an advice from the doctor",
                                "date": "2024-12-06"
                            }
                        ]
                    }
                ]
            }
        ]
    }
]
