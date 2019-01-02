package com.zking.ssm_wy.annotation;

import com.zking.ssm_wy.Base.model.Logs;
import com.zking.ssm_wy.Base.service.ILogsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 切点类
 * @author tiangai
 * @since 2014-08-05 Pm 20:35
 * @version 1.0
 */
@Component
@Aspect

public  class SystemLogAspect {
    //注入Service用于把日志保存数据库
   // @Resource
   // private LogService logService;
    @Autowired
    private ILogsService iLogsService ;
    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    //Service层切点
    @Pointcut("@annotation(com.zking.ssm_wy.annotation.SystemServiceLog)")
    public  void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.zking.ssm_wy.annotation.SystemControllerLog)")
    public  void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) throws Exception {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
      //  User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
        //请求的IP
        InetAddress addr = InetAddress.getLocalHost();
//        String ip = request.getRemoteAddr();
        String ip=addr.getHostAddress();//获得本机IP
        String address=addr.getHostName();//获得本机名称
        try {
            //*========控制台输出=========*//
            System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
        //    System.out.println("请求人:" + user.getName());
            System.out.println("请求IP:" +ip);
            System.out.println("本机名称"+address);
            //
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            //*========数据库日志=========*//
           // Log log = SpringContextHolder.getBean("logxx");
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date timeDate = df.parse(df.format(new Date()));
//
//            System.out.println("time"+timeDate);
            Logs logs =new Logs();
            logs.setLogid(UUID.randomUUID().toString().replace("-",""));
            logs.setLogparams(getControllerMethodDescription(joinPoint));
            logs.setLogname(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            logs.setLogip(ip);
//            logs.setLogcreatetime(new Date());
          //  System.out.println("===="+logs.getLogcreatetime());
            //保存数据库
            System.out.println(logs);
            int i = iLogsService.insertSelective(logs);
            System.out.println("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date timeDate = df.parse(df.format(new Date()));
//            System.out.println("time"+timeDate);
            Logs logs =new Logs();
            logs.setLogid(UUID.randomUUID().toString().replace("-",""));
            logs.setLogparams(getControllerMethodDescription(joinPoint));
            logs.setLogname("通知异常："+e.getMessage());
            logs.setLogip(ip);
//            logs.setLogcreatetime(timeDate);
         //   System.out.println("===="+logs.getLogcreatetime());
            //保存数据库
            System.out.println(logs);
            int i = iLogsService.insertSelective(logs);
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
       // User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
        //获取请求ip
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
              //  params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
           //System.out.println("请求人:" + user.getName());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            /*==========数据库日志=========*/
//            Log log = SpringContextHolder.getBean("logxx");
//            log.setDescription(getServiceMthodDescription(joinPoint));
//            log.setExceptionCode(e.getClass().getName());
//            log.setType("1");
//            log.setExceptionDetail(e.getMessage());
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
//            log.setParams(params);
//            log.setCreateBy(user);
//            log.setCreateDate(DateUtil.getCurrentDate());
//            log.setRequestIp(ip);
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date timeDate = df.parse(df.format(new Date()));
//            System.out.println("time"+timeDate);
//            Logs logs =new Logs();
//            logs.setLogid(UUID.randomUUID().toString().replace("-",""));
//            logs.setLogparams(getControllerMethodDescription(joinPoint));
//            logs.setLogname(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"+":请求参数:" + params);
//            logs.setLogip(ip);
//            logs.setLogcreatetime(timeDate);
//            System.out.println("===="+logs.getLogcreatetime());
//            //保存数据库
//            System.out.println(logs);
//            int i = iLogsService.insertSelective(logs);
            //保存数据库
//            logService.add(log);
            System.out.println("=====异常通知结束=====");
        }  catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
        /*==========记录本地异常日志==========*/
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);

    }


    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog. class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog. class).description();
                    break;
                }
            }
        }
        return description;
    }
}
