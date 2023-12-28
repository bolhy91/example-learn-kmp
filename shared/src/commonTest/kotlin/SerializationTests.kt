import com.kodeco.learn.data.model.KodecoContent
import com.kodeco.learn.data.model.PLATFORM
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTests {

    @Test
    fun testEncodePlatformAll() {
        val data = KodecoContent(
            platform = PLATFORM.ALL,
            url = "https://www.kodeco.com/feed.xml",
            image = "https://play-lh.googleusercontent.com/CAa4g9UbOJambautjl7lOfdiwjYoX04ORbivxdkPDZNirQd23TXQAfbFYPTN1VBWyzDt"
        )

        val decoded = Json.encodeToString(KodecoContent.serializer(), data)

        val content = "{\"platform\":\"all\",\"url\":\"https://www.kodeco.com/feed.xml\",\"image\":\"https://play-lh.googleusercontent.com/CAa4g9UbOJambautjl7lOfdiwjYoX04ORbivxdkPDZNirQd23TXQAfbFYPTN1VBWyzDt\"}"
        assertEquals(content, decoded)
    }

    @Test
    fun testDecodePlatformAll() {
        val data = "{\"platform\":\"all\",\"url\":\"https://www.kodeco.com/feed.xml\",\"image\":\"https://play-lh.googleusercontent.com/CAa4g9UbOJambautjl7lOfdiwjYoX04ORbivxdkPDZNirQd23TXQAfbFYPTN1VBWyzDt\"}"

        val decoded = Json.decodeFromString(KodecoContent.serializer(), data)
        val content = KodecoContent(
            platform = PLATFORM.ALL,
            url = "https://www.kodeco.com/feed.xml",
            image = "https://play-lh.googleusercontent.com/CAa4g9UbOJambautjl7lOfdiwjYoX04ORbivxdkPDZNirQd23TXQAfbFYPTN1VBWyzDt"
        )

        assertEquals(content, decoded)
    }
}