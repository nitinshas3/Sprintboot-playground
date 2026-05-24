# Spring Boot MVC Notes

Normally project structure:

- Controller
- Service
- Repository

Controller layer handles HTTP requests.

We usually create a `controller` package and inside it create classes for handling requests.

Example:

```
@Controller
public class HomeController {
}
```

But `@Controller` expects us to return a view file like:

```
return "home.jsp";
```

because normal controller is mainly for MVC view rendering.

If we want to directly return JSON/data for APIs, we use:

# @RestController

Example:

```
@RestController
public class HomeController {
}
```

`

# URL Mapping

We connect URL routes using:

```
@RequestMapping
@GetMapping
@PostMapping
```

Example:

```
@GetMapping("/home")
public String home(){
    return "Hello";
}
```

Now when user hits:

```
localhost:8080/home
```

this method runs.

---

# Front Controller

Spring MVC has a special controller called:

# DispatcherServlet

It acts as:

# Front Controller

Meaning:

All requests first come here.

Then it decides which controller method should run.

---

# Spring Boot MVC Flow

## 1. Application Starts

```
SpringApplication.run(App.class, args);
```

Spring Boot creates:

# ApplicationContext

(IoC Container)

and scans all Beans like:

```
@Component
@Controller
@Service
@Repository
```

---

## 2. Embedded Tomcat Starts

Because of:

```
spring-boot-starter-web
```

Spring Boot automatically starts embedded Tomcat inside JVM.

No external server needed.

---

## 3. DispatcherServlet Created

Spring Boot automatically creates:

# DispatcherServlet

and maps it to:

```text
/
```

So every request first comes here.

---

## 4. Request Comes

Example:

```text
localhost:8080/home
```

Flow:

```text
Browser
   ↓
Tomcat
   ↓
DispatcherServlet
```

---

## 5. DispatcherServlet Workflow

### Handler Mapping

Checks URL mappings.

Finds:

```
@GetMapping("/home")
```

---

### Handler Adapter

Prepares method arguments and calls controller method.

---

### Controller Method Runs

Example:

```
@GetMapping("/home")
public String home(){
    return "home";
}
```

---

### Return Handling

If return type is:

```
String
```

→ treated as view name.

If return object:

```
User
```

→ converted to JSON.

---

### View Resolver

Converts:

```text
home
```

to actual file like:

```text
home.jsp
```

or Thymeleaf template.

---

### Response Sent

HTML/JSON returned to browser.

Flow:

```text
Browser Request
      ↓
Tomcat
      ↓
DispatcherServlet
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
Response Back
```
# Spring Boot Mapping and JSON Notes

In Spring Boot, when we return Java objects from controller methods, Spring automatically converts them into JSON.

Example:

```
@GetMapping("/user")
public User getUser(){
    return new User(1, "Nitin");
}
```

Response automatically becomes:

```json
{
  "id": 1,
  "name": "Nitin"
}
```

This conversion is handled by:

# Jackson

Jackson converts:

```text
Java Object ↔ JSON
```

automatically.

---

# Request Mapping

We can map URLs using:

```
@RequestMapping
```

But `@RequestMapping` can handle all HTTP methods:

- GET
- POST
- PUT
- DELETE

So it becomes difficult to understand which request type is being used.

That is why Spring provides:

```
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
```

These are more specific and readable.

---

# GET Mapping

Used mainly for fetching data.

Example:

```
@GetMapping("/user/{id}")
public String getUser(@PathVariable int id){
    return "User ID: " + id;
}
```

URL:

```text
localhost:8080/user/10
```

Here:

```
@PathVariable
```

takes value from URL.

Because GET request mainly sends data through URL.

---

# POST Mapping

Used mainly for sending data to server.

Example:

```
@PostMapping("/user")
public User addUser(@RequestBody User user){
    return user;
}
```

Here:

```
@RequestBody
```

takes complete JSON body from HTTP request and converts it into Java object.

Example request body:

```json
{
  "id": 1,
  "name": "Nitin"
}
```

Spring + Jackson automatically converts JSON → Java Object.

---

# Main Idea

- Jackson handles Java Object ↔ JSON conversion
- `@GetMapping` used for fetching data
- `@PostMapping` used for sending data
- `@PathVariable` gets data from URL
- `@RequestBody` gets full JSON body from request