
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Carta baraja[] = new Carta[48];
		Carta monton[] = new Carta[48];
		int contador = 0; 
		
		//Crea la baraja de cartas y las mete en el array
		//oros
		for (int i = 1; i < 13; i++) {
			String numCarta = String.valueOf(i);
			
			switch (i) {
				case 1:
					baraja[contador] = new Carta ("Oros", "As");
					break;
					
				case 10:
					baraja[contador] = new Carta ("Oros", "Sota");
					break;
				
				case 11:
					baraja[contador] = new Carta ("Oros", "Caballo");
					break;
					
				case 12:
					baraja[contador] = new Carta ("Oros", "Rey");
					break;
					
				default:
					baraja[contador] = new Carta ("Oros", numCarta);
					break;
			}
			contador++;
		}
		
		//Espadas
				for (int i = 1; i < 13; i++) {
					String numCarta = String.valueOf(i);
					
					switch (i) {
						case 1:
							baraja[contador] = new Carta ("Espadas", "As");
							break;
							
						case 10:
							baraja[contador] = new Carta ("Espadas", "Sota");
							break;
						
						case 11:
							baraja[contador] = new Carta ("Espadas", "Caballo");
							break;
							
						case 12:
							baraja[contador] = new Carta ("Espadas", "Rey");
							break;
							
						default:
							baraja[contador] = new Carta ("Espadas", numCarta);
							break;
					}
					contador++;
				}
				
				//Bastos
				for (int i = 1; i < 13; i++) {
					String numCarta = String.valueOf(i);
					
					switch (i) {
						case 1:
							baraja[contador] = new Carta ("Bastos", "As");
							break;
							
						case 10:
							baraja[contador] = new Carta ("Bastos", "Sota");
							break;
						
						case 11:
							baraja[contador] = new Carta ("Bastos", "Caballo");
							break;
							
						case 12:
							baraja[contador] = new Carta ("Bastos", "Rey");
							break;
							
						default:
							baraja[contador] = new Carta ("Bastos", numCarta);
							break;
					}
					contador++;
				}
				
				//Copas
				for (int i = 1; i < 13; i++) {
					String numCarta = String.valueOf(i);
					
					switch (i) {
						case 1:
							baraja[contador] = new Carta ("Copas", "As");
							break;
							
						case 10:
							baraja[contador] = new Carta ("Copas", "Sota");
							break;
						
						case 11:
							baraja[contador] = new Carta ("Copas", "Caballo");
							break;
							
						case 12:
							baraja[contador] = new Carta ("Copas", "Rey");
							break;
							
						default:
							baraja[contador] = new Carta ("Copas", numCarta);
							break;
					}
					contador++;
				}
				
				contador = 0;
				int respuesta = 0;
				do {
					System.out.println();
					System.out.println("Indica que deseas hacer:");
					System.out.println("1.Barajar");
					System.out.println("2.Coger una carta");
					System.out.println("3.Mostrar el numero de cartas disponibles");
					System.out.println("4.Coger un numero de cartas");
					System.out.println("5.Revelar el monton de cartas que ya han salido");
					System.out.println("6.Revelar la baraja restante");
					System.out.println("7.Salir");
					
					respuesta = s.nextInt();
					
					switch (respuesta){
						case 1:
							barajar(baraja);
							System.out.println("Barajado correctamente");
							break;
							
						case 2:
							next(baraja, contador, monton);
							contador++;
							break;
							
						case 3:
							System.out.println("Quedan "+ (48 - contador) + " cartas restantes");
							break;
							
						case 4:
							System.out.println("Indique el numero de cartas que desea robar:");
							int nC = s.nextInt();
							darCartas(baraja, contador, nC, monton);
							contador += nC;
							break;
						
						case 5:
							if (contador != 0) {
								for(int i = 0; i < contador; i++) {
									System.out.println(monton[i]);
								}
							} else {
								System.out.println("Lo siento, todavia no ha salido ninguna carta");
							}
							break;
							
						case 6:
							if (contador < 48) {
								for(int i = contador; i < 48; i++) {
									System.out.println(baraja[i]);
								}
							} else {
								System.out.println("Lo siento, no quedan cartas");
							}
							break;
							
						default:
							System.out.println("La respuesta introducida no es correcta");
							break;
					}
				} while (respuesta != 7);
				
	}
	
	//funcion barajar
	public static void barajar (Carta baraja[]) {
		
		//cambia la posicion entre dos cartas del mismo array
		for(int i = 0; i < 48; i++) {
			int random = (int) (Math.random() * 48);
			
			Carta saved = baraja[i];
			
			baraja[i] = baraja[random];
			baraja[random] = saved;
		}
	}
	
	//siguiente carta
	public static void next (Carta baraja[], int contador, Carta monton[]) {

		if(contador < 48) {
			System.out.println(baraja[contador]);
			monton[contador] = baraja[contador];
		} else {
			System.out.println("No quedan mas cartas");
		}
	}
	
	//reparte un monton de cartas
	public static void darCartas (Carta baraja[], int contador, int nC, Carta monton[]) {
		
		if (nC < (48 - contador)) {
			for (int i = 0; i < nC; i++) {
				System.out.println(baraja[contador]);
				monton[contador] = baraja[contador];
				contador++;
			}
		} else {
			System.out.println("Lo sentimos, no hay suficientes cartas en la baraja");
		}
	}

}

