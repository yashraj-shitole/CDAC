# Kubernetes

## installation

- install minikube for learning purpose

```bash

# download the minikube executable
> curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64

# instal minikube
> sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64

# add the following line in ~/.bashrc
> vim ~/.bashrc
# alias kubectl="minikube kubectl --"

# reload the bashrc settings
> source ~/.bashrc

```

## cluster management

```bash

# start the cluster
# - it will download all docker images to simulate the kubernetes cluster
> minikube start

# get the current status of cluster
> minikube status

# stop the cluster
# - this command does not remove the cluster from your machine
# - it just stops the cluster
# - you may start the stopped cluster in future
> minikube stop

# remove / destroy the cluster
# - once destroyed you can not start the same cluster
# - you need to start / download the cluster again
> minikube destroy

# get the ssh access of cluster
# - this will give you the command prompt of master node
> minikube ssh

# get the ui / dashboard of minikube
# - do not close the tab
# - this will open dashboard in browser
> minikube dashboard

```

## common commands

```bash

# get list of resources
# > kubectl get <type of resource>
> kubectl get namespaces

# get details of selected resource
# > kubectl describe <resource type> <resource name>
> kubectl describe pod pod1

# delete a selected resource
# > kubectl delete <resource type> <resource name>
> kubectl delete namespace ns1

```

## namespace

- collection of kubernetes resources (pod/service/configmap/secretes)

```bash

# get the list of namespaces
> kubectl get namespaces

# create a namespace
> kubectl create namespace ns1

# delete a namespace
# - this command will also delete all the resources created inside the selected namespace
> kubectl delete namespace ns1

```

## pod

- basic unit of execution in kubernetes

- create a pod to run httpd
- create a file named pod1.yaml

```yaml

apiVersion: v1
kind: Pod
metadata:
    name: pod1
spec:
    containers
    - name: container1
      image: httpd

```

```bash

# get the list of pods
# the number 1/1 in READY column represents how many containers are
# configured inside the pod and how many of them are running
> kubectl get pod

# create a pod using pod1.yaml file
> kubectl create -f pod1.yaml

# get details of created pod
> kubectl describe pod pod1

```

- create a pod to run httpd with port 80 exposed

```yaml


apiVersion: v1
kind: Pod
metadata:
    name: pod2
spec:
    containers
    - name: container1
      image: httpd
      ports:
      - containerPort: 80


```

## replica set

- it is used to create pod replicas
- this is similar to service in docker swarm

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

```bash

# get list of replica sets
> kubectl get replicasets

# create a replica set using replicaSet1.yaml file
> kubectl create -f replicaSet1.yaml

```
