package com.protoseo.hellovirtualthread.study

import java.lang.Thread.Builder
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit.SECONDS
import org.junit.jupiter.api.Test

class VirtualThreadTest {

    @Test
    fun `Platform Thread와 Virtual Thread 각각 실행해보기`() {
        val pThread = Thread.ofPlatform().unstarted { println(Thread.currentThread()) }
        val vThread = Thread.ofVirtual().unstarted { println(Thread.currentThread()) }

        pThread.start() // Thread[#31,Thread-3,5,main]
        pThread.join()
        println("------------------")
        vThread.start() // VirtualThread[#32]/runnable@ForkJoinPool-1-worker-1
    }

    @Test
    fun `Executors를 활용해 virtual thread 생성하기`() {
        val executor = Executors.newVirtualThreadPerTaskExecutor()
        repeat(16) {
            executor.submit {
                Thread.sleep(500L)
                println("[${System.currentTimeMillis()}] [${Thread.currentThread()}] Index : $it")
            }
        }
        executor.shutdown()
        executor.awaitTermination(5, SECONDS)
    }

    @Test
    fun `Thread Builder를 활용해 virtual thread 생성하기`() {
        val builder: Builder = Thread.ofVirtual().name("MyThread")
        val task = Runnable {
            println("Running thread")
        }
        val thread = builder.start(task)
        println("Thread t name: " + thread.name)
        thread.join()
    }
}
