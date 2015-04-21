# rbs_test

1. Code developed with java 7
2. Maven is used as build system
3. Project can be built using 
    mvn clean install
4. Code coverage can be genrated using 
    mvn cobertura:cobertura
    and result will be avialable in target/site/cobertura folder, open index.html in browser
5. Application can be run from eclipse by running com.ravi.interview.Application class, which will start tomcat server
6. Application can be run from command prompt by 
    mvn spring-boot:run
7. once application is running, it can be accessed via 
   http://localhost:8080/primes/10 (Number 10 can be changed)
8. Application is not production ready in terms of memory requirments.
9. with get request Accept header can be sent to request XML(application/xml) or Json(application/json)









