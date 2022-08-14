package retrofit

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

internal class AppInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val header = request().newBuilder()
            .addHeader("Bearer", getToken)
            .build()
        proceed(header)
    }

    // reference: https://docs.upbit.com/docs/create-authorization-request
    // FIXME: 인증방법 고민
    private val getToken: String = runCatching {
        val accessKey = TEMP_ACCESS_KEY
        val secretKey = TEMP_SECRET_KEY
        val algorithm: Algorithm = Algorithm.HMAC256(secretKey)

        JWT.create()
            .withClaim("access_key", accessKey)
            .withClaim("nonce", UUID.randomUUID().toString())
            .sign(algorithm)
    }.onFailure {
        it.printStackTrace()
    }.getOrThrow()

    companion object {
        const val KEY_PATH = "./key.txt"
        const val TEMP_ACCESS_KEY = ""
        const val TEMP_SECRET_KEY = ""
    }
}
