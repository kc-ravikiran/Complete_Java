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
