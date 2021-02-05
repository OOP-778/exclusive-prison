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

dependencies {
    implementation(project(":api"))
    compileOnly("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")
    implementation("com.oop.inteliframework:config:1.0")

    implementation("net.kyori:adventure-platform-bukkit:4.0.0-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.3.0")
}
