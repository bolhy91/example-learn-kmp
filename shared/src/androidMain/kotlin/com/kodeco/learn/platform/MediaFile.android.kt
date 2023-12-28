package com.kodeco.learn.platform

import com.kodeco.learn.data.MediaUri

public actual typealias MediaFile = MediaUri

public actual fun MediaFile.toByteArray(): ByteArray = contentResolver.openInputStream(uri)?.use {
    it.readBytes()
} ?: throw IllegalStateException("Couldn't open inputStream $uri")

