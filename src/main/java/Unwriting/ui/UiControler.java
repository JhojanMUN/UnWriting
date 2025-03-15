package Unwriting.ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Class Principal del control de la interfaz. animaciones y eventos realizados por el usuario
 * @author Jhojan Moreno
 * @version 1.0
 */
public class UiControler {
    public AnchorPane MainController;
    @FXML
    boolean jugando = false;
    int intentos = 4;
    int nivel = 1;
    int progrestimer = 0;
    int tp = 0;
    String[] n1 = {"a", "b", "123456789","Hola","Pajaro","Contenedor","Java","Altavoz","Union","Murcielago","Avispa","Insectos","Malestar","Pantalone","Doctor Purgon","Interpersonalidades","Fpoe","Algebra Lineal","Alcancia","Yesterday","Love is war","Daoko","Interlocutor","Llorando por lluvia","Pasaporte","Luchela con Elias manito","Hello World", "repta" , "circular"};

    @FXML
    private Label LabelTitulo;

    @FXML
    private Label LabelLevel;

    @FXML
    private Label LabelTimer;

    @FXML
    private Label LabelFrase;

    @FXML
    private ImageView Ima1, Ima2, Ima3, Ima4;

    @FXML
    private Label labelMensaje;

    @FXML
    private TextField textFieldEntrada;

    @FXML
    private Button btnPushme;

    private Timeline timer;
    private int tiempoRestante = 21;


    /**
     *Zona donde inicia toda la parte de animacion del titulo con las lunas y soles
     *image[] arreglo donde van las imagenes para la animacion
     * frames representa la ubicacion del valor de cada contenedor de imagen
     */
    private Image[] frames; // Arreglo con las imágenes de la animación
    private Image[] frames2; // Imágenes para Ima2
    private Image[] frames3; // Imágenes para Ima3
    private Image[] frames4; // Imágenes para Ima4

    private int frameIndex = 0;
    private Timeline animation;

    /**
     *Define donde se ubicada toda la animacion imagen por imagen
     */
    @FXML
    private void cargarImagenesTitulo() {
        frames = new Image[]{
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
        };
        frames2 = new Image[]{
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
        };
        frames3 = new Image[]{
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
        };
        frames4 = new Image[]{
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
                new Image("file:src/main/resources/Imagenes/Moono.png"),
        };
    }

    private Timeline animacionSol;

    @FXML
    private void cargarImagenesVidas() {
        Image[] imagenSol = {
                new Image("file:src/main/resources/Imagenes/sun1.png"),
                new Image("file:src/main/resources/Imagenes/sun2.png")
        };
        Image[] imagenLuna = {
                new Image("file:src/main/resources/Imagenes/Moono.png")
        };

        // Asignar las imágenes según los intentos
        frames = (intentos > 0) ? imagenSol : imagenLuna;
        frames2 = (intentos > 1) ? imagenSol : imagenLuna;
        frames3 = (intentos > 2) ? imagenSol : imagenLuna;
        frames4 = (intentos > 3) ? imagenSol : imagenLuna;

        iniciarAnimacion();
    }

    private void iniciarAnimacion() {
        if (animacionSol != null) {
            animacionSol.stop();
        }

        animacionSol = new Timeline(new KeyFrame(Duration.seconds(0.3), e -> alternarImagenes()));
        animacionSol.setCycleCount(Animation.INDEFINITE);
        animacionSol.play();
    }

    /**
     * Alterna y separa los soles de las lunas por intentos posibles restantes
     */
    private void alternarImagenes() {
        if (intentos > 0) {
            Ima1.setImage(Ima1.getImage() == frames[0] ? frames[1] : frames[0]);
        }
        if (intentos > 1) {
            Ima2.setImage(Ima2.getImage() == frames2[0] ? frames2[1] : frames2[0]);
        }
        if (intentos > 2) {
            Ima3.setImage(Ima3.getImage() == frames3[0] ? frames3[1] : frames3[0]);
        }
        if (intentos > 3) {
            Ima4.setImage(Ima4.getImage() == frames4[0] ? frames4[1] : frames4[0]);
        }
    }


    @FXML
    private void iniciarAnimacionTitulo() {
        if (animation == null || animation.getStatus() == Timeline.Status.STOPPED) {
            animation = new Timeline(new KeyFrame(Duration.millis(200), event -> {
                Ima1.setImage(frames[frameIndex]);
                Ima2.setImage(frames2[frameIndex]);
                Ima3.setImage(frames3[frameIndex]);
                Ima4.setImage(frames4[frameIndex]);

                frameIndex = (frameIndex + 1) % frames.length;
            }));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }
    }
    //fin animaciones

    /**
     * Metodo que se ejecuta automaticamente al cargar la interfaz
     */
    @FXML
    public void initialize() {
        LabelTitulo.setText("UnWriting");
        LabelLevel.setText("Nivel 0");
        LabelTimer.setText("00:00");
        LabelFrase.setText("Bienvenido");
        labelMensaje.setText("Presiona el Boton para Comenzar");
        cargarImagenesTitulo();
        iniciarAnimacionTitulo();


        // Define la funcionalidad al boton y al enter
        textFieldEntrada.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                onPushmeClick();
            }
        });
        btnPushme.setOnAction(event -> onPushmeClick());
    }
        //fin


    /**
     * Metodo que define el timer y la cuenta regresiva
     * parametro tiempoRestante define el tiempo total
     * parametro progrestimer define cuanto se le resta a los 5 niveles
     */
    private void iniciarCuentaRegresiva() {
        tiempoRestante = 21 - progrestimer;
        LabelTimer.setText("00:" + tiempoRestante);

        if (timer != null) {
            timer.stop();
        }
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            tiempoRestante--;
            LabelTimer.setText(String.format("00:%02d", tiempoRestante));

            if (tiempoRestante <= 0) {
                terminar();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    //fin timer


    /**
     * Metodo que define lo que cuando se presiona el boton o se pulsa enter segun los intentos restantes
     */

    @FXML
    private void onPushmeClick() {
        if (!jugando) {
            if (intentos >= 1) {
                Vidas();
                jugando = true;
                LabelLevel.setText("Nivel 1");
                iniciarCuentaRegresiva();
                palabra();
            }else {
                intentos = 4;
                progrestimer = 0;
                tp = 0;
                nivel = 1;
                textFieldEntrada.setText("");
                labelMensaje.setText("Presiona el Boton para Comenzar");
                LabelFrase.setText("Bienvenido");
            }
        } else { //si esta jugando
            if (intentos >= 1) {
                ValidarPalabra();
            }
        }
    }
    private void Vidas() {
        cargarImagenesVidas();
        frameIndex = 0;
    }


    /**
     * Metodo que genera la palabra nueva aleatoria
     */
    private void palabra() {
        int min = 0, max = 28;
        int numeroAleatorio = (int) (Math.random() * (max - min + 1) + min); // Entre 0 y 28
        LabelFrase.setText(n1[numeroAleatorio]);
        textFieldEntrada.setText("");
    }

    /**
     * Metodo que se encarga de validar lo que quede en la entrada del recuadro
     */

    private void ValidarPalabra() { //Cuando aciertan
        if (textFieldEntrada.getText().equalsIgnoreCase(LabelFrase.getText())) {
            if (intentos >= 1) {
                tp++;
                nivel++;
                LabelLevel.setText("Nivel " + nivel);
                tiempoRestante = 21 - progrestimer;
                labelMensaje.setText("Muy bien");
                palabra();
                if (tp == 4 && progrestimer < 18) {
                    progrestimer = progrestimer + 2;
                    tp = 0;
                }
            }
        }else { //Cuando se equivocan
            intentos = intentos - 1;
            if (intentos >= 1) {
                labelMensaje.setText("Error, Ingresaste: " + textFieldEntrada.getText() + " y no " + LabelFrase.getText());
                Vidas();
                tiempoRestante = 21 - progrestimer;
                textFieldEntrada.setText("");
                palabra();
            }else {
                terminar();
            }
                    }
    }

    /**
     * Define que se hace segun los intentos, en caso tal se reinicia para volver a empezar
     */

    private void terminar() {
        if (intentos >= 1){
            ValidarPalabra();
        }else {
            Vidas();
            timer.stop();
            labelMensaje.setText("¡Tiempo agotado!" + "Terminaste en el nivel " + nivel--);
            LabelFrase.setText("Te quedaste sin intentos");
            jugando = false;
        }
    }
}