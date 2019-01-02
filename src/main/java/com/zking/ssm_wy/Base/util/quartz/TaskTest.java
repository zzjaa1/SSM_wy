package com.zking.ssm_wy.Base.util.quartz;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时器具体实现类
 */
@Component
public class TaskTest {
	public final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
	public void run() {
		System.out.println("run======"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");

	}

	public void run1() {
		System.out.println("run1111111111111111111======"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");
	}


}
