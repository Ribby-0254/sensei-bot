# Java Logging Notes

## Resources
* Very good overview on java logging frameworks and basics on how to use them: [Marco Behler Blog](https://www.marcobehler.com/guides/java-logging)
* Some examples/ info on various logging practices: [article](https://www.datadoghq.com/blog/java-logging-guide/)
## Logging Libraries Overview

  * `java.util.logging` (JUL)
    * Comes bundles with JDK
    * Super simple
    * Not commonly used
    * Quirk: uses `severe` and `fine` instead of the commonly used terms `error` and `debug`
    * Stackoverflow post on why its not used - [link](https://stackoverflow.com/questions/11359187/why-not-use-java-util-logging)
    
  * `Log4j` (Version 1)
    * Uses common log level names unlike JUL
    * Has more options to write logs to different outputs than JUL
    * Gives more control on formatting log message display
    * Deprecated; Replaced by `Log4j2`
    
  * `JCL` (Apache common logging)
    * Facade for other logging implementations
      * Allows you to user an interface for logging in your code, while letting you swap out different implementations
    * Requires you to use a logging library since JCL is just a facade
    * Has some issues so not too popular
    
  * `SLF4J` & `Logback`
    * Logback is a logging library
      * Default choice for Spring boot starter
    * SLF4J is a facade logging libary
      * Warns you if you don't provide a logging library (but still works without it i think)
      * Provide logging libraries with binding libraries (ex: `slf4j2-log4j2`)
      * If you use a library that uses some other logging library, then you can replace that library with your own choice with something like `slf4j-over-log4j`
      * So in short, you can use SLF4J to code to the SLF4J API, choose an implementation (log4j, juul, etc), and use bridging libraries (ex: `log4j-over-slf4j`) to make 3rd party libraries compatible with your logging configs
    
  * `Log4J2`
    * New (2014)
    * Can be used as a facade (`log4j-api`)
    * Can be used as an implementation (`log4j-core`)
    * Offers better perforamce and better API
    
    
## How to use

* Get a `Logger` instance for your class: `private static Logger logger = LoggerFactory.getLogger(YourClassHere.class);`
  * Using `private static final` for log variable is good practice as declared here: [sonar link](https://rules.sonarsource.com/java/tag/convention/RSPEC-1312)

## Log Levels

  * `FATAL` 
    * Java process cannot continue and will terminate
    * Not commonly used
    * Not supported by SLF4J directly (see more info in [docs](http://www.slf4j.org/faq.html#fatal))
    
  * `ERROR`
    * request was aborted and requires human intervention ASAP
    
  * `WARN`
    * request was not serviced satisfactorily, intervention is required soon, but not necessarily immediately
    
  * `INFO`
    * Very commonly used
    * Good for logging out status or any useful info
    
  * `DEBUG`
    * Advanced level detail of internal process flows
    * Used when investigating specific issues (and turned off later)
      * Disabling/ enabling of DEBUG level may or may not require app restart depending on the logging library used
    
  * `TRACE`
    * More detailed than `DEBUG`
    * Always disabled on production
    * Used during testing or dev environments
    
## Log Files
  * Have separate files for separate use cases
  * Some file naming patterns:
    * `<appname>.<instance-name>.YYYYMMDD.ZZZ.error.log`
    * `<instance-name>.YYYYMMDD.ZZZ.status.log`
  * Consider using a service like `log-merger` to combine logs with the same timestamp

## Misc
  * Use log masking to  hide sensitive information
  * Consider providing hints at possible fixes/ calls for action for error instead of just logging them
  * For multiple applications, consider using a centralized logging server like Graylog, Elk, etc to have one place to refer to for all logs
  * Use parameterized logging instead of string concatatenation - [slf4j docs](http://www.slf4j.org/faq.html#logging_performance)