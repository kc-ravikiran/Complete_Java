


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
