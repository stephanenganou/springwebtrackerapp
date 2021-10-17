# springwebtrackerapp:
is a relative Simple CRM system (on development).

## Additional AOP Use Case:
    ==> Most common:
        -> Logging, security, transactions
    
    ==> Audit logging:
        -> Who, what, when, where

    ==> Exception handling
        -> log exception and notifiy DevOps teams via SMS/email

    ==> API Management:
        -> how many time has a method been called by a user
        -> analytics: what are peak times? what is average load? who is top user?

### Advantages and Disadvantages of AOP:
    ==> Advantages of AOP:
        -> Reusable modules, -> Resolve code tangling
        -> Resolve code scatter, -> Applied selectively based on configuration

    ==> Disadvantages of AOP:
        -> Too many aspects and app flow is hard to follow.
        -> Minor performance cost for aspect execution (run-time weaving)

## AOP Terminology:
    ==> Aspect: module of code for a cross-cutting concern (logging, security, ...)
    ==> Advice: what action is taken and when it should be applied.
    ==> Join Point: when to apply code during program execution
    ==> Pointcut: A predicate expression for where advice should be applied.

## Advice Types:
    ==> Before advive: run before the method,
    ==> After finally advice: run after the method (finally)
    ==> After returning advice: run after the method (success execution)
    ==> After throwing advice: run after method (if exception thrown)
    ==> Around advice: run before and after method.

## Weaving:
    ==> Connection aspects to target objects to create an advised object.
    ==> Different types of weaving:
        -> Compile-time, -> Load-time or run-time

    ==> Regarding performance: run-time weaving is the slowest.

## AOP Frameworks
    ==> Two leading AOP Frameworks for Java:
        -> Spring AOP,
        -> AspectJ
### Spring AOP Support:
    ==> Spring provides AOP support
    ==> Key component of Spring:
        -> Security, transactions, caching etc.
    ==> Uses run-time weaving of aspects
    ==> Spring AOP Advantages:
        -> Simpler to use than AspectJ, -> Uses Proxy pattern
        -> Can migrate to AspectJ when using @Aspect annotation.
    ==> Spring AOP Disadvantages:
        -> Only supports method-level join points,
        -> Can only apply aspects to beans created by Spring app context
        -> Minor performance cost for aspect execution (run-time weaving)
### AspectJ:
    ==> Provides complete support for AOP
    ==> Rich support for:
        -> join points: method-level, constructor, field
        -> code weaving: compile-time, post compile-time and load-time.
    ==> AspectJ Advantages:
        -> Support all join points, -> works with any POJP, not just beans from app context.
        -> Faster performance compared to Spring AOP, -> Complete AOP support
    ==> AspectJ Disadvantages:
        -> Compile-time weaving requires extra compilation step
        -> AspectJ pointcut syntax can become complex