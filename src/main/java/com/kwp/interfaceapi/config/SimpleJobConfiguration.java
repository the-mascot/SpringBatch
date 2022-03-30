package com.kwp.interfaceapi.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kwp.interfaceapi.tasklets.taskletStep1;
import com.kwp.interfaceapi.tasklets.taskletStep2;
import com.kwp.interfaceapi.tasklets.taskletStep3;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class SimpleJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job simpleJob1() {
		return jobBuilderFactory.get("simpleJob1")	// simpleJob 이름으로 Job 등록
				.start(simpleStep1())
				.next(simpleStep2())
				.build();
	}
	
	@Bean
	public Job simpleJob2() {
		return jobBuilderFactory.get("simpleJob2")
				.start(simpleStep3())
				.build();
	}
	
	@Bean
	public Step simpleStep1() {
		return stepBuilderFactory.get("simpleStep1")
				.tasklet(new taskletStep1())
				.build();
	}
	
	@Bean
	public Step simpleStep2() {
		return stepBuilderFactory.get("simpleStep2")
				.tasklet(new taskletStep2())
				.build();
	}
	
	@Bean
	public Step simpleStep3() {
		return stepBuilderFactory.get("simpleStep3")
				.tasklet(new taskletStep3())
				.build();
	}
}
