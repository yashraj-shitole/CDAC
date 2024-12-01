I'll provide a step-by-step guide to create a pod in Minikube and display an HTML file on localhost:

1. Prerequisites:
- Install Minikube
- Install kubectl
- Ensure Docker is installed

2. Start Minikube:
```bash
minikube start
```

3. Create an HTML file:
```bash
mkdir html-project
cd html-project
echo '<html><body><h1>Hello Kubernetes!</h1></body></html>' > index.html
```

4. Create a Dockerfile:
```bash
cat << EOF > Dockerfile
FROM nginx:alpine
COPY index.html /usr/share/nginx/html/index.html
EOF
```

5. Build the Docker image:
```bash
docker build -t my-html-app:v1 .
```

6. Create a Kubernetes deployment YAML:
```bash
cat << EOF > html-deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: html-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: html-app
  template:
    metadata:
      labels:
        app: html-app
    spec:
      containers:
      - name: html-container
        image: my-html-app:v1
        ports:
        - containerPort: 80
EOF
```

7. Create a Service to expose the pod:
```bash
cat << EOF > html-service.yaml
apiVersion: v1
kind: Service
metadata:
  name: html-service
spec:
  type: NodePort
  selector:
    app: html-app
  ports:
    - port: 80
      targetPort: 80
EOF
```

8. Apply the deployment and service:
```bash
kubectl apply -f html-deployment.yaml
kubectl apply -f html-service.yaml
```

9. Expose the service on localhost:
```bash
minikube service html-service
```

This will open a browser window with your HTML page, or provide a localhost URL you can access.

Alternative method to access the service:
```bash
# Get service details
kubectl get services

# Port forward
kubectl port-forward service/html-service 8080:80
```

Then open `http://localhost:8080` in your browser.

To verify:
```bash
# Check pods
kubectl get pods

# Check deployments
kubectl get deployments
```

Cleanup:
```bash
# Delete deployment and service
kubectl delete -f html-deployment.yaml
kubectl delete -f html-service.yaml

# Stop minikube
minikube stop
```

This procedure creates a simple Nginx pod serving an HTML file, exposes it via a NodePort service, and allows you to view it on localhost.








second



Here's a simplified guide to create a pod in Minikube with an HTML file without using a separate service:

1. Start Minikube
```bash
minikube start
```

2. Create an HTML file
```bash
echo '<html><body><h1>Hello Kubernetes!</h1></body></html>' > index.html
```

3. Create a Dockerfile
```bash
echo 'FROM nginx:alpine
COPY index.html /usr/share/nginx/html/index.html' > Dockerfile
```

4. Build Docker image
```bash
docker build -t my-html-app:v1 .
```

5. Create Pod YAML
```bash
cat << EOF > pod.yaml
apiVersion: v1
kind: Pod
metadata:
  name: html-pod
  labels:
    app: html-app
spec:
  containers:
  - name: html-container
    image: my-html-app:v1
    ports:
    - containerPort: 80
EOF
```

6. Create the Pod
```bash
kubectl apply -f pod.yaml
```

7. Port Forward to Access the Pod
```bash
kubectl port-forward pod/html-pod 8080:80
```

8. Access in Browser
Open `http://localhost:8080` in your web browser

9. Cleanup
```bash
kubectl delete -f pod.yaml
minikube stop
```



10. create replica set
- it is used to create pod replicas
- create a replica set to create 10 pods of httpd

```yaml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: rs1
spec:
  replicas: 10
  selector:
    matchLabels:
      app: httpd
  template:
    metadata:
      labels:
        app: httpd
    spec:
      containers:
        - name: rs-container
          image: httpd
          ports:
            - containerPort: 80
```

11. Delete replica
```bash
kubectl delete rs <replicaset-name> 

#replicaset
```

This method creates a single pod directly, skipping the deployment and service layers, and uses port forwarding to access the HTML file locally.

Pro Tips:
- Verify pod status with `kubectl get pods`
- Check pod details with `kubectl describe pod html-pod`
- View pod logs with `kubectl logs html-p
