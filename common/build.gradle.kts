plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    id("com.jstarczewski.kstate.generate").version("0.0.3")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "common"
            export(project(":feature:saveable"))
            export(project(":feature:obtainable"))
            export("com.jstarczewski.kstate:kstate-core:0.0.3")
        }
    }

    sourceSets {
        val commonTest by getting
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                api(project(":feature:saveable"))
                api(project(":feature:obtainable"))
                api("com.jstarczewski.kstate:kstate-core:0.0.3")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
                implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.jstarczewski.kmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

swiftTemplates {

    outputDir = "../ios/ios/StateHolder"
    sharedModuleName = "common"
    coreLibraryExported = true
}