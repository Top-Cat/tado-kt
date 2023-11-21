package at.topc.tado.client

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.cancelFutureOnCancellation
import kotlinx.coroutines.suspendCancellableCoroutine
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.concurrent.FutureCallback
import org.apache.http.nio.client.HttpAsyncClient
import java.util.concurrent.CancellationException

suspend fun HttpAsyncClient.execute(request: HttpUriRequest): HttpResponse {
    return suspendCancellableCoroutine { cont: CancellableContinuation<HttpResponse> ->
        val future = this.execute(
            request,
            object : FutureCallback<HttpResponse> {
                override fun completed(result: HttpResponse) {
                    cont.resumeWith(Result.success(result))
                }

                override fun cancelled() {
                    if (cont.isCancelled) return
                    cont.resumeWith(Result.failure(CancellationException("Cancelled")))
                }

                override fun failed(ex: Exception) {
                    cont.resumeWith(Result.failure(ex))
                }
            }
        )

        cont.cancelFutureOnCancellation(future)
    }
}
