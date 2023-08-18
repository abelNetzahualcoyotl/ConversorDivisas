import javax.swing.JOptionPane;

public class implementaConversor {

	
	public static void main(String[] args) {
		double saldo=0;
		String[] nombresMoneda={"dólares","euros","libras esterlinas","Yenes japoneses","won sul coreanos","pesos mexicanos","pesos mexicanos","pesos mexicanos","pesos mexicanos","pesos mexicanos"};
	    double[] tiposDeCambio={0.058,0.054,0.046,8.42,76.97,17.13,18.69,21.75,0.12,0.013};
		String[] opcionesConversionDivisas={"Convertir peso mexicano a dolar ",
				"Convertir peso mexicano a euro",
				"Convertir peso mexicano a Libras esterlinas",
				"Convertir peso mexicano a Yen Japonés",
				"Convertir peso mexicano a Won Sul Coreano",
				"Convertir de Dólar a peso mexicano",
				"Convertir de euro a peso mexicano",
				"Convertir de Libras esterlinas a peso  mexicano",
				"Convertir de Yen Japonés a peso mexicano",
				"Convertir de Won Sul Coreano a peso mexicano"
				};
		boolean continuar=true;
		
		DivisaConversor conversor=new DivisaConversor(saldo, 
				nombresMoneda, tiposDeCambio, opcionesConversionDivisas);
		do {
		conversor.ingresarDinero();
		int seleccion = conversor.mostrarMenu();
		double resultado= conversor.cambiarDivisa(seleccion);
		conversor.mostrarResultado(resultado, seleccion);
		int salir=conversor.salir();
			if (salir == JOptionPane.YES_OPTION) {
			            
			        } else {
			        	continuar=false;
			        	JOptionPane.showMessageDialog(null,"Has seleccionado terminar el programa");
			        }
		}
		
		while(continuar);
	}
	
	
}
