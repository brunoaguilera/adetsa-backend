/etc/init.d/tomcat9-adetsa-backend stop

./mvnw clean install -Dspring.config.location=file:///opt/adetsa-backend/tomcat/conf/application.properties -Dext.prop.dir=/opt/adetsa-backend/tomcat/conf -DskipTests=true

sleep 10
rm -fr /opt/adetsa-backend/tomcat/latest/webapps/adetsa*


echo ""
echo ""
ls -ltrh /opt/adetsa-backend/tomcat/latest/webapps/

echo ""
echo ""
ps -ax | grep -i tomcat
cp target/adetsa-backend-0.0.1.war /opt/adetsa-backend/tomcat/latest/webapps/adetsa.war

echo ""
echo ""
ls -ltrh /opt/adetsa-backend/tomcat/latest/webapps/
sleep 10
/etc/init.d/tomcat9-adetsa-backend start
sleep 10

echo ""
echo ""
ps -ax | grep -i tomcat
