FROM maven as war-build
WORKDIR /build
COPY . .
RUN mvn clean package

FROM jboss/wildfly
COPY --from=war-build /build/target/shopping-list.war /opt/jboss/wildfly/standalone/deployments
