# Docker

## installation

```bash

> sudo apt-get update
> sudo apt-get install ca-certificates curl
> sudo install -m 0755 -d /etc/apt/keyrings
> sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
> sudo chmod a+r /etc/apt/keyrings/docker.asc

> echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
> sudo apt-get update

> sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

# add your user in docker group
> sudo usermod -aG docker $USER

# restart the machine
> sudo reboot

```

## images

```bash

# list the images
> docker image ls

# test docker by pulling hello-world image
# pull an image from docker hub
# > docker image pull hello-world
> docker image pull <image name>

# get the image details
# > docker image inspect hello-world
> docker image inspect <image name or image id>

# delete an image
# > docker image rm hello-world
> docker image rm <image name or image id>

```

## containers

## network

## volumes
