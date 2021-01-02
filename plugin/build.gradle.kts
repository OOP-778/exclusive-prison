plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://repo.codemc.org/repository/nms/")
    maven(url = "https://repo.codemc.org/repository/maven-public/")
    mavenCentral()
    maven(url="https://mvn.lumine.io/repository/maven-public/")
    mavenLocal()
}

//<dependency>
//    <groupId>com.google.inject</groupId>
//    <artifactId>guice</artifactId>
//    <version>4.1.0</version>
//</dependency>

dependencies {
    compileOnly(project(":api"))
    compileOnly("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")
    implementation("com.google.inject:guice:5.0.0-BETA-1")
    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")
}
