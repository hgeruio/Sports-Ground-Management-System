package com.example.config;

import com.example.controller.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class excludePathPatterns implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/login");
    }

    /**
     * 跨域支持 比如说vue 的axios访问
     * @param registry
     */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }
    /**
     * 修改访问路径
     * @param configurer
     */
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 设置为true后，访问路径后加/ 也能正常访问  /user == /user/
        // configurer.setUseTrailingSlashMatch(true);
    }

    /**
     * 内容协商机制，主要是方便一个请求路径返回多个数据格式
     * @param configurer
     */
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }

    /**
     * 处理异步请求的。只能设置两个值，一个超时时间（毫秒，Tomcat下默认是10000毫秒，即10秒），还有一个是AsyncTaskExecutor，异步任务执行器
     * @param configurer
     */
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        //设置超时时间
//        configurer.setDefaultTimeout(1000000);
//        //设置异步任务执行器
//        configurer.setTaskExecutor(new AsyncTaskExecutor() {
//            @Override
//            public void execute(Runnable runnable, long l) {
//
//            }
//
//            @Override
//            public Future<?> submit(Runnable runnable) {
//                return null;
//            }
//
//            @Override
//            public <T> Future<T> submit(Callable<T> callable) {
//                return null;
//            }
//
//            @Override
//            public void execute(Runnable runnable) {
//
//            }
//        });
    }

    /**
     * 这个接口可以实现静态文件可以像Servlet一样被访问。
     * @param configurer
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }

    /**
     * 增加转化器或者格式化器。这边不仅可以把时间转化成你需要时区或者样式。还可以自定义转化器和你数据库做交互，比如传进来userId，经过转化可以拿到user对象
     * @param registry
     */
    public void addFormatters(FormatterRegistry registry) {
    }

    /**
     * 添加静态资源--过滤swagger-api (开源的在线API文档)
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }



    public void addViewControllers(ViewControllerRegistry registry) {
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    }

    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    }
    /**
     * 配置消息转换器
     * @param converters
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }

    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }

    @Nullable
    public Validator getValidator() {
        return null;
    }

    @Nullable
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
