package com.example.imdb;

import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager simpleCacheManager() {
		var cacheManager = new SimpleCacheManager();
		var moviesCache = new ConcurrentMapCache("genres");
		cacheManager.setCaches(List.of(moviesCache));
		return cacheManager;
	}
}
