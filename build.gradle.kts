plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

subprojects {
    val projectName = name
    apply {
        plugin("java")
        plugin("com.github.johnrengelman.shadow")
    }

    repositories {
        maven(url = "https://repo.codemc.org/repository/nms/")
        maven(url = "https://repo.codemc.org/repository/maven-public/")
        maven(url="https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
        maven(url="https://mvn.lumine.io/repository/maven-public/")
        mavenLocal()
    }

    tasks {
        shadowJar {
            archiveFileName.set("$projectName.jar")
            destinationDirectory.set(file("out"))
        }
    }
}