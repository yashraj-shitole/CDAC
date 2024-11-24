# git

## configuration

- configuration of git will done only for the first time
- types

  - system level
  - global level
  - local level

- global configuration
  - the configuration will be shared by all repositories for the current logged in user
  - the configuration will be stored in ~/.gitconfig file
  - this configuration will be used when code is getting committed

```bash

# set the user name globally
# > git config --global user.name <user name>

# set the user email globally
# > git config --global user.email <email of user>

```

## repository

- .git directory which is ued to manage the code versions
- contains
  - HEAD: file to point to the current branch user is working with
  - config: file to store local configuration of current repository
  - description: file to store repository's description
  - hooks: directory which keeps all hooks which will be triggered on different git events
  - objects: directory where all the versions recorded using different types of objects
    - types
      - blob object
        - this object stores the contents of a file in encrypted format
        - it gets created immediately after git add command
      - tree object
      - commit object
      - stash object
  - info: directory used to store info
  - refs: directory used to store references (branch names)

```bash
# create a git repository
> git init
```

## basic workflow of git

```bash

# get the status of working directory
> git status

# get small (one line) status of all files and directories in working directory
> git status -s

# statuses (two letters)
# first letter: shows the status with respect to the staging area
# second letter: shows the status with respect to the working directory
# ??: untracked file (the repository does not have any version of this file)
# A : the untracked file is now added to the staging area
#  M: the file is modified in working directory (not added in staging area yet)
# M :
# UU

# add the changes from current directory to staging area
> git add .

# create a version of file(s) present in the staging area in repository
# every version consists of
# - commit id (unique identifier assigned to every commit)
# - author name
# - author email
# - timestamp of commit
# - commit message
# - the changes recorded in terms of objects
# > git commit -m <message>
> git commit -m "first commit"

# get the difference between the current version in working directory and last version found in the repository
# +: new lines are added
# -: existing lines are deleted
> git diff

# get all the logs
> git log

# check the last version of a file from repository and replace it with current version present in working directory
# this command will remove all the changes made to the file since its last version
# > git checkout <file name>
> git checkout program1.js

# to remove the changes from staging area, there are two types of reset commands used
# soft reset
# - this command will move the changes from staging area to the working directory
# - the changes are not lost here, but developer needs to use checkout command to loose them
> git reset

# hard reset
# - this command will remove every change (whether it is in working directory or in staging area)
# - please please please execute this command on your own risk
# - once lost, the changes can not be brought back
> git reset --hard

```

## git stash

- git provides an area called as stash to try multiple versions of a code one by one
- stash area is manages a stack

```bash

# get the versions created in git stash area
> git stash list

# push the current changes to the stash area
> git stash

# get the last version from stash area to the working directory
# - this command will not remove the changes from stash area
> git stash apply

# remove the last entry from the stash area
> git stash drop

# remove a specific entry from stash area
# > git stash drop <entry number>
> git stash drop 0

# get the last entry from stash to the working directory and remove that entry from stash area
# git stash pop = git stash apply + git stash drop
> git stash pop

# get the modified files list from stash entry
> git stash show

```

## git internals

```bash

# objects
# - directory where all the versions recorded using different types of objects
# - every object has a unique identifier called as object id which is 40 characters long
# - out of them,
#  - first 2 characters are used to create a directory
#  - remaining 38 characters are used to create a filename
# - types
#   - blob object
#     - this object stores the contents of a file in encrypted format
#     - it gets created immediately after git add command
#   - tree object
#     - gets created per directory
#     - contains
#       - 100644: code to show the entry is for a file
#       - blob: the entry is pointing to a blob object
#       - blob object id: id of a blob object
#       - filename: name of the file in the directory
#   - commit object
#     - it stores the commit details
#       - author details (name and email)
#       - committer details (name and email)
#       - reference to tree object(s)
#       - message used in git commit command
#       - commit timestamp stored in unix time format
#     - it gets created after git commit command
#     - only commit object gets created per commit
#   - stash object

# read unencrypted content of any object file
# > git cat-file -p <object id>
> git cat-file -p d8f8c3

```
