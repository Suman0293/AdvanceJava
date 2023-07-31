package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.Marksheet2Bean;
import in.co.rays.model.Marksheet2Model;

public class TestMarksheet2 {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testDelete();
		//testUpdate();
		//testFindByRoll();
		testSearch();
	}

	private static void testSearch() throws Exception {
		Marksheet2Bean bean = new Marksheet2Bean();
		//bean.setFname("S");
		bean.setRollNo("106");
		Marksheet2Model modal = new Marksheet2Model();
		List list = modal.Search(bean);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			 bean = (Marksheet2Bean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t " + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.println("\t" + bean.getTotal());
		}
		
	}

	private static void testFindByRoll() throws Exception {
		Marksheet2Model model = new Marksheet2Model();
		Marksheet2Bean bean = model.FindByRoll(2);

		if (bean == null) {
			System.out.println("Not Exist");

		} else {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.println("\t" + bean.getTotal());
		}

		
	}

	private static void testUpdate() throws Exception {
		try {
			Marksheet2Bean bean = new Marksheet2Bean();
			Marksheet2Model model = new Marksheet2Model();
			
			bean.setPhysics(99);
			bean.setId(9);
			
			model.Update(bean);
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		
	}

	private static void testDelete() throws Exception {
		Marksheet2Model model = new Marksheet2Model();
		
		model.Delete(10);
		
	}

	private static void testAdd() throws Exception {
		Marksheet2Bean bean = new Marksheet2Bean();
		Marksheet2Model model = new Marksheet2Model();
		
		bean.setId(10);
		bean.setRollNo("110");
		bean.setFname("Kavita");
		bean.setLname("Yadav");
		bean.setPhysics(65);
		bean.setChemistry(87);
		bean.setMaths(99);
		bean.setTotal(300);
		
		model.Add(bean);
		
	}
}
