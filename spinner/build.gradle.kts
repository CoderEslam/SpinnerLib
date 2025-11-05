import io.grpc.internal.SharedResourceHolder.release
import org.gradle.kotlin.dsl.release

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
    id("signing")
}

android {
    namespace = "com.doubleclick.spinner"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
//    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.material)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate {
    publishing {
        publications {
            withType<MavenPublication> {
                groupId = "com.doubleclick.spinner"
                artifactId = "spinner-compose"
                version = "1.0"
            }
        }
    }
}

//publishing {
//    publications {
//        withType<MavenPublication> {
//            groupId = "io.github.yourusername"
//            artifactId = "your-library-name"
//            version = "1.0.0"
//
//            pom {
//                name.set("Your Library")
//                description.set("A Kotlin Multiplatform library for ...")
//                url.set("https://github.com/yourusername/your-repo")
//
//                licenses {
//                    license {
//                        name.set("Apache License 2.0")
//                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("yourusername")
//                        name.set("Your Name")
//                        email.set("you@example.com")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/yourusername/your-repo.git")
//                    developerConnection.set("scm:git:ssh://github.com/yourusername/your-repo.git")
//                    url.set("https://github.com/yourusername/your-repo")
//                }
//            }
//        }
//    }
//}