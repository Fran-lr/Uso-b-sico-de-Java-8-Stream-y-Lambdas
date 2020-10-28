package Paquete_10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoLambda {

	public static void main(String[] args) {
		List<Alumno> listaAlumnos = new ArrayList<>();

		listaAlumnos.add(new Alumno(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java 8", 7, 28));
		listaAlumnos.add(new Alumno(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java 8", 10, 33));
		listaAlumnos.add(new Alumno(3, "1717328901", "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
		listaAlumnos.add(new Alumno(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
		
		
		//En el primer ejemplo vamos a obtener todos los alumnos de la lista:
		System.out.println("*** Lista de Alumnos ***");
		listaAlumnos.stream().forEach(a->System.out.println(a));
		//o
		listaAlumnos.stream().filter(a -> true).forEach(a -> System.out.println(a));
		
		//A continuación vamos a imprimir todos aquellos alumnos cuyo nombre empieza con el caracter ‘L’ o ‘G’, esto se valida utilizando una operación intermedia con filter.
		System.out.println("\n*** Alumnos cuyo nombre empiezan con el caracter L u G ***");
		listaAlumnos.stream().filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G').forEach(c -> System.out.println(c));
		
		//Con el método count() que vendría siendo una operación terminal (mencionada anteriormente) y con la que devolvemos la longitud de la lista:
		System.out.println("\n**** Número de Alumnos ***");
		// número de elementos en la lista
		System.out.println(listaAlumnos.stream().count());
		
		//Obtener los alumnos con notas mayores a 9 y que el curso sea PHP:
		System.out.println("\n**** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
		// alumnos con notas mayores a 9
		listaAlumnos.stream().
		filter(a -> a.getNota() > 9 && a.getNombreCurso().equals("PHP")).forEach(p -> System.out.println(p));
		
		//Imprimir los 2 alumnos de la lista con el método limit(numero_elementos):
		System.out.println("\n**** Imprimir los 2 primeros Alumnos de la lista ***");
		listaAlumnos.stream().limit(2).forEach(a -> System.out.println(a));
				
		//Obtener el alumno que tiene la menor edad:
		System.out.println("\n**** Imprimir el alumno con menor edad ***");
		// minimo por edad
		System.out.println(listaAlumnos.stream().min((a1, a2) -> a1.getEdad() - a2.getEdad()));
		
		//Obtener el alumno que tiene la mayor edad:
		System.out.println("\n**** Imprimir el alumno con mayor edad ***");
		// maximo por edad
		System.out.println(listaAlumnos.stream().max((a1, a2) -> a1.getEdad() - a2.getEdad()));
		
		//Obtener el primer alumno de la lista con el método findFirst():
		System.out.println("\n**** Encontrar el primer Alumno***");
		// encontrar el primer registro
		System.out.println(listaAlumnos.stream().findFirst());
		
		//Obtener los alumnos cuyos nombres de curso termine con el caracter ‘t’:
		System.out.println("\n**** Alumnos en los  que los nombres de los cursos (lenguajes) que terminan en t ***");
		listaAlumnos.stream().filter(a -> a.getNombreCurso().endsWith("t")).forEach(System.out::println);
		
		//Obtener los alumnos cuyos nombres de curso contengan el caracter ‘a’:
		System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
		listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);
		
		//Obtener los alumnos cuya longitud de nombres sea mayor a 10:
		System.out.println("\n**** Alumnos en que su tamaño de su nombre es mayor a 10 caracteres ***");
		listaAlumnos.stream().filter(a -> a.getNombres().length() > 10).forEach(System.out::println);
		
		//Obtener los alumnos, cuyo nombre empiece con el caracter ‘P’ y la la longitud de su nombre sea <= a 6:
		// combinar predicados
		System.out.println("\n**** Combinación de predicados ***");
		Predicate<Alumno> empiezaConJ = a -> a.getNombreCurso().startsWith("P");
		Predicate<Alumno> longitud = a -> a.getNombreCurso().length() <= 6;
		// Obtiene los alumnos en los cuales el nombre del curso empieza con el
		// caracter 'P' y la longitud sea <= a 6
		listaAlumnos.stream().filter(empiezaConJ.and(longitud)).forEach(System.out::println);
		
		//Hasta ahora hemos mostrado por consola todas las consultas realizadas, pues bien si queremos asignar dicha consulta a una nueva lista debemos hacer lo siguiente:
		System.out.println("\n**** Stream a una lista ***");
		List<Alumno> nuevaLista= listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).collect(Collectors.toList());
		nuevaLista.forEach(System.out::println);
	
	}

}
