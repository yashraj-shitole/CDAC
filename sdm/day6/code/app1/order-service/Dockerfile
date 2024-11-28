FROM node
WORKDIR /src
COPY . .

# since there is a package.json, we can install all the packages
# using npm install command
# which will read the list of packages from package.json
RUN npm install

EXPOSE 4000
CMD npm start
