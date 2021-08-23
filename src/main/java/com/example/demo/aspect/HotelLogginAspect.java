package com.example.demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.*;

@Aspect
@Component
public class HotelLogginAspect {

	public static final Logger LOGGER = LogManager.getLogger(HotelLogginAspect.class.getName());

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- Before Section
	 * -------------------------------------------------------------------------
	 */
	@Before("execution(* com.mtit.spring_aop.assignment.controller.ApiController.getHotels())")
	public void beforeGetHotels() {
		LOGGER.info("+++++ getFlights - before +++++");
		Utility.logAction(Constants.Hotels, Constants.SEARCH);
	}
	
	@Before("execution(* com.mtit.spring_aop.assignment.controller.ApiController.saveHotels())")
	public void beforeSaveHotels() {
		LOGGER.info("+++++ saveHotels - before +++++");
		Utility.logAction(Constants.Hotels, Constants.NEW);
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Section
	 * -------------------------------------------------------------------------
	 */
	@After("execution(* com.mtit.spring_aop.assignment.controller.ApiController.getHotels())")
	public void afterGetHotels() {
		LOGGER.info(":::::: getHotels - after ::::::");
	}
	
	@After("execution(* com.mtit.spring_aop.assignment.controller.ApiController.saveHotels())")
	public void afterSaveHotels(JoinPoint joinPoint) {
		LOGGER.info(":::::: saveHotels - after ::::::");
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Return Section
	 * -------------------------------------------------------------------------
	 */
	@AfterReturning(pointcut = "execution(* com.mtit.spring_aop.assignment.controller.ApiController.getHotels())", returning = "result")
	public void afterReturnGetHotels(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### getHotels - afterReturn = " + result.toString() + " ######");
	}
	
	@AfterReturning(pointcut="execution(* com.mtit.spring_aop.assignment.controller.ApiController.saveHotels())", returning="result")
	public void afterReturnSaveFlight(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### saveHotels - afterReturn = " + result.toString() + "  ######");
	}
}
