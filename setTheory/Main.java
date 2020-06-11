package setTheory;

public class Main {

	public static void main(String[] args) {
		/*
		Function function = new Function() {
		
			@Override
			public CombSet operate() {
				function.action = function.identity(Object);
			}
		}
		*/
		int ruleCount = 20;
		Function[] function = new Function[ruleCount];
		for (int i = 0; i < ruleCount; i++) {
			Add add = new Add();
			add.input[0] = i;
			add.input[1] = i*i;
			function[i].op = add;
			
		}
		Add add = new Add();
		add.input[0] = 3;
		add.input[1] = 2;
		
		Identity 

	}

}
