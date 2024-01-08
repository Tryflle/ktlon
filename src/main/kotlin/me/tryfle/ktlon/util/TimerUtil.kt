package me.tryfle.ktlon.util

class TimerUtil {
    private var lastMS: Long = 0

    fun hasPassed(ms: Long): Boolean {
        return getCurrentMS() - lastMS >= ms
    }
    private fun getCurrentMS(): Long {
        return System.nanoTime() / 1000000
    }
    fun reset() {
        lastMS = getCurrentMS()
    }
}