package retrofit

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import okhttp3.Interceptor
import okhttp3.Response
import java.io.FileReader
import java.io.IOException
import java.util.*

internal class AppInterceptor : Interceptor {

    // reference: https://docs.upbit.com/docs/create-authorization-request
    private val getToken: String = runCatching {
        FileReader(KEY_PATH).let {
            val accessKey = it.readText()
            val secretKey = it.readText()
            val algorithm: Algorithm = Algorithm.HMAC256(secretKey)

            JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm)
        }
    }.onFailure {
        it.printStackTrace()
    }.getOrThrow()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val header = request().newBuilder()
            .addHeader("Bearer", getToken)
            .build()
        proceed(header)
    }

    companion object {
        const val KEY_PATH = "key.txt"
    }
}
