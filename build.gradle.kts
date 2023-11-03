import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

val sqlDelightVersion = "1.5.5"
plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
//    id("app.cash.sqldelight") version "1.5.5" apply false
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://jitpack.io")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation("androidx.datastore:datastore-preferences-core:1.1.0-dev01")

    //协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //http请求库
    val ktorVersion = "2.1.2"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")

    implementation("com.google.zxing:javase:3.3.3")
    implementation("moe.tlaster:precompose:1.3.14")
    implementation("androidx.datastore:datastore-preferences-core:1.1.0-dev01")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("io.github.succlz123:compose-imageloader-desktop:0.0.2")
    implementation("uk.co.caprica:vlcj:4.7.3")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //数据库
//    implementation("app.cash.sqldelight:runtime:$sqlDelightVersion")
//    implementation("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
//    implementation("app.cash.sqldelight:sqlite-driver:$sqlDelightVersion")


}






compose.desktop {
    application {
        //程序入口
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            //版本号
            packageName = "ComposeForDesktop"
            packageVersion = "1.0.0"


            macOS {
                packageVersion = "1.0.0"

                dmgPackageVersion = "1.0.0"

                pkgPackageVersion = "1.0.0"

                dockName = "WeChat"

                //设置图标
                iconFile.set(project.file("launcher/icon_wechat.png"))
            }
        }
    }
}







