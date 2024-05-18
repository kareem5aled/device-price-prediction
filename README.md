# Device Price Classification System

## Project Overview
This project integrates a machine learning model, deployed via a Flask application, with a Spring Boot backend to predict device prices based on their specifications. It includes an analysis phase conducted in a Jupyter notebook which outlines the methodology for model training and feature engineering.

## Getting Started
Follow these instructions to set up the project on your local machine for development and testing purposes.

### Prerequisites
Ensure you have the following installed:
- Python 3.11
- Flask
- NumPy
- scikit-learn
- Pickle
- Java 17
- Maven

### Installation

#### Flask Application
The Flask application hosts the machine learning model for predicting device prices.


```bash
# Navigate to the Flask App Directory
cd flask-app


# Start the Flask Application
python app.py
```

#### Spring Boot Application
The Spring Boot application manages data operations and communicates with the Flask app to obtain predictions.

```bash
# Navigate to the Spring Boot App Directory
cd device-api

# Build the Project with Maven
./mvnw clean install

# Run the Spring Boot Application
./mvnw spring-boot:run
```

### Project Structure 
```
DevicePriceClassification/
│
├── flask-app/                # Flask application directory
│   ├── app.py                # Main Flask application file
│   └── model/                # Contains ML model and scaler
│       ├── best_model.pkl    # Serialized machine learning model
│       └── scaler.pkl        # Serialized scaler
│
├── springboot-app/           # Spring Boot application directory
│   ├── src/                  # Source files
│   │   ├── main/
│   │   │   ├── java/         # Java source files
│   │   │   └── resources/    # Resources like application.properties
│   │   └── test/             # Java test files
│   ├── pom.xml               # Maven configuration file
│   └── mvnw                  # Maven wrapper script
│
├── notebook/                 # Jupyter notebooks and data
│   ├── Devices_Price_Classification_System.ipynb        # Jupyter notebook with analysis
│   ├── data/                 # Dataset directory
│   │   ├── train.xlsx        # Training data file
│   │   └── test.xlsx         # Test data file
│   └── outputs/              # Outputs from analysis
│       ├── test_predictions.xlsx        # predicted price ranges from testset
│       ├── best_model.pkl    # Serialized machine learning model
│       └── scaler.pkl        # Serialized scaler
│
└── README.md                 # This README file
```

