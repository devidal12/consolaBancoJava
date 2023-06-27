package banco.pruebas;
import java.util.ArrayList;
import java.util.List;

import banco.modelos.Gestor;
import banco.util.Utiles;

public class PruebaUtil {


	public static void main(String[] args) {
		
		String nombreAleatorio = Utiles.nombreAleatorio(Utiles.NOMBRES , Utiles.APELLIDOS);
		
		System.out.println(nombreAleatorio);
		
		
		
		nombreAleatorio = Utiles.nombreAleatorio();
		System.out.println(nombreAleatorio);
		
		
		String[] nombres = {"José","Lucía","Marta","El PEPE"};
		String[] apellidos = {"Albert","García","Lucas","El PEPE"};
		
		nombreAleatorio= Utiles.nombreAleatorio(nombres, apellidos);
		
		
		System.out.println(nombreAleatorio);
		
		
		
		String correoAleatorio = Utiles.correoAleatorio(Utiles.NOMBRES , Utiles.APELLIDOSDOS, Utiles.CORREO, Utiles.DOMINIOS);
		
		System.out.println(correoAleatorio);
		
		
		
		// para guardar los gestores
		List<Gestor> gestores = new ArrayList<>();
      		
		for (int i=0 ; i<10; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(i+1, usuario, "", correo, "" );
			gestores.add(gestor);
			
		}
		
            System.out.println(gestores);
	}

}
