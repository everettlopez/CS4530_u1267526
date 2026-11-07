package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MarbleViewModel : ViewModel() {
    private val _posX = MutableStateFlow(100f)
    val posX: StateFlow<Float> = _posX.asStateFlow()

    private val _posY = MutableStateFlow(100f)
    val posY: StateFlow<Float> = _posY.asStateFlow()

    private var vx = 0f
    private var vy = 0f

    private var screenWidth = 1000f
    private var screenHeight = 1000f
    private var marbleSize = 100f

    private var lastUpdateTime = 0L

    fun setScreenBounds(width: Float, height: Float, size: Float) {
        screenWidth = width
        screenHeight = height
        marbleSize = size
    }

    fun updateTilt(ax: Float, ay: Float) {
        val currentTime = System.currentTimeMillis()
        if (lastUpdateTime == 0L) {
            lastUpdateTime = currentTime
            return
        }
        val dt = (currentTime - lastUpdateTime) / 1000f
        lastUpdateTime = currentTime

        if (dt > 0.1f || dt <= 0f) return

        val scale = 300f
        vx += dt * ax * scale
        vy += dt * (-ay) * scale

        val friction = 0.95f
        vx *= friction
        vy *= friction

        var newX = _posX.value + dt * vx
        var newY = _posY.value + dt * vy

        val maxX = screenWidth - marbleSize
        val maxY = screenHeight - marbleSize

        if (newX < 0f) {
            newX = 0f
            vx = -vx * 0.2f
        } else if (newX > maxX) {
            newX = maxX
            vx = -vx * 0.2f
        }

        if (newY < 0f) {
            newY = 0f
            vy = -vy * 0.2f
        } else if (newY > maxY) {
            newY = maxY
            vy = -vy * 0.2f
        }

        _posX.value = newX
        _posY.value = newY
    }
}
