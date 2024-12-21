# Используем базовый образ OpenJDK 22 с Tomcat
FROM tomcat:9.0-jdk17-temurin

# Устанавливаем переменную окружения для каталога Tomcat
ENV CATALINA_HOME /usr/local/tomcat

# Удаляем стандартное приложение Tomcat (опционально)
RUN rm -rf $CATALINA_HOME/webapps/*

# Копируем ваше приложение в папку веб-приложений Tomcat
COPY /target/Web-3.war $CATALINA_HOME/webapps/ROOT.war

# Открываем порт для доступа к Tomcat
EXPOSE 8080

# Запускаем Tomcat
CMD ["catalina.sh", "run"]