package pl.semidude.example

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import io.restassured.RestAssured
import org.junit.jupiter.api.Test

@WireMockTest
class WiremockTest(wiremockRuntimeInfo: WireMockRuntimeInfo) {

    private val baseUrl: String = wiremockRuntimeInfo.httpBaseUrl

    @Test
    fun `should return response`() {
        // given
        stubFor(
            get(urlPathEqualTo("/something")).willReturn(ok())
        )

        // expect
        RestAssured
            .given()
                .get("$baseUrl/something")
            .then()
                .assertThat()
                .statusCode(200)
    }
}