# 🏥 Gestion Cabinet Médical (Medical Office Management System)

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow)
![License](https://img.shields.io/badge/License-MIT-blue)

## 🎯 Overview

A robust Java-based medical office management system designed to streamline healthcare administration, patient management, and medical record keeping. This application provides healthcare professionals with tools to efficiently manage their practice while maintaining patient data security and accessibility.

## ✨ Key Features

### 👤 Patient Management
- Create and maintain detailed patient profiles
- Update patient information in real-time
- Search and filter patient records
- Track patient history and medical antecedents
- Manage patient contact information

### 📅 Appointment Management
- Schedule new appointments with conflict prevention
- Modify existing appointments
- Cancel and reschedule functionality
- View daily/weekly appointment calendar
- Smart time slot management

### 📋 Medical Records Management
- Generate and maintain digital medical records
- Create and store consultation notes
- Issue digital prescriptions (`Ordonnance`)
- Generate medical certificates (`CertificatMedical`)
- Track patient consultation history

## 🔧 Technical Architecture

### Project Structure
```
src/
├── CabinetMedicale/
│   ├── App.java                # Application entry point
│   ├── gestion/                # Management modules
│   │   ├── gestionDossierMedical.java
│   │   ├── gestionPatient.java
│   │   └── gestionRDV.java
│   └── models/                 # Data models
│       ├── CertificatMedical.java
│       ├── Colors.java
│       ├── consultation.java
│       ├── DossierMedical.java
│       ├── Ordonnance.java
│       ├── Patient.java
│       └── RendezVous.java
```

## 🛠️ Technologies & Tools

- **Core Technology**: Java 17+
- **Architecture**: Object-Oriented Design
- **Data Storage**: File-based persistence
- **User Interface**: Console-based (GUI version in development)

## ⚙️ Prerequisites

- Java Development Kit (JDK) 17 or higher
- Any modern Java IDE:
  - Visual Studio Code
  - IntelliJ IDEA
  - Eclipse

## 📥 Installation

1. Clone the repository:
   ```powershell
   git clone <repository-url>
   cd Gestion-Cabinet-Medical
   ```

2. Compile the source code:
   ```powershell
   javac -d bin src/**/*.java
   ```

3. Run the application:
   ```powershell
   java -cp bin CabinetMedicale.App
   ```

## 🚀 Getting Started

1. Launch the application using the steps above
2. Navigate through the main menu options:
   - Patient Management
   - Appointment Scheduling
   - Medical Records
   - Consultation Management

## 🔄 Future Enhancements

- Complete GUI implementation
- Database integration for improved data management
- Enhanced reporting capabilities
- Multi-language support
- Cloud backup integration
- Electronic prescription system

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

<p align="center">
  Made with ❤️ for better healthcare management
</p>
