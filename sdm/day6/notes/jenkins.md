# jenkins

## installation

```bash


# download the key
> sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
    https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

# add the apt source
> echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc]" \
    https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
    /etc/apt/sources.list.d/jenkins.list > /dev/null

# update the apt cache
> sudo apt-get update

# install pre-requisite
> sudo apt-get install fontconfig openjdk-17-jre

# install jenkins
> sudo apt-get install jenkins

# check the status of jenkins service
> sudo systemctl status jenkins

# start the jenkins service
> sudo systemctl start jenkins

# enable jenkins to start at the time of system booting
> sudo systemctl enable jenkins

```

## configuration

- once the jenkins service starts running, open the url
  - http://localhost:8080
- in the first step copy the password from password file
  - sudo cat /var/lib/jenkins/secrets/initialAdminPassword
- in the next step, install the default set of plugins
- in the last step, create a user account to use Jenkins
- login with the same account at http://localhost:8080

## creating a new project

```bash

# Poll SCM
# cron
# * * * * *
# 1 *: every minute of an hour
# 2 *: every hour of the day
# 3 *: every day of the month
# 4 *: every month of the year
# 5 *: every day of the week

# 0 10 * * *: every day at 10:00 am
# 0 10 1 * *: every month's 1st day at 10:00 am
# 0 10 * * 1: every monday at 10:00 am
# use https://crontab.guru website

```
