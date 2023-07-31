
package in.co.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.Marksheet2Bean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.Marksheet2Model;
import in.co.rays.model.UserModel;

public class TestUser {

	public static void main(String[] args) throws Exception {
		// testDelete(6);
		// testAdd();
		//testUpdate();
		// testAuthenticate();
		// testDob();
		 testSearch();

	}

	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		bean.setFirstName("S");
		// bean.setRollNo("106");
		UserModel model = new UserModel();
		List list = model.Search(bean, 0, 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t " + bean.getLastName());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testDob() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();

		bean.setDob(sdf.parse("2005-07-11"));

		UserModel model = new UserModel();
		List list = model.Search(bean, 1, 2);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t " + bean.getAddress());

		}

	}

	private static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = model.Authenticate("suman12@gmail.con", "12345");

		if (bean == null) {

			System.out.println("Invalid");

		} else {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		}

		try {

			// UserBean bean = new UserBean();
			// UserModel model = new UserModel();

			bean.setLogin_id("suman12@gmail.com");
			bean.setPassword("12345");

			bean = model.Authenticate(bean.getLogin_id(), bean.getPassword());

			if (bean != null) {
				System.out.println("Successfully login");

			} else {
				System.out.println("Invalid login id and password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(1);
		bean.setFirstName("Kavita");
		bean.setLastName("Yadav");
		bean.setLogin_id("kavita12@gmail.com");
		bean.setPassword("7894");
		bean.setDob(sdf.parse("1996-02-04"));
		bean.setAddress("Bapat Square");

		model.update(bean);

	}

	private static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(6);
		bean.setFirstName("Kavita");
		bean.setLastName("Yadav");
		bean.setLogin_id("kavita12@gmail.com");
		bean.setPassword("7894");
		bean.setDob(sdf.parse("1996-02-04"));
		bean.setAddress("Bapat Square");

		model.add(bean);

	}

	private static void testDelete(int id) throws Exception {
		UserModel model = new UserModel();
		model.delete(id);

	}

}