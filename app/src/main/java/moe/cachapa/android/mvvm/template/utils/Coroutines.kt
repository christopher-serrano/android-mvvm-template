package moe.cachapa.android.mvvm.template.utils

import kotlinx.coroutines.*

object Coroutines {
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    fun io(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }

    @OptIn(DelicateCoroutinesApi::class)
    fun globalIo(work: suspend (() -> Unit)) =
        GlobalScope.launch(Dispatchers.IO) {
            work()
        }

    fun lifecycle(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main.immediate)
}
