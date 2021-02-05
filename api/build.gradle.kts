plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")

    implementation("net.kyori:adventure-platform-bukkit:4.0.0-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.3.0")
}
