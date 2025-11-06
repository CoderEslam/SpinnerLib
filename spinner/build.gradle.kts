plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.34.0"
}

//android {
//    namespace = "com.doubleclick.spinner"
//    compileSdk = 34
//
//    defaultConfig {
//        minSdk = 24
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    kotlinOptions {
//        jvmTarget = "11"
//    }
//
//    buildFeatures {
//        compose = true
//    }
//
////    publishing {
////        singleVariant("release") {
////            withSourcesJar()
////            withJavadocJar()
////        }
////    }
//}
android {
    namespace = "com.chaaraapp.spinner_compose"
    compileSdk = 36

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
    implementation("androidx.compose.ui:ui:1.7.5")
    implementation("androidx.compose.ui:ui-graphics:1.7.5")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5")
    implementation("androidx.compose.material3:material3:1.3.0")
//    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
//    implementation(libs.androidx.activity.compose)
//    implementation(libs.androidx.compose.ui)
//    implementation(libs.androidx.compose.ui.graphics)
//    implementation(libs.androidx.compose.ui.tooling.preview)
//    implementation(libs.material)
//    implementation(libs.androidx.compose.foundation)
//    implementation(libs.androidx.material3)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}

mavenPublishing {
    // 👇 Library coordinates (artifact identifiers)
    coordinates("com.chaaraapp.spinner_compose", "spinner", "1.0.0")

    // 👇 Required metadata for Maven Central
    pom {
        name.set("Spinner Compose Library")
        description.set("A modern spinner UI component built with Jetpack Compose.")
        url.set("https://github.com/CoderEslam/SpinnerLib")
        inceptionYear.set("2025")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("CoderEslam")
                name.set("Eslam Ghazy")
                email.set("eslamghazy600@gmail.com")
                url.set("https://github.com/CoderEslam")
            }
        }

        scm {
            url.set("https://github.com/CoderEslam/SpinnerLib")
            connection.set("scm:git:git://github.com/CoderEslam/SpinnerLib.git")
            developerConnection.set("scm:git:ssh://git@github.com/CoderEslam/SpinnerLib.git")
        }
    }
}