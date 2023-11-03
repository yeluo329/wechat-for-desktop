package util

object EnvUtil {
    val osName = System.getProperty("os.name", "generic")

    fun isWindows() = osName.contains("indows")
}