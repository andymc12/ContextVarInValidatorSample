# ContextVarInValidatorSample
Sample of accessing a context variable (in this case a JAX-RS HTTP Header) from inside a Validator

To run this sample, clone this repo, and then do: 
- Run `mvn clean install liberty:run-server`
- Wait for the server to download, extract and start.
- Point your browser to: `http://localhost:9080/ContextVarInValidator/customer/index`
- Then click on the various valid or invalid scenarios.

Alternatively, you could use curl directly to test with different countries and phone numbers like:
```
curl -v "http://localhost:9080/ContextVarInValidator/customer?country=US&phone=8005551234"
```
