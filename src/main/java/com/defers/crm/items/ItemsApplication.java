package com.defers.crm.items;

import com.defers.crm.items.properties.AppProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;

@ComponentScan
public class ItemsApplication {
    public static void main(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ItemsApplication.class);
        //context.register(ItemsApplication.class);
        //context.refresh();
        AppProperties appProperties = context.getBean("appProperties", AppProperties.class);
        System.out.println(appProperties.getHost());
//        HttpHandler handler = WebHttpHandlerBuilder
//                .applicationContext(context)
//                .build();
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//        DisposableChannel server = HttpServer.create()
//                .host("localhost")
//                .port(3520)
//                //.host(appProperties.getHost())
//                //.port(appProperties.getPort())
//                .handle(adapter)
//                .bindNow();
        context.getBean(HttpServer.class)
                .bindUntilJavaShutdown(Duration.ofSeconds(60), null);
    }
}
