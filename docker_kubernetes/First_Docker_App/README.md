# Image Classifier API
#
Main repository link: https://github.com/rpointjour/docker_kubernetes.git

<img width="1830" height="425" alt="image" src="https://github.com/user-attachments/assets/6361fbc1-1e66-49c1-80be-ec454460ea68" />


A containerized ML inference API built with Flask and MobileNetV2. Upload any image and get back the top 5 predictions with confidence scores — all running inside a Docker container.

## Stack

- **Flask** — REST API
- **TensorFlow / MobileNetV2** — pre-trained ImageNet classifier
- **Pillow** — image preprocessing
- **Docker** — containerized runtime

## Structure

```
First_Docker_App/
├── app.py              # Flask API + routes
├── requirements.txt    # Pinned dependencies
├── Dockerfile          # Image build instructions
├── .dockerignore       # Excludes dev/cache files from the image
└── templates/
    └── index.html      # Web UI
```

## Run locally

**Build the image:**
```bash
docker build -t image-classifier .
```

**Run the container:**
```bash
docker run -p 5000:5000 --name image-classifier image-classifier
# To run with template
docker run -p 5000:5000 -v ${PWD}/templates:/app/templates -v ${PWD}/static:/app/static --name image-classifier image-classifier
```

Open `http://localhost:5000` in your browser, upload an image, and hit **Run Inference**.

<img width="1843" height="778" alt="image" src="https://github.com/user-attachments/assets/841aaa6c-90b5-4fd3-83cf-52680b5c1fcd" />


## API

```
POST /predict
Content-Type: multipart/form-data
Body: file=<image>
```

**Response:**
```json
{
  "predictions": [
    { "label": "golden_retriever", "confidence": 0.5549 },
    { "label": "Labrador_retriever", "confidence": 0.0738 },
    { "label": "kuvasz", "confidence": 0.0388 },
    { "label": "English_setter", "confidence": 0.0385 },
    { "label": "Chesapeake_Bay_retriever", "confidence": 0.0307 }
  ]
}
```

**curl:**
```bash
curl -X POST http://localhost:5000/predict -F "file=@/path/to/image.jpg"
```
