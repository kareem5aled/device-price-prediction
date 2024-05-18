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

# Install Required Python Packages
pip install -r requirements.txt

# Start the Flask Application
python app.py

