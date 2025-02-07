# Используем официальный образ OpenJDK в качестве основы
FROM eclipse-temurin:17-jdk-alpine

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем скомпилированный JAR-файл в контейнер
COPY target/*.jar app.jar

# Определяем команду для запуска приложения
CMD ["java", "-jar", "app.jar"]
