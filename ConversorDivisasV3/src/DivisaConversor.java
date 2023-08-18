import javax.swing.JOptionPane;
public class DivisaConversor {
	private double saldo;
	private String[] nombresMoneda;
	private double[] tiposDeCambio;
	private String[] opcionesConversionDivisas;
	
	public DivisaConversor(double saldo,String[] nombresMoneda,double[] tiposDeCambio,String[] opcionesConversionDivisas) 
	{
		this.saldo=saldo;
		this.nombresMoneda=nombresMoneda;
		this.tiposDeCambio=tiposDeCambio;
		this.opcionesConversionDivisas=opcionesConversionDivisas;
	}
	
	
		public void setSaldo(double saldo) {
			this.saldo=saldo;
		}
		public  void ingresarDinero() {
			
			
			boolean ingresoCorrecto=true;
			do{
			String dineroT = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que quiera convertir:");
			if(dineroT!=null&&!dineroT.isEmpty()) {
				try{
					if (Double.parseDouble(dineroT)<0) {
						JOptionPane.showMessageDialog(
			                    null,
			                    "La cantidad ingresada debe ser escrita sin signo",
			                    "Error",
			                    JOptionPane.ERROR_MESSAGE);
					}
					else {
					this.setSaldo(Double.parseDouble(dineroT));
					ingresoCorrecto=false;	
					}
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(
		                    null,
		                    "La cantidad ingresada no es un número válido",
		                    "Error",
		                    JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			else if (dineroT!=null)
			{
				JOptionPane.showMessageDialog(
	                    null,
	                    "No has ingresado una cantidad. Por favor ingrese una cantidad correcta",
	                    "Error",
	                    JOptionPane.ERROR_MESSAGE);
			}
			else {
				cerrarPanel();
                
	        	 }
		
			
			}
		while(ingresoCorrecto);
			
}
		public  int  mostrarMenu() {
			
			int indice=0;
			Object cambioDivisa= JOptionPane.showInputDialog(
	                null,
	                "Seleccione la moneda a la que quieras convertir tu dinero:",
	                "Selecciona divisa a convertir", 
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                this.opcionesConversionDivisas,
	                this.opcionesConversionDivisas[0]	
	        );
	        
	        if (cambioDivisa!=null) {
	        
	        for (indice=0;indice<opcionesConversionDivisas.length;indice++) {
	        	if(cambioDivisa.equals(opcionesConversionDivisas[indice])) {
	        		
	        		break;
	        	}
	        	        	
	        }
	            
	        
		}
	        else {cerrarPanel();}
	        
	        
			return indice;
	     
	        
}
		public  double cambiarDivisa(int seleccion) {
        	double convertido=this.saldo*this.tiposDeCambio[seleccion];
        	return convertido;
        }
		
		public void  mostrarResultado(double cantidadConvertida,int seleccion) {
			JOptionPane.showMessageDialog(null, "Tienes "+cantidadConvertida+" "+this.nombresMoneda[seleccion]);
        }
		
		public int salir() {
			Object[] options = {"Sí", "No", "Cancelar"};
			
			return JOptionPane.showOptionDialog(null,
					"¿Desea continuar?", 
					"Confirmación", 
					JOptionPane.YES_NO_OPTION,
						
				JOptionPane.QUESTION_MESSAGE,
				null,
                options,
                options[2] //
        );
		}
		private void cerrarPanel() {
			int option = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro que quieres cerrar el programa?",
                    "Cerrar programa",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                
                System.exit(0);
            }
		}
		}
		
		


