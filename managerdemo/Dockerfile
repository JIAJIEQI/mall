FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/

# DB services
ENV dbUrl http://49.4.4.124:31021/ddmdemo

# Kafka
ENV bootstrapServers dms-kafka.cn-north-1.myhuaweicloud.com:37000
ENV topic k-0e964f1ae251477ebbfe8cd85e758ee6-0df351cc-5f98-4b78-b71b-3d41c683f55f
ENV groupId g-271545b4-5026-432d-9ecb-5092a9f6a5fe
# Kafka client
ENV accessKey G14IYNXRHFV9ISEWHEMW
ENV secretKey ZGaTtLs1KwcRCOlfmzFMBJ9lqbsZJoyU3Kcgr5gh
ENV projectId 0e964f1ae251477ebbfe8cd85e758ee6

# Redis
ENV redisHost redis-a231e00-dcs-rcwm.dcs.huaweicloud.com
ENV redisPort 6379
ENV redisPasswd Ddm@cloud2017
ENV redisMaxActive 250

COPY managerdemo/target/ $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/manager-demo/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/manager-demo/initDemo.sh

CMD ["catalina.sh", "run"]