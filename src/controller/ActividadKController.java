package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.time.LocalDateTime;

public class ActividadKController implements Initializable{

	@FXML
	private ImageView imgDosPuntos1;
	
	@FXML
	private ImageView imgDosPuntos2;
	
	@FXML
	private ImageView imgHora1;
	
	@FXML
	private ImageView imgHora2;
	
	@FXML
	private ImageView imgMinuto1;
	
	@FXML
	private ImageView imgMinuto2;
	
	@FXML
	private ImageView imgSegundo1;
	
	@FXML
	private ImageView imgSegundo2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LocalDateTime hora= LocalDateTime.now();
		TimerTask task = new TimerTask() {
	        /**
	         * Método que guarda la hora del sistema e implanta las imagenes correspondientes en el fxml.
	         * Se refresca cada segundo.
	         */
			public void run() {
	        	// Damos valores a las variables desde el inicio con la hora del sistema
	        	int nHoras = new Date().getHours();
	        	int nMinuto = new Date().getMinutes();
	        	int nSegundo = new Date().getSeconds();
	        	
	        	// Colocamos las imagenes correspondientes en la ventana con el método auxiliar.
	        	calculaTiempo(nHoras,imgHora1,imgHora2);
	        	calculaTiempo(nMinuto,imgMinuto1,imgMinuto2);
	        	calculaTiempo(nSegundo,imgSegundo1,imgSegundo2);
	        	
	        	
	        	while (true) {
	        		int nHoraNueva = new Date().getHours();
	        		int nMinutoNuevo = new Date().getMinutes();
	        		int nSegundoNuevo = new Date().getSeconds();
	        		if (nHoraNueva!=nHoras) {
	        			nHoras=nHoraNueva;
	        			calculaTiempo(nHoras,imgHora1,imgHora2);
	        		}
	        		if (nMinutoNuevo!=nMinuto) {
	        			nMinuto=nMinutoNuevo;
	        			calculaTiempo(nMinuto,imgMinuto1,imgMinuto2);
	        		}
	        		if (nSegundoNuevo!=nSegundo) {
	        			nSegundo=nSegundoNuevo;
	        			calculaTiempo(nSegundo,imgSegundo1,imgSegundo2);
	        		}	
	        	}
	        }
	    };
	    Timer timer = new Timer("Timer");	    
	    long delay = 1000L;
	    timer.schedule(task, delay);
	}
	
	/**
	 * Separa el tiempo en dos dígitos.
	 * @param t tiempo
	 * @param i1 primer espacio de imagen
	 * @param i2 segundo espacio de imagen
	 */
	private void calculaTiempo(int t,ImageView i1, ImageView i2) {
		int num1 = t%10;
		int num2 = (t-num1)/10;

		seleccionarImagen(num1,i2);
		seleccionarImagen(num2,i1);
	}

	/**
	 * Vincula la imagen del número con el espacio pasado como parámetro.  
	 * @param n número
	 * @param i espacio de imagen
	 */
	private void seleccionarImagen(int n,ImageView i) {
		switch (n) {
		case 1:
			i.setImage(new Image(getClass().getResource("/img/ONE.png").toString()));
			break;
		case 2:
			i.setImage(new Image(getClass().getResource("/img/TWO.png").toString()));
			break;
		case 3:
			i.setImage(new Image(getClass().getResource("/img/THREE.png").toString()));
			break;
		case 4:
			i.setImage(new Image(getClass().getResource("/img/FOUR.png").toString()));
			break;
		case 5:
			i.setImage(new Image(getClass().getResource("/img/FIVE.png").toString()));
			break;
		case 6:
			i.setImage(new Image(getClass().getResource("/img/SIX.png").toString()));
			break;
		case 7:
			i.setImage(new Image(getClass().getResource("/img/SEVEN.png").toString()));
			break;
		case 8:
			i.setImage(new Image(getClass().getResource("/img/EIGHT.png").toString()));
			break;
		case 9:
			i.setImage(new Image(getClass().getResource("/img/NINE.png").toString()));
			break;
		case 0:
			i.setImage(new Image(getClass().getResource("/img/ZERO.png").toString()));
			break;
		}
	}
}
