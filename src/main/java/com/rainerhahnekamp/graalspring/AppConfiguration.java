package com.rainerhahnekamp.graalspring;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(AppConfiguration.RegistryHinter.class)
public class AppConfiguration {
    @Value("${app.blender-class}")
    public String blenderClass;

    @Bean
    public Blender getBlender() throws Exception {
        return (Blender) Class.forName(blenderClass).getDeclaredConstructor().newInstance();
    }

    public static class RegistryHinter implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerConstructor(BlenderImpl.class.getDeclaredConstructors()[0], ExecutableMode.INVOKE);
        }
    }
}
