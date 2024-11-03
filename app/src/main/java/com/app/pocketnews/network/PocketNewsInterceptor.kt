package com.app.pocketnews.network

import com.app.pocketnews.BuildConfig
import com.app.pocketnews.utils.PocketNewsConstants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.addHeaderLenient
import okhttp3.internal.http2.Http2Reader.Companion.logger
import java.io.IOException
import java.util.Locale


class PocketNewsInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        addHeaderLenient(
            request.headers.newBuilder(),
            PocketNewsConstants.ApiConstants.HEADER_X_API_KEY,
           PocketNewsConstants.ApiConstants.HEADER_X_API_KEY_VALUE
        )
        if (BuildConfig.DEBUG) {
            val t1 = System.nanoTime()
            logger.info(
                String.format(
                    "Sending request %s on %s%n%s",
                    request.url, chain.connection(), request.headers
                )
            )

            val response = chain.proceed(request)

            val t2 = System.nanoTime()
            logger.info(
                String.format(
                    Locale.getDefault(),
                    "Received response for %s in %.1fms%n%s",
                    response.request.url, (t2 - t1) / 1e6, response.headers
                )
            )

            return response
        }
        return chain.proceed(request)
    }
}