package com.kd.platform.web.demo.service.test;

import com.kd.platform.web.demo.entity.test.CourseEntity;

import com.kd.platform.core.common.service.CommonService;

public interface CourseServiceI extends CommonService{

	/**
	 * 保存课程
	 *@Author Frey.Fan
	 *@date   2013-11-10
	 *@param  course
	 */
	void saveCourse(CourseEntity course);
	/**
	 * 更新课程
	 *@Author Frey.Fan
	 *@date   2013-11-10
	 *@param  course
	 */
	void updateCourse(CourseEntity course);

}
