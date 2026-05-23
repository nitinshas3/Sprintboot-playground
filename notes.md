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