plugins {
    java
}

val projectVersion: String by extra

group = "net.tonimatasdev"
version = projectVersion

subprojects {
    apply(plugin = "java")

    base {
        archivesName.set(project.name)
    }

    repositories {
        mavenCentral()

        maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    dependencies {
        compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    }
}