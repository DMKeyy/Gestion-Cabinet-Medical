# Gestion Cabinet Médical
- **Drive contenant le rapport et le ppt**:
https://drive.google.com/drive/folders/1hRzR6NZw8QMh4pNEDSHgpos_6FFWFcKp?usp=sharing
- **Version Interface graphique toujours en test** : 
https://github.com/DMKeyy/GCM-avecInterface
## Overview

This project is a Java application for managing a medical office. It includes functionalities for managing patients, appointments, and medical records.

## Features

- **Patient Management**: Add, modify, delete, and view patient information.
- **Appointment Management**: Schedule, modify, and cancel appointments.
- **Medical Record Management**: Add, modify, and view consultations, prescriptions, and medical certificates.

## Folder Structure

The workspace contains the following folders:

- `src`: Contains the source code of the application.
  - `CabinetMedicale`: Main package containing the application entry point and utility classes.
  - `gestion`: Package containing classes for managing patients, appointments, and medical records.
  - `models`: Package containing data models such as `Patient`, `Consultation`, `Ordonnance`, and `CertificatMedical`.
- `lib`: Folder to maintain dependencies.
- `bin`: Folder where compiled output files are generated.

### Prerequisites

- Java 17 or higher
- A Java IDE (e.g., Visual Studio Code, IntelliJ IDEA, Eclipse)


## Installation

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the source code:
   ```bash
   javac -d bin src/**/*.java
4. Run the application:
   ```bash
   java -cp bin CabinetMedicale.Main
