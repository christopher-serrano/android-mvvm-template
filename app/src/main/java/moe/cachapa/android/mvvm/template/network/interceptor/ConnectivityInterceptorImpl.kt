package moe.cachapa.android.mvvm.template.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import moe.cachapa.android.mvvm.template.utils.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {
    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline())
            throw NoConnectivityException() // Custom exception created for this interceptor
        return chain.proceed(chain.request())
    }

    // Helper function to check from system services whether there is networkconnection
    private fun isOnline(): Boolean {

        // We create a connectivity manager from system services and cast it as ConnectivityManager
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        // TODO: Fix this!
        cm.run {
            getNetworkCapabilities(activeNetwork)?.run {
                return when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }
        return false
    }
}