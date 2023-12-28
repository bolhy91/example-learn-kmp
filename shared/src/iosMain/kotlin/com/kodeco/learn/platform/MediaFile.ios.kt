package com.kodeco.learn.platform

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.UIKit.UIImage
import platform.UIKit.UIImageJPEGRepresentation
import platform.posix.memcpy

public actual typealias MediaFile = UIImage

public actual fun MediaFile.toByteArray(): ByteArray {
    return UIImageJPEGRepresentation(this, compressionQuality = 1.0)?.toByteArray() ?: emptyArray<Byte>().toByteArray()
}

@OptIn(ExperimentalForeignApi::class)
fun NSData.toByteArray(): ByteArray {
    return ByteArray(length.toInt()).apply {
        usePinned {
            memcpy(it.addressOf(0), bytes, length)
        }
    }
}
