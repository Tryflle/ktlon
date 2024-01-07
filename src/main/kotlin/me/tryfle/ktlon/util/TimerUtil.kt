package me.tryfle.ktlon.util

class TimerUtil {
    private var lastMS: Long = 0

    fun hasPassed(ms: Long): Boolean = getCurrentMS() - lastMS >= ms
    fun getCurrentMS(): Long = System.nanoTime() / 1000000
    fun reset() = 0
}