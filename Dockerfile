FROM tomcat:7.0.65-jre7

RUN rm -rf $CATALINA_HOME/webapps/ROOT
RUN rm -rf $CATALINA_HOME/webapps/ROOT.war
RUN rm -rf $CATALINA_HOME/webapps/docs
RUN rm -rf $CATALINA_HOME/webapps/examples
RUN rm -rf $CATALINA_HOME/webapps/manager
RUN rm -rf $CATALINA_HOME/webapps/host-manager

ENV CATALINA_OPTS -Dgrails.env=docker

COPY target/nuez-0.1.war $CATALINA_HOME/webapps/ROOT.war

CMD ["catalina.sh", "run"]