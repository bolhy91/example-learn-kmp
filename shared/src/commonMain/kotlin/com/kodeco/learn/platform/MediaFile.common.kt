package com.kodeco.learn.platform

public expect class MediaFile

public expect fun MediaFile.toByteArray(): ByteArray


////1
//public suspend fun uploadAvatar(data: MediaFile): HttpResponse {
//    //2
//    return client.post(UPLOAD_AVATAR_URL) {
//        //3
//        body = MultiPartFormDataContent(
//            formData {
//                appendInput("filedata", Headers.build {
//                    //4
//                    append(HttpHeaders.ContentType, "application/octet-stream")
//                }) {
//                    //5
//                    buildPacket { writeFully(data.toByteArray()) }
//                }
//            })
//    }
//}
