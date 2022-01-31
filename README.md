# A Restcountries web service based on Spring Boot 2 with Reactor.

The web service would return a country/region given a search country name. Note that an incorrect country name would return a list with null. All countries can be viewed through the service.

* Search a country/region via a name

```
http://localhost:8080/name/{name}
```

* List all  countries/regions 

```
http://localhost:8080/countries
```

### Requirements
* JDK11+


### Running
##### Running with Spring Boot Maven Plugin
```
./mvnw spring-boot:run
```

### Web Application
Under the A file, there is a separate wep application for showing relevant country information in the browser.
