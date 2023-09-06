package com.example.demo;

import com.example.demo.Service.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    AsyncService asyncService;

    void execute(List<String> words) {
        long start = System.currentTimeMillis();
        // 开始执行大量的异步任务
        List<CompletableFuture<List<String>>> completableFutureList =
                words.stream()
                        .map(word -> asyncService.completableFutureTask(word))
                        .collect(Collectors.toList());
        // CompletableFuture.join（）方法可以获取他们的结果并将结果连接起来
        List<List<String>> results = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        // 打印结果以及运行程序运行花费时间
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println("results = " + results);
    }

    /**
     * CORE_POOL_SIZE = 4
     * 同时执行4个任务需要1秒左右
     */
    @Test
    void test1() {
        execute(Arrays.asList("F", "J", "Z", "T"));
    }


    /**
     * CORE_POOL_SIZE = 4
     * 同时执行6个任务需要2秒左右
     */
    @Test
    void test2() {
        execute(Arrays.asList("F", "J", "Z", "F", "J", "Z"));
    }

    void executeWithoutReturn(List<String> words) {
        long start = System.currentTimeMillis();
        // 开始执行大量的异步任务
        words.stream().forEach(word -> asyncService.completableFutureTaskWithoutReturn(word));
        // 打印结果以及运行程序运行花费时间
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
    }

    /**
     * 这种情况对应于我们需要返回结果给客户端请求的情况下，假如我们不需要返回任务执行结果给客户端的话呢？
     * 就比如我们上传一个大文件到系统，上传之后只要大文件格式符合要求我们就上传成功。普通情况下我们需要等待
     * 文件上传完毕再返回给用户消息，但是这样会很慢。采用异步的话，当用户上传之后就立马返回给用户消息，然后
     * 系统再默默去处理上传任务。这样也会增加一点麻烦，因为文件可能会上传失败，所以系统也需要一点机制来补偿这个问题，
     * 比如当上传遇到问题的时候，发消息通知用户。
     *
     * CORE_POOL_SIZE = 4
     * 对于不需要返回结果的任务，耗时接近0毫秒
     */
    @Test
    void test3() {
        executeWithoutReturn(Arrays.asList("F", "J", "Z", "F", "J", "Z"));
    }

}
