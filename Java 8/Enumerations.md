## Enumerations or enums
Enumerations or enums is used to represent a fixed set of constants so this enums provides the type safety as well as improve the readability of the code also.
It's like a class which can have Constructors, Methods, and Variables.

### Example 1:
```
enum Status
{
	ACTIVE,
	INACTIVE,
	BLOCKED
}

public class enumSwitch {

	public static void main(String[] args) {
		Status s = Status.ACTIVE;
		
		switch(s)
		{
		case ACTIVE:
			System.out.println("User is Active");
			break;
			
		case INACTIVE:
			System.out.println("User is Inactive");
			break;
			
		case BLOCKED:
			System.out.println("User is Blocked");
			break;
		}
	}
}
```
### Example 2:
```
enum Stat{
	Running, Failed, Pending, Success;
}
public class enumExample {
	public static void main(String[] args) 
	{
		Stat[] ss= Stat.values();		
		for(Stat s: ss) 
		{
			System.out.println(s+ ":" +s.ordinal());
		}

	}

}
```

### Example 3:
```
 enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}

public class EnumDays {
    Day day;
    
    public EnumDays(Day day) {
        this.day = day;
    }    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

	public static void main(String[] args) {
		 EnumDays firstDay = new EnumDays(Day.MONDAY);
	        firstDay.tellItLikeItIs();
	        EnumDays thirdDay = new EnumDays(Day.WEDNESDAY);
	        thirdDay.tellItLikeItIs();
	        EnumDays fifthDay = new EnumDays(Day.FRIDAY);
	        fifthDay.tellItLikeItIs();
	        EnumDays sixthDay = new EnumDays(Day.SATURDAY);
	        sixthDay.tellItLikeItIs();
	        EnumDays seventhDay = new EnumDays(Day.SUNDAY);
	        seventhDay.tellItLikeItIs();	
	}

}

```
