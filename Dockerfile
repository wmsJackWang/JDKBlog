FROM java:8
VOLUME /tmp
COPY JDKBlog.jar JDKBlog.jar
RUN bash -c "touch /JDKBlog.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "JDKBlog.jar", "--spring.profiles.active=test", "--server.port=8080", "> /log/app.log"]