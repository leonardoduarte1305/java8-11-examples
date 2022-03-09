package java11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class VariaveisLocais {

	public static void main(String[] args) {
		var texto = "laranja";

//		Tipo incompativel
//		texto = 1;

//		Nao consegue inferir o tipo
//		var a;
//		var nada = null;
//		var outraCoisa = () -> System.out.println("Opa, blz?!");
//      var metodo = VariaveisLocais::algumMetodo;

		var lista1 = new ArrayList<>(); // ArrayList<Object>

		var lista2 = new ArrayList<Map<String, List<Integer>>>();

		for (var atual : lista2) {
			// atual eh do tipo Map<String, List<Integer>>
			System.out.println(atual);
		}

		Predicate<String> predicate1 = (@Deprecated var a) -> false;
	}

	void algumMetodo() {
	}
}
