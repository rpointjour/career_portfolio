# Docker & Kubernetes
#
Main repository link: https://github.com/rpointjour/docker_kubernetes.git

<img src="https://github.com/user-attachments/assets/ca1e04c3-7e2e-40ff-92a6-408b65f08372" alt="docker_kubernetes" style="width:50%;height:50%" />

#
A hands-on learning repo for Docker and Kubernetes concepts, built up from scratch.
#
## Structure

### Tutorial/
Introduction to Docker using Docker's official `welcome-to-docker` image. Contains a `docker-compose.yml` that spins up a local nginx web server on port `8088`.

```bash
cd Tutorial
docker compose up
```

Then open `http://localhost:8088` in your browser.

### First_Docker_App/
**image-classifer**

<img width="1843" height="778" alt="image" src="https://github.com/user-attachments/assets/9d13c639-a002-4e7c-99db-25202d539514" />


A containerized ML inference API built with Flask and MobileNetV2. Upload any image through the web UI and get back the top 5 ImageNet predictions with confidence scores.

```bash
cd First_Docker_App
docker build -t image-classifier .
docker run -p 5000:5000 --name image-classifier image-classifier
```

Then open `http://localhost:5000` in your browser.
