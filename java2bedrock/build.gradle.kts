plugins {
    java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/")

    }
	maven {
    url = uri("https://repo.papermc.io/repository/maven-public/")

    }
}

	dependencies {
		implementation("com.viaversion:viaversion:5.1.1")
    implementation("com.viaversion:viabackwards-common:5.1.1")
    implementation("com.viaversion:viarewind-common:4.0.3")
    implementation("net.raphimc:vialoader:3.0.4")
	  implementation(project(":common"))
	  compileOnly("org.geysermc:geyser-api:2.4.4-SNAPSHOT")
	}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport" // Change this to your main class
        }
    }

    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("") // Prevent the -all suffix on the shadowjar file.
    }
}
