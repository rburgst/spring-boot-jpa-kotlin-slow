# JPA Kotlin Sample

This sample illustrates slow performance for integration
tests in combination with

* kotlin
* jpa (hibernate)
* liquibase
* spring-data

On a reasonably recent MacBook Pro (Core i7, encrypted SSD) 
the runtime of the test is approx 10s, even though 
there is only a single entity and not much else.

## How to run and time

The goal of this exercise is to get the runtime of 
`JpaDemoApplicationTests.contextLoads` as fast as possible.

Dont rely on the runtime shown in IntelliJ, but simply take the timestamp
of the first and last log line and calculate the duration.
 
## Things to try to improve performance

* Use the following flags in the run config
    
    VM Arguments
    
    ```bash
    -noverify -XX:TieredStopAtLevel=1
    ```
    
    gets it down to approx 7s
    
* run with openj9

    did not really move the needle

* use `@EnableJpaRepositories(...bootstrapMode = BootstrapMode.LAZY)`

    no change in test time
