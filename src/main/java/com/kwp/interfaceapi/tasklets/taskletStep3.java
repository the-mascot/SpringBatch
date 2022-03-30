package com.kwp.interfaceapi.tasklets;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


public class taskletStep3 implements Tasklet {
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("[yyyy년 MM월 dd일 HH시 mm분 ss초]");
		System.out.println(sdf.format(now).toString()+" taskletStep3 실행....");
		return RepeatStatus.FINISHED;
	}
}
