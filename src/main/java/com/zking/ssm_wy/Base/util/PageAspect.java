package com.zking.ssm_wy.Base.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {
    @Around("execution(* *..*Service.*Page(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        Object[] params=args.getArgs();
        PageBean pb=null;
        for (Object param : params) {
            if(param instanceof PageBean){
                pb=(PageBean)param;
                break;
            }
        }

        //设置分页参数
        if (null!=pb && pb.isPagination()){
            PageHelper.startPage(pb.getPage(),pb.getRows());
        }
        //执行方法，设置方法参数
        Object result = args.proceed(params);
        //将分页总记录数设置到PageBean中
        if (null!=pb && pb.isPagination()){
            List lst= (List) result;
            PageInfo pageInfo=new PageInfo(lst);
            pb.setTotal(pageInfo.getTotal()+"");
        }

        return  result;
    }
}
