# Enviroment 
1. Docker-compose
2. Selenium Grid to test crossbrowser 
3. Selenium Webdriver
4. Testng
5. Maven
# SETUP to RUN 
Su dung docker-compose config toan bo chu khong can chay setung selenium grid rieng le
1. Run docker-compose -> hien code nay dang su dung cach nay
( refer : https://www.pawangaria.com/post/docker/docker-compose-in-selenium-grid/)
docker-compose up -d
docker ps ( check selenium grid running)
http://localhost:4444/grid/console? ( view config browser )

file docker-compose.yml nay duoc dat trong thu muc cua project luon
2. coding va run binh thuong



# Setup Selenium Grid -> dung cho cach khong dung docker-compose
1. Download “Selenium Standalone Server” from “http://www.seleniumhq.org/download/” on all 3 machines
2. Goto machine 1 and open command prompt.
3. Navigate to location where jar is located.
4. Start Hub by command:  java -jar selenium-server-standalone-2.48.2.jar -role hub
5. Open browser and navigate to http://localhost:4444/grid/console and verify hub is started 


note: neu may local khong setup may client test cung thi o step 4 khong chay -role hub

# Why using Docker instead Selenium Grid setup
(https://www.pawangaria.com/post/docker/selenium-webdriver-grid-with-docker/)

Challenges :
If you use Selenium Grid for running you test, You must have to install so many configurations and tools on each machine which your test depends on like Java, Selenium WebDriver, Test Browsers, VNC etc. Maintaining machines in grid are sometimes costly and time consuming to maintain.

Why Docker :
With containerized test executors, the test suites can be executed on any platforms without library dependencies. Selenium Grid is distributed system of nodes for running tests. Instead of running your grid across multiple virtual machines, using Docker we can run them all Test’s parallel and fast on a single large machine using Docker.
