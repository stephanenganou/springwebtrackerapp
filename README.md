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
