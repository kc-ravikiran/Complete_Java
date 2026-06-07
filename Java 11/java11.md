# Java 11 Features - Complete Guide with Examples

# Table of Contents

1. Overview
2. Local-Variable Syntax for Lambda Parameters
3. New String Methods
4. Files Utility Enhancements
5. Collection to Array Enhancement
6. HTTP Client API
7. Running Java Source Files Directly
8. Nest-Based Access Control
9. Dynamic Class-File Constants
10. Epsilon Garbage Collector
11. Flight Recorder
12. Low-Overhead Heap Profiling
13. TLS 1.3 Support
14. Unicode 10 Support
15. Java EE and CORBA Module Removal
16. Other Important Changes
17. Summary

---

# 1. Overview

Java 11 is a Long-Term Support (LTS) release introduced in September 2018.

Major highlights:

* New HTTP Client API
* New String methods
* Single-file source execution
* Lambda parameter enhancement
* Collection API improvements
* Nest-based access control
* TLS 1.3 support
* Flight Recorder

---

# 2. Local-Variable Syntax for Lambda Parameters

## Before Java 11

```java
(var x, y) -> x + y; // Compilation Error
```

Either all parameters must be explicitly typed or inferred.

```java
(String x, String y) -> x + y
```

or

```java
(x, y) -> x + y
```

## Java 11

```java
(var x, var y) -> x + y
```

### Example

```java
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {

        List<String> names = List.of("John", "Mike");

        names.forEach((var name) -> {
            System.out.println(name);
        });
    }
}
```

Output:

```
John
Mike
```

---

# 3. New String Methods

Java 11 introduced several useful String methods.

## 3.1 isBlank()

Checks whether string contains only whitespace.

```java
String str = "   ";

System.out.println(str.isBlank());
```

Output:

```
true
```

---

## 3.2 lines()

Converts multiline string into Stream.

```java
String text = "Java\nPython\nC++";

text.lines()
    .forEach(System.out::println);
```

Output:

```
Java
Python
C++
```

---

## 3.3 strip()

Removes leading and trailing Unicode whitespace.

```java
String str = "  Java  ";

System.out.println(str.strip());
```

Output:

```
Java
```

---

## 3.4 stripLeading()

```java
String str = "   Java";

System.out.println(str.stripLeading());
```

Output:

```
Java
```

---

## 3.5 stripTrailing()

```java
String str = "Java    ";

System.out.println(str.stripTrailing());
```

Output:

```
Java
```

---

## 3.6 repeat()

Repeats string n times.

```java
String result = "Java ".repeat(3);

System.out.println(result);
```

Output:

```
Java Java Java
```

---

# 4. Files Utility Enhancements

New method:

```java
Files.readString()
```

## Example

```java
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileExample {
    public static void main(String[] args) throws Exception {

        String content =
                Files.readString(Path.of("sample.txt"));

        System.out.println(content);
    }
}
```

---

## Files.writeString()

```java
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFileExample {

    public static void main(String[] args) throws Exception {

        Files.writeString(
                Path.of("sample.txt"),
                "Hello Java 11"
        );
    }
}
```

---

# 5. Collection to Array Enhancement

Before Java 11:

```java
String[] arr =
        list.toArray(new String[0]);
```

Java 11:

```java
String[] arr =
        list.toArray(String[]::new);
```

## Example

```java
import java.util.List;

public class CollectionExample {

    public static void main(String[] args) {

        List<String> list =
                List.of("Java", "Python");

        String[] array =
                list.toArray(String[]::new);

        for(String s : array) {
            System.out.println(s);
        }
    }
}
```

---

# 6. HTTP Client API

Standardized HTTP Client.

Package:

```java
java.net.http
```

---

## 6.1 GET Request

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetExample {

    public static void main(String[] args)
            throws Exception {

        HttpClient client =
                HttpClient.newHttpClient();

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(response.body());
    }
}
```

---

## 6.2 POST Request

```java
HttpRequest request =
        HttpRequest.newBuilder()
                .uri(new URI("https://example.com"))
                .POST(
                    HttpRequest.BodyPublishers
                        .ofString("Hello")
                )
                .build();
```

---

## 6.3 Asynchronous Request

```java
client.sendAsync(
        request,
        HttpResponse.BodyHandlers.ofString()
)
.thenApply(HttpResponse::body)
.thenAccept(System.out::println)
.join();
```

---

# 7. Running Java Source Files Directly

No compilation required.

File:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Java 11");
    }
}
```

Run:

```bash
java Hello.java
```

Output:

```
Hello Java 11
```

---

# 8. Nest-Based Access Control

Allows nested classes to access private members more efficiently.

## Example

```java
public class Outer {

    private String secret = "Java11";

    class Inner {

        void display() {
            System.out.println(secret);
        }
    }
}
```

JVM now recognizes nesting relationships directly.

Benefits:

* Simpler bytecode
* Better performance
* Reduced synthetic methods

---

# 9. Dynamic Class-File Constants

Introduced:

```java
CONSTANT_Dynamic
```

Used internally by JVM.

Benefits:

* Reduce startup overhead
* Improve dynamic language support
* More efficient constant resolution

Mostly useful for JVM and framework developers.

---

# 10. Epsilon Garbage Collector

"No-op" garbage collector.

Memory is allocated but never reclaimed.

Enable:

```bash
java -XX:+UnlockExperimentalVMOptions \
     -XX:+UseEpsilonGC App
```

Use Cases:

* Performance testing
* Benchmarking
* Short-lived applications

---

# 11. Flight Recorder

Low-overhead monitoring and diagnostics.

Enable:

```bash
java -XX:StartFlightRecording=duration=60s,filename=recording.jfr App
```

Analyze:

```bash
jfr print recording.jfr
```

Benefits:

* Performance analysis
* CPU monitoring
* Memory tracking
* Thread analysis

---

# 12. Low-Overhead Heap Profiling

Provides allocation sampling.

Enable:

```bash
java \
-XX:+UnlockCommercialFeatures \
-XX:+FlightRecorder
```

Useful for:

* Memory leak investigation
* Allocation hotspots
* Production monitoring

---

# 13. TLS 1.3 Support

Java 11 supports TLS 1.3.

Benefits:

* Faster handshakes
* Improved security
* Reduced latency

Check:

```java
System.out.println(
    SSLContext.getDefault()
);
```

---

# 14. Unicode 10 Support

Java 11 supports Unicode 10.

Benefits:

* Additional characters
* New emojis
* Better internationalization

Example:

```java
String emoji = "🤩";

System.out.println(emoji);
```

---

# 15. Java EE and CORBA Module Removal

Removed modules:

```text
java.xml.ws
java.xml.bind
java.activation
java.corba
java.transaction
java.se.ee
```

If required, use external dependencies such as:

* Jakarta XML Binding
* Jakarta Activation

Example Maven:

```xml
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>4.0.0</version>
</dependency>
```

---

# 16. Other Important Changes

## Optional.isEmpty()

```java
Optional<String> optional =
        Optional.empty();

System.out.println(
        optional.isEmpty()
);
```

Output:

```
true
```

---

## Predicate.not()

Before:

```java
list.stream()
    .filter(s -> !s.isEmpty())
```

Java 11:

```java
list.stream()
    .filter(Predicate.not(String::isEmpty))
```

Example:

```java
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        List<String> list =
                List.of("Java", "", "Python");

        list.stream()
                .filter(
                        Predicate.not(
                                String::isEmpty
                        )
                )
                .forEach(System.out::println);
    }
}
```

Output:

```
Java
Python
```

---

# 17. Summary

| Feature           | Description                           |
| ----------------- | ------------------------------------- |
| Lambda var        | Use var in lambda parameters          |
| String API        | isBlank(), repeat(), strip(), lines() |
| Files API         | readString(), writeString()           |
| Collection API    | toArray(String[]::new)                |
| HTTP Client       | Standard HTTP API                     |
| Source Execution  | java Hello.java                       |
| Nest Access       | Better inner class access             |
| Dynamic Constants | CONSTANT_Dynamic                      |
| Epsilon GC        | No-op garbage collector               |
| Flight Recorder   | Monitoring and diagnostics            |
| TLS 1.3           | Improved security                     |
| Unicode 10        | New characters and emojis             |
| Optional.isEmpty  | Empty Optional checks                 |
| Predicate.not     | Cleaner stream filtering              |

# Conclusion

Java 11 is one of the most important LTS releases, providing significant improvements in developer productivity, networking, string handling, diagnostics, and JVM performance. The HTTP Client API, String enhancements, source-file execution, and Flight Recorder are among the most commonly used features in modern enterprise Java applications.
