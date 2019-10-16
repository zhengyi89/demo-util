package com.test.gc;

public class FinalizeTest {
	public static void main(String[] args) {
		Book b = new Book(true);
		b.checkIn();
		Book c = new Book(true);
		try {
			b.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.gc();
	}

}

class Book {
	boolean checkOut = false;

	public Book(boolean checkOut) {
		this.checkOut = checkOut;
	}

	void checkIn() {
		checkOut = false;
	}

	@Override
	protected void finalize() throws Throwable {
		if (checkOut) {
			System.out.println("book recycle");
			// TODO Auto-generated method stub
			super.finalize();
		}
	}
}