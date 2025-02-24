FROM tomcat:8.5-jdk17-openjdk

VOLUME /tmp

ARG WAR_FILE

ADD ${WAR_FILE} /usr/local/tomcat/webapps/app.war

RUN ls -l /usr/local/tomcat/webapps/

