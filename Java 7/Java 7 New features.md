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

Earlier, Before Java 7, what developer has to do was we know that developer has to manually close all the resourses that we use in our application. It ca n be the file, it can be the stream, or database connection, either we have to close it manually. We have to keep all those connections in the finally block without forgetting. If we forget close, what was leading, It's a memory leak. That's why java 7 has  introduced try with resourses.
```
try()
  {
   ....
  }
```

## 4. Multi Catch block
Before java 7, We know that everytime we need a seperate catch block to handle any kind of exception logic but java 7 onwards multiple exception can be handled within a single catch. How? with the help of Pipe operator "|" .

```
try
   {
   }
Catch(ArithmeticException | NullPointException e)
   {
   }

Instead of having multiple catch block. we can have a single catch block seperated with difefrent exception by the pipe operator.






