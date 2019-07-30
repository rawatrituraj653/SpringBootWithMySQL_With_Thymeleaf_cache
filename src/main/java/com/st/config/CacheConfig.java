package com.st.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;
@Configuration
public class CacheConfig {

	@Bean
	public Config getConfig() {
		
		return new Config()
		.setInstanceName("hazel-instance")
		.addMapConfig(
				new MapConfig()
				.setName("customer-cache")
				.setTimeToLiveSeconds(4000)
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizePolicy.FREE_HEAP_SIZE))
				.setEvictionPolicy(EvictionPolicy.LFU)
				);
		
	}
}
