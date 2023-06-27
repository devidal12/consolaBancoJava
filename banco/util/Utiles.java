package banco.util;
import java.util.Random;
public class Utiles {
     
	// final indica que es una constante
	public static final String[] NOMBRES = {"Ana", "Jose", "Paco", "Irene"};
	public static final String[] APELLIDOS = {"Pérez", "Martín", "López", "García"};
	public static final String[] CORREO = {"1994", "vlc", "2004", "fcbarcelona","12","9", "", "", ""};
	public static final String[] APELLIDOSDOS = {"Pérez", "Martín", "López", "García", "", ""};
	public static final String[] DOMINIOS = {"@gmail.com", "@gmail.es", "@hotmail.com", "@correo.com", "@yahoo.com"};
	
	
	public static String nombreAleatorio(String[] nombres, String[] apellidos) {
		
		Random random = new Random();
		
		int indiceNombre = random.nextInt(nombres.length);
		String nombre = nombres[indiceNombre];
		
		int indiceApellidos = random.nextInt(apellidos.length);
		String apellido = apellidos[indiceApellidos];
		
		
		return nombre + " " + apellido;	
	}
	
	public static String nombreAleatorio() {
		return nombreAleatorio(NOMBRES, APELLIDOS);
		
	}
	
	
	public static String correoAleatorio(String[] nombres, String[] apellidosdos, String[] correos, String[] dominios) {
		
		Random random = new Random();
		
		int indiceNombre = random.nextInt(nombres.length);
		String nombre = nombres[indiceNombre];
		
		int indiceApellidosDos = random.nextInt(apellidosdos.length);
		String apellido = apellidosdos[indiceApellidosDos];
		
		int indiceCorreo = random.nextInt(correos.length);
		String correo = correos[indiceCorreo];
		
		int indiceDominios = random.nextInt(dominios.length);
		String dominio = dominios[indiceDominios];
		
		
		return nombre.toLowerCase()+ apellido.toLowerCase() + "_" + correo + dominio;
		
		
		
	}
	public static String correoAleatorio(){
		return correoAleatorio(NOMBRES, APELLIDOSDOS, CORREO, DOMINIOS);
	}
	
	
	
	
	
	
	
	
	
 
}

