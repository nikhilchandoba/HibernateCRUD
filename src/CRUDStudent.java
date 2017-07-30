import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CRUDStudent {
	static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i!=6) {
			System.out.println("wellcome");
			System.out.println("1:inserte the data ");
			System.out.println("2:Display the data ");
			System.out.println("3:Delete the data ");
			System.out.println("4:Update the data ");
			System.out.println("5:Edite the data");
			System.out.println("6:Exit");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			factory = cfg.buildSessionFactory();

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			switch (i) {
			case 1:
				Student st = new Student();
				String f, l;
				System.out.println("Enter the student f name");
				f = sc.next();
				st.setS_fname(f);
				System.out.println("Enter the student l name");
				l = sc.next();
				st.setS_lname(l);
				session.save(st);
				tx.commit();
				break;
			case 2:
				// tx=session.beginTransaction();
				Criteria c = session.createCriteria(Student.class);
				List<Student> std = c.list();

				for (Student st12 : std) {
					System.out.println("ID=" + st12.getId());
					System.out.println("f name=" + st12.getS_fname());
					System.out.println("l name=" + st12.getS_lname());
				}
				break;
			case 3:
				System.out.println("Enter the id=");
				int d = sc.nextInt();
				Student std1 = (Student) session.load(Student.class, d);
				session.delete(std1);
				session.beginTransaction().commit();

				System.out.println("deleted");
				break;
			case 4:
				System.out.println("Enter the Id of student to be updated");
				int id = sc.nextInt();
				Student std34 = (Student) session.load(Student.class, id);
				System.out.println("Enter the f name");
				String sf = sc.next();
				std34.setS_fname(sf);
				System.out.println("Enter the l name");
				String sl = sc.next();
				std34.setS_lname(sl);
				session.update(std34);

				session.beginTransaction().commit();

				System.out.println("updated");
				break;
			case 5:int j=0;
				
					System.out.println("Enter the Id of student to be Edit");
					int id1 = sc.nextInt();
					while(j!=3){
					Student std314 = (Student) session.load(Student.class, id1);
					System.out.println("1:fname");
					System.out.println("2:lname");
					System.out.println("3:exite");
					 j = sc.nextInt();
					switch (j) {
					case 1:
						System.out.println("Enter the f name");
						String sf1 = sc.next();
						std314.setS_fname(sf1);
						session.update(std314);
						session.beginTransaction().commit();
						System.out.println("updated");
						break;

					case 2:
						System.out.println("Enter the l name");
						String sl1 = sc.next();
						std314.setS_lname(sl1);
						session.update(std314);
						session.beginTransaction().commit();
						System.out.println("updated");
						break;
					default:
						System.out.println("hi hi");
					}}
				

			case 6:
				
				System.out.println("Thanku......");
				session.close();
				//System.exit(0);
				break;

			default:
				System.out.println("sorry...");
				System.out.println("plz Enter correct choice");

			}
		}

		/*
		 * System.out.println("data was insert"); Student
		 * std0=(Student)session.load(Student.class, 1); System.out.println(
		 * "first name="+std0.getS_fname()); System.out.println("last name="
		 * +std0.getS_lname());
		 */

	}

}
