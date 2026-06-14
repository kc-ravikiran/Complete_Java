# Java 7 Features
## 1. Diamond Opeartor<>
Dimond operator allows the compiler to automatically identify the data type from the left side. there by reduces the bioler plate code.

**Syntax**
```
ArrayList<String> List = new ArrayList<>();
```
## 2. String in Switch Statement

The string is beign allowed inside the Switch statement directly.

```
String role = "HR"
     Switch(role)
         {
             case "HR":
             case "Admin":
             case "Developer":
         }
```
## 3. Try with Resourses

Earlier, Before Java 7, what developer has to do was we know that developer has to manually close all the resourses that we use in our application
