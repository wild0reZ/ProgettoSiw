package it.silph.silphportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("HomePage");
	registry.addViewController("/AlbumsPage").setViewName("AlbumsPage");
	registry.addViewController("/AuthorizationRequiredPage").setViewName("AuthorizationRequiredPage");
	registry.addViewController("/CompilaModuloPage").setViewName("CompilaModuloPage");
	registry.addViewController("/FormFoto").setViewName("FormFoto");
	registry.addViewController("/FotografiPage").setViewName("FotografiPage");
	registry.addViewController("/FotografoPage").setViewName("FotografoPage");
	registry.addViewController("/FotoPage").setViewName("FotoPage");
	registry.addViewController("/HomePage").setViewName("HomePage");
	registry.addViewController("/ModuliPage").setViewName("ModuliPage");
    }
}
