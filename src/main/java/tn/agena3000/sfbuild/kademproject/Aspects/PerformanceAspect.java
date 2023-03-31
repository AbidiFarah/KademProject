package tn.agena3000.sfbuild.kademproject.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.agena3000.sfbuild.kademproject.Services.*.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.agena3000.sfbuild.kademproject.Services.*.*.*.retrieveAll(..))")
    public Object profileALL(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.agena3000.sfbuild.kademproject.Services.*.*.*.getEtudiantsByDepartement(..))")
    public List<Object> profileEtudiant(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        List<Object>  obj = (List<Object>) pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.agena3000.sfbuild.kademproject.Services.*.*.*.retrieveDepartementsByUniversite(..))")
    public List<Object> profileDepartement(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        List<Object>  obj = (List<Object>) pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
