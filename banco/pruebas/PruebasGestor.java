package banco.pruebas;

import banco.modelos.Gestor;

public class PruebasGestor {

	public static void main(String[] args) {
		
		Gestor gestor = new Gestor(1,"paco","1234","paco@correo.com", "asdas");
		Gestor gestorB = new Gestor(2,"ana","4321","ana@correo.com","asdas");
		
	    System.out.println(gestor);
	    
	    //alternativa con constructor vacío
	    gestorB.setId(2);
	    gestorB.setUsuario("ana");
	    gestorB.setPassword("4321");
        gestorB.setCorreo("ana@correo.com");	
        gestorB.setOficina("asdasd");
	    
	    if(gestor.equals(gestorB)) {
	    	System.out.println("Son el mismo gestor");
	    } else {
	    	System.out.println("Son gestores diferentes");
	    }

	}

}
