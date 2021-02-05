dependencies {
    compileOnly(project(":api"))
    implementation("com.google.inject:guice:5.0.0-BETA-1")
    compileOnly("org.projectlombok:lombok:1.18.8")
    annotationProcessor("org.projectlombok:lombok:1.18.8")
    compileOnly("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")

    implementation("net.kyori:adventure-platform-bukkit:4.0.0-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.3.0")
}
