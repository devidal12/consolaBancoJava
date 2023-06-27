package banco.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {
	
	//atributos de la clase consola
	private List<Gestor> gestores;
	private List<Cliente> clientes;
	private List<Mensaje> mensajes;
	private List<Transferencia> transferencias;
	private Integer siguienteIdGestor;
	private Integer siguienteIdCliente;
	private int siguienteMensaje;
	private Integer siguienteTransferencia;
	private Scanner teclado;
	private Gestor gestorLogeado;
	
	
	
	
	ConsolaBanco(){
		this.gestores = new ArrayList();
		this.clientes = new ArrayList();
		this.mensajes = new ArrayList();
		this.transferencias = new ArrayList();
		this.siguienteIdGestor = 1;
		this.siguienteIdCliente = 1;
		this.siguienteMensaje = 1;
		this.siguienteTransferencia = 1;
		this.teclado = new Scanner (System.in);
		
		
	}
	
	
	private void login() {
		System.out.println("Id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.println("Contraseña: ");
		String pass = teclado.next();
		Gestor gestor = buscarGestorPorId(idGestor);
		if(gestor != null) {
		     if(gestor.getPassword().equals(pass)) {
		    	 System.out.println("Login correcto");
		    	 gestorLogeado = gestor;
		     } else {
		    	 System.out.println("Login incorrecto");
		     }
		
		} else {
			System.out.println("El usuario no existe...");
		}
}
	
	private void mostrarMenu() {
		System.out.println("1.  Insertar gestor\n2.  Insertar gestores de prueba\n3.  Consultar gestor\n4.  Ver todos los gestores\n5.  Actualizar gestor \n6.  Eliminar gestores\n7.  Insertar Cliente\n8.  Obtener cliente\n9.  Obtener todos los clientes\n10. Actualizar cliente\n11. Eliminar cliente\n12. Obtener un mensajes\n13. Obtener todos los mensajes\n14. Enviar mensaje\n15. Obtener transferencia\n16. Obtener todas las transferenias\n17. Realizar transferencia \n18. Login\n0.  Salir\n");
	}
	
	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito");
		
	}
	
	private void insertarGestoresDePrueba() {
		System.out.println("Numero de gestores: ");
		int numeroGestores = teclado.nextInt();
		
		for (int i= 0; i<10 ; i++) {
			
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor,usuario, "", correo, "");
			gestores.add(gestor);
			siguienteIdGestor++;
	    }
	}
	
	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		if(gestorResultado!=null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id"+ idGestor);
		}
	}
	
	
	private Gestor buscarGestorPorId(int id){
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for(int i=0; i< gestores.size();i++) {
			Gestor gestor = gestores.get(i);
			if(gestor.getId()==id) {
				gestorResultado = gestor;
				posicionGestor = i;
				return gestorResultado;
			}
		}		
		return null;
	}
	
	
	private void mostrarGestores() {
		System.out.println(gestores);
		if(gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores");
		} else {
			
			gestores.forEach(gestor-> {
				System.out.println(gestor);
			});
			
		}
	}
	
	private void actualizarGestor() {
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		
		if(gestorResultado!=null) {
			
			System.out.println("[N] Nombre");
			System.out.println("[E] Email");
			System.out.println("[C] Contraseña");
			System.out.println("[O] Oficina ");
			System.out.println("[X] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch(opcionActualizar) {
			case 'N':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				gestores.set(opcionActualizar, gestorResultado);
				break;
			case 'E':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				gestores.set(opcionActualizar, gestorResultado);
				break;
			case 'C':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				gestores.set(opcionActualizar, gestorResultado);
				break;
			case 'O':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				gestores.set(opcionActualizar, gestorResultado);
				break;
				
			default: 
				System.out.println("Opción no válida");
				
			}
			
			if (opcionActualizar != 'X') {
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
			
		} else {
			System.out.println("No se pudo encontrar un gestor con el id"+ idGestor);
		}
		
	}
	
	
	private void eliminarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		
		for(int i=0; i< gestores.size();i++) {
			Gestor gestor = gestores.get(i);
			if(gestor.getId()==idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				break;
			}
		}
		if(gestorResultado!=null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id"+ idGestor);
		}
		
	}
	
	
	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Saldo: ");
		Double saldo = teclado.nextDouble();
		
		
		
		
		Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, pass, email, saldo, siguienteIdGestor);
		clientes.add(nuevoCliente);
		siguienteIdCliente++;
		System.out.println("Cliente creado con éxito");
		
	}
	
	
	private void obtenerCliente() {
		
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		if(clienteResultado!=null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id"+ idCliente);
		}
	}
	
	
	private Cliente buscarClientePorId(int idCliente){
		Cliente clienteResultado = null;
		for(int i=0; i< clientes.size();i++) {
			Cliente cliente = clientes.get(i);
			if(cliente.getId()==idCliente) {
				clienteResultado = cliente;
				return clienteResultado;
			}
		}		
		return null;
		
	}
	
	private void mostrarClientes() {
		System.out.println(clientes);
		if(clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes");
		} else {
			
			clientes.forEach(cliente-> {
				System.out.println(cliente);
			});
			
		}
	}
	
	
	private void actualizarCliente() {
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		
		if(clienteResultado!=null) {
			
			System.out.println("[N] Nombre");
			System.out.println("[E] Email");
			System.out.println("[C] Contraseña");
			System.out.println("[S] Saldo ");
			System.out.println("[X] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch(opcionActualizar) {
			case 'N':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				clientes.set(opcionActualizar, clienteResultado);
				break;
			case 'E':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				clientes.set(opcionActualizar, clienteResultado);
				break;
			case 'C':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				clientes.set(opcionActualizar, clienteResultado);
				break;
			case 'O':
				System.out.print("Saldo: ");
				Double saldo = teclado.nextDouble();
				clienteResultado.setSaldo(saldo);
				clientes.set(opcionActualizar, clienteResultado);
				break;
				
			default: 
				System.out.println("Opción no válida");
				
			}
			
			if (opcionActualizar != 'X') {
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
			
		} else {
			System.out.println("No se pudo encontrar un cliente con el id"+ idCliente);
		}
		
	}
	
	
	private void eliminarCliente() {
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		
		for(int i=0; i< clientes.size();i++) {
			Cliente cliente = clientes.get(i);
			if(cliente.getId()==idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				break;
			}
		}
		if(clienteResultado!=null) {
			clientes.remove(posicionCliente);
			System.out.println("Se eliminó el cliente con el id " + idCliente);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id"+ idCliente);
		}
		
	}
	
	private void obtenerMensaje() {
		
		
		System.out.print("Id del mensaje a consultar: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		if(mensajeResultado!=null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id"+ idMensaje);
		}
	}	
	
		
	private Mensaje buscarMensajePorId(int idMensaje){
		Mensaje mensajeResultado = null;
		for(int i=0; i< mensajes.size();i++) {
			 Mensaje mensaje = mensajes.get(i);
			if(mensaje.getId()==idMensaje) {
				mensajeResultado = mensaje;
				return mensajeResultado;
			}
		}		
		return null;

	}

	
	
	private void obtenerTodosMensajes() {
		
		System.out.println(mensajes);
		if(mensajes.isEmpty()) {
			System.out.println("Todavía no hay mensajes");
		} else {
			
			mensajes.forEach(mensaje-> {
				System.out.println(mensaje);
			});
			
		}
		
	}
	
	private void enviarMensaje() {
		System.out.println("Indica el id del destinatario");
		int idDestino = teclado.nextInt();
		
		System.out.print("Mensaje: ");
		String mensaje = teclado.next();
		
		int idOrigen = gestorLogeado.getId();
		
		
		Mensaje nuevoMensaje = new Mensaje(siguienteMensaje, idOrigen , idDestino, mensaje);
		mensajes.add(nuevoMensaje);
		siguienteMensaje++;
		
		System.out.println("Mensaje creado con éxito");
		
	}
	
//	private void obtenerTransferencia() {
//		System.out.print("Id de la transferencia a consultar: ");
//		int idTransferencia = teclado.nextInt();
//		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
//		if(transferenciaResultado!=null) {
//			System.out.println(transferenciaResultado);
//		} else {
//			System.out.println("No se pudo encontrar una transferencia con el id"+ idTransferencia);
//		}
//	}	
//	
//		
//	private Transferencia buscarTransferenciaPorId(int idTransferencia){
//		Transferencia transferenciaResultado = null;
//		for(int i=0; i< transferencias.size();i++) {
//			 Transferencia transferencia = transferencia.get(i);
//			if(transferencia.getId()==idTransferencia) {
//				transferenciaResultado = transferencia;
//				return transferenciaResultado;
//			}
//		}		
//		return null;
//		
//	}
	
	private void obtenerTodasTransferencias() {
		System.out.println(transferencias);
		if(transferencias.isEmpty()) {
			System.out.println("Todavía no hay transferencias");
		} else {
			
			transferencias.forEach(transferencia-> {
				System.out.println(transferencia);
			});
			
		}
		
	}
	
	private void enviarTransferencia() {
		System.out.println("Indica el id del destinatario");
		int idDestino = teclado.nextInt();
		
		System.out.print("Concepto: ");
		String concepto = teclado.next();
		siguienteMensaje++;
		
		System.out.print("Importe: ");
		Double importe = teclado.nextDouble();
		
		int idOrigen = gestorLogeado.getId();
		
		
		Transferencia nuevaTransferencia = new Transferencia(siguienteTransferencia, idOrigen , idDestino, importe, concepto);
     	transferencias.add(nuevaTransferencia);
		
		System.out.println("Transferencia creada con éxito");
		
	}
	
	
	private void cerrar() {
		teclado.close();
		System.out.println("¡Hasta pronto!");
	}
	
	private void iniciarConsola() {

		
		int opcion = -1;
		
		do {
		
			mostrarMenu();
			System.out.println("Selecciona una opción");
			opcion = teclado.nextInt();
			
			switch(opcion) {
			case 1: 
				insertarGestor();
				break;
				
			case 2: 
				    insertarGestoresDePrueba();
				    break;
			case 3 :
                consultarGestor();
				break;
			case 4: 
				
				mostrarGestores();
				break;
			case 5:
                actualizarGestor();
				break;
			case 6: 
                eliminarGestor();
				break;
			case 7: 
				insertarCliente();
				break;
			case 8: 
				obtenerCliente();
				break;
			
			case 9: 
				mostrarClientes();
				break;
				
			case 10: 
				actualizarCliente();
				break;
				
			case 11: 
				eliminarCliente();
			    break;    
			
		    case 12:
				obtenerMensaje();
				break;
			case 13: 
				obtenerTodosMensajes();
				break;
			case 14:
				enviarMensaje();
				break;
//			case 15:
//				obtenerTransferencia();
//				break;
			case 16:
				obtenerTodasTransferencias();
				break;
			case 17:
				enviarTransferencia();
			case 18: 
				login();
		        break;	
			case 0: 
				cerrar();
				break;
			default: 
				System.out.println("Opción desconocida");
			}
			
			
		} while(opcion!=0);
		
		
	}


	public static void main(String[] args) {
		
		
		
		ConsolaBanco consola = new ConsolaBanco();
		consola.iniciarConsola();
}
	}	
