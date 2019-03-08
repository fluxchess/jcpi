import com.fluxchess.gladius.build.plugin.artifact.JavaArtifactPlugin
import com.fluxchess.gladius.build.plugin.ci.CiPlugin
import com.fluxchess.gladius.build.plugin.versioning.VersioningExtension
import com.fluxchess.gladius.build.plugin.versioning.VersioningPlugin

description = "Java Chess Protocol Interface"
group = "com.fluxchess.jcpi"
version = "2.0.0"

repositories {
	jcenter()
}

apply<CiPlugin>()
apply<VersioningPlugin>()
apply<JavaArtifactPlugin>()

plugins {
	`build-scan`
	`java-library`
}

buildScan {
	termsOfServiceUrl = "https://gradle.com/terms-of-service"
	termsOfServiceAgree = "yes"
}

dependencies {
	testImplementation("junit:junit:4.12")
	testImplementation("org.slf4j:slf4j-log4j12:1.7.26")
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.named<Jar>("jar").configure {
	manifest {
		attributes(
				"Implementation-Title" to project.name,
				"Implementation-Version" to project.version)
	}
}

val distTask = tasks.register<Zip>("dist") {
	into("${project.name}-${project.the<VersioningExtension>().version}") {
		from("README.md")
		from("LICENSE")
		from("NOTICE")

		from(tasks.named<Jar>("jar"))
		from(tasks.named<Jar>("sourcesJar"))
		from(tasks.named<Jar>("javadocJar"))

		from("src/dist/engine-interface.txt")
	}
}

artifacts {
	archives(tasks.named<Zip>("dist"))
}
