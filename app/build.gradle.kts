plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.walhero.myteacher"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.walhero.myteacher"
        minSdk = 24
        targetSdk = 36
        versionCode = 2
        versionName = "1.1"

        // Google sample IDs are intentionally used until My Teacher is created in AdMob.
        // Replace both values with the dedicated My Teacher App ID and Rewarded Ad Unit ID
        // before a production release.
        manifestPlaceholders["adMobAppId"] = "ca-app-pub-3940256099942544~3347511713"
        buildConfigField(
            "String",
            "ADMOB_REWARDED_AD_UNIT_ID",
            "\"ca-app-pub-3940256099942544/5224354917\""
        )
        buildConfigField(
            "String",
            "PRIVACY_POLICY_URL",
            "\"https://princejour.github.io/my-teacher-privacy.html\""
        )
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.18.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation(platform("androidx.compose:compose-bom:2024.09.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("com.google.android.gms:play-services-ads:23.0.0")
    implementation("com.google.android.ump:user-messaging-platform:4.0.0")

    debugImplementation("androidx.compose.ui:ui-tooling")
}
