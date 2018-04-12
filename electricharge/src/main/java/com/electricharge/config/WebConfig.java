package com.electricharge.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig  {
    /**
     * 添加fastjson的转换
     */
        @Bean
        public HttpMessageConverters customConverters() {
            // 定义一个转换消息的对象
            FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

            // 添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
            FastJsonConfig fastJsonConfig = new FastJsonConfig();

            fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

            List<MediaType> fastMediaTypes = new ArrayList<MediaType>();

            // 处理中文乱码问题
            fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            fastConverter.setSupportedMediaTypes(fastMediaTypes);

            // 在转换器中添加配置信息
            fastConverter.setFastJsonConfig(fastJsonConfig);

            // 将转换器添加到converters中
            return new HttpMessageConverters(fastConverter);
        }

}
