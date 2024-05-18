from flask import Flask, request, jsonify
import pickle
import numpy as np

app = Flask(__name__)

# Load your trained model (ensure the model is saved as a pickle file)
with open('model/best_model.pkl', 'rb') as model_file:
    model = pickle.load(model_file)

# Load the scaler
with open('model/scaler.pkl', 'rb') as scaler_file:
    scaler = pickle.load(scaler_file)

# Exception handling for better error messages
@app.errorhandler(Exception)
def handle_exception(e):
    return jsonify(error=str(e)), 500

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()

    # Create new feature: px_area
    data['pxArea'] = data['pxWidth'] * data['pxHeight']
    
    # Extract features from data
    features = [
        data['batteryPower'], data['blue'], data['clockSpeed'],
        data['dualSim'], data['fc'], data['fourG'], data['intMemory'],
        data['mDep'], data['mobileWt'], data['nCores'], data['pc'],
        data['pxHeight'], data['pxWidth'], data['ram'], data['scH'],
        data['scW'], data['talkTime'], data['threeG'], data['touchScreen'], data['wifi'],
        data['pxArea']
    ]
     # Reshape and scale features
    features = np.array([features]).reshape(1,-1)
    features_scaled = scaler.transform(features)
    prediction = model.predict(features_scaled)
    predicted_price=int(prediction[0])
    return jsonify(predicted_price)


if __name__ == '__main__':
    app.run(port=5000)

