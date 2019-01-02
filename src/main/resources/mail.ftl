<!--FreeMarker模板-->
    <bean id="freeMarkerConfigurer" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
        <property name="templateLoaderPath" value="classpath:freemarker" />
        <property name="freemarkerSettings">
            <props>
                <prop key="locale">zh_CN</prop>
                <prop key="default_encoding">UTF-8</prop>
            </props>
        </property>
    </bean>
<h2><font color="green">${nickName}，您好！</font></h2>
<p>注意：30分钟后链接将失效!</p>
<p>请点击以下链接完成密码重置操作：</p>
<p><a href="www.abc.com" target="_blank">www.abc.com/user/reset?userId=test10011</a></p>
<p>${content}</p>