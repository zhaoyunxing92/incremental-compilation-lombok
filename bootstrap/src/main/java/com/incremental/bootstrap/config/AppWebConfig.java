package com.incremental.bootstrap.config;

import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.incremental.bootstrap.json.EnumIntValue;
import com.incremental.bootstrap.json.FastJsonEnumIntValueDeserializer;
import com.incremental.bootstrap.json.FastJsonEnumIntValueSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author docker
 */
@Slf4j
@Configuration
public class AppWebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setWriterFeatures(
                JSONWriter.Feature.PrettyFormat,
                JSONWriter.Feature.WriteNonStringKeyAsString
        );

        JSONFactory.getDefaultObjectWriterProvider().register(EnumIntValue.class, new FastJsonEnumIntValueSerializer());
        JSONFactory.getDefaultObjectReaderProvider().register(EnumIntValue.class, new FastJsonEnumIntValueDeserializer());

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);

        converters.add(0, converter);
        log.info("converters.size={}", converters.size());
    }

}
