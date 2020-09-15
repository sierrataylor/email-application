package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email em1 = new Email("Sierra", "Taylor");	
		em1.changePassword("applesauce123!");
//		em1.setAlternateEmail("staylor23@jcu.edu");
//		System.out.println(em1.getAlternateEmail());
		em1.setMailboxCapacity(300);
		System.out.println(em1.showInfo());
	}
}