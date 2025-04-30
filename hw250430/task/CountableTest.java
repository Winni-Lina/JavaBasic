package hw250430.task;

import lec250430.countable.Bird;
import lec250430.countable.Countable;
import lec250430.countable.Tree;

public class CountableTest {
	public static void main(String []args) {
		Countable[] clist = { new Bird("뻐꾸기", 5), new Bird("독수리", 2), new Tree("사과나무", 10), new Tree("밤나무", 7)};
		
		for (Countable c : clist) c.count();

		for(Countable c : clist) {
			if(c instanceof Bird) ((Bird) c).fly();
			else ((Tree) c).ripen();
		}
	}
}
