package es.ulpgc.eite.da.basicquizlab;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import cucumber.api.java.After;
import cucumber.api.java.Before;

@SuppressWarnings("ALL")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuizEspressoTests {

    private static final int DELAY_IN_SECS = 0 * 1000;

    private QuizEspressoSteps steps = new QuizEspressoSteps();

    /*
    Context appContext =
            InstrumentationRegistry.getInstrumentation().getTargetContext();
    String[] questionArray =
            appContext.getResources().getStringArray(R.array.question_array);
    */

    @Rule
    public ActivityTestRule<QuestionActivity> testRule =
            new ActivityTestRule(QuestionActivity.class, true, false);

    private Activity activity;

    @Before
    public void setUp() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        testRule.launchActivity(new Intent());
        activity = testRule.getActivity();
    }

    @After
    public void tearDown() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        testRule.finishActivity();
    }


    /*
    public void girarPantalla() {

        int orientation = activity.getRequestedOrientation();

//    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//
//    } else {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//    }
//
//    activity.setRequestedOrientation(orientation);

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());

            if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                device.setOrientationNatural();

            } else {
                device.setOrientationLeft();
            }

        } catch (RemoteException e) {
        }

        try {
            Thread.sleep(DELAY_IN_SECS);
        } catch (InterruptedException e) {
        }
    }
    */


    /*
    Scenario Outline: responder a pregunta en Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    When pulsar boton "<button>"
    Then mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado

    Examples:
            | question           | button | answer | result    |
            | Question #1: True  | True   | True   | Correct   |
            | Question #1: True  | False  | True   | Incorrect |
    */

    @Test
    public void test10ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(1); //  True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // When pulsar boton "<button>"
        steps.pulsarBoton(R.id.trueButton);
        // Then mostrar resultado "<result>" a respuesta "<answer>"
        steps.mostrarResultadoARespuesta(R.string.correct_text);
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();

        tearDown();
    }

    /*
    Scenario Outline: pasar a Cheat sin responder a pregunta en Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    When pulsar boton Cheat
    Then iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton Back

    Examples:
            | question          |
            | Question #1: True |
    */

    @Test
    public void test20ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(1); // True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // When pulsar boton Cheat
        steps.pulsarBoton(R.id.cheatButton);
        // Then iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning();
        // And ocultar respuesta
        steps.ocultarRespuesta();
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // And pulsar boton Back
        steps.pulsarBotonBack();

        tearDown();
    }

    /*
    Scenario Outline: volver a Question sin mostrar respuesta en Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    When pulsar boton No
    Then finalizar pantalla Cheat
    And resumir pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
            | question          |
            | Question #1: True |
    */

    @Test
    public void test30ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(1); // True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBoton(R.id.cheatButton);
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning();
        // And ocultar respuesta
        steps.ocultarRespuesta();
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // When pulsar boton No
        steps.pulsarBoton(R.id.noButton);
        // Then finalizar pantalla Cheat
        steps.finalizarPantallaCheat();
        // And resumir pantalla Question
        steps.resumirPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(1);
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();

        tearDown();
    }


    /*
    Scenario Outline: mostrar respuesta en Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    When pulsar boton Yes
    Then mostrar respuesta "<answer>" a pregunta "<question>"
    And mostrar botones Yes y No desactivados
    And pulsar boton Back

    Examples:
            | question          | answer |
            | Question #1: True | True   |

    */


    @Test
    public void test40ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question>"
        steps.mostrarPregunta(1); // True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBoton(R.id.cheatButton);
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning();
        // And ocultar respuesta
        steps.ocultarRespuesta();
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // When pulsar boton Yes
        steps.pulsarBoton(R.id.yesButton);
        // Then mostrar respuesta "<answer>" a pregunta "<question>"
        steps.mostrarRespuestaAPregunta(R.string.true_text);
        // And mostrar botones Yes y No desactivados
        steps.mostrarBotonesYesYNoDesactivados();
        // And pulsar boton Back
        steps.pulsarBotonBack();

        tearDown();
    }

    /*
    Scenario Outline: volver a Question mostrando respuesta en Cheat

    Given iniciar pantalla Question
    And mostrar pregunta "<question1>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton Cheat
    And iniciar pantalla Cheat
    And mostrar mensaje Warning
    And ocultar respuesta
    And mostrar botones Yes y No activados
    And pulsar boton Yes
    And mostrar botones Yes y No desactivados
    And mostrar respuesta "<answer>" a pregunta "<question1>"
    When pulsar boton Back
    Then finalizar pantalla Cheat
    And resumir pantalla Question
    And mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
            | question1         | answer | question2          |
            | Question #1: True | True   | Question #2: False |

    */


    @Test
    public void test50ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question1>"
        steps.mostrarPregunta(1); // True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton Cheat
        steps.pulsarBoton(R.id.cheatButton);
        // And iniciar pantalla Cheat
        steps.iniciarPantallaCheat();
        // And mostrar mensaje Warning
        steps.mostrarMensajeWarning();
        // And ocultar respuesta
        steps.ocultarRespuesta();
        // And mostrar botones Yes y No activados
        steps.mostrarBotonesYesYNoActivados();
        // And pulsar boton Yes
        steps.pulsarBoton(R.id.yesButton);
        // And mostrar botones Yes y No desactivados
        steps.mostrarBotonesYesYNoDesactivados();
        // And mostrar respuesta "<answer>" a pregunta "<question1>"
        steps.mostrarRespuestaAPregunta(R.string.true_text);
        // When pulsar boton Back
        steps.pulsarBotonBack();
        // Then finalizar pantalla Cheat
        steps.finalizarPantallaCheat();
        // And resumir pantalla Question
        steps.resumirPantallaQuestion();
        // And mostrar pregunta "<question2>"
        steps.mostrarPregunta(2); // False
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();

        tearDown();
    }

    /*
    Scenario Outline: pasar a siguiente pregunta en Question

    Given iniciar pantalla Question
    And mostrar pregunta "<question1>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado
    And pulsar boton "<button>"
    And mostrar resultado "<result>" a respuesta "<answer>"
    And mostrar botones True y False y Cheat desactivados
    And mostrar boton Next activado
    When pulsar boton Next
    Then mostrar pregunta "<question2>"
    And ocultar resultado
    And mostrar botones True y False y Cheat activados
    And mostrar boton Next desactivado

    Examples:
            | question1         | button  | answer  | result    | question2          |
            | Question #1: True | True    | True    | Correct   | Question #2: False |
            | Question #1: True | False   | True    | Incorrect | Question #2: False |


    */

    @Test
    public void test60ResponderAPreguntaEnQuestion() {

        setUp();

        // Given iniciar pantalla Question
        steps.iniciarPantallaQuestion();
        // And mostrar pregunta "<question1>"
        steps.mostrarPregunta(1); // True
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();
        // And pulsar boton "<button>"
        steps.pulsarBoton(R.id.trueButton);
        // And mostrar resultado "<result>" a respuesta "<answer>"
        steps.mostrarResultadoARespuesta(R.string.correct_text);
        // And mostrar botones True y False y Cheat desactivados
        steps.mostrarBotonesTrueYFalseYCheatDesactivados();
        // And mostrar boton Next activado
        steps.mostrarBotonNextActivado();
        // When pulsar boton Next
        steps.pulsarBoton(R.id.nextButton);
        // Then mostrar pregunta "<question2>"
        steps.mostrarPregunta(2); // False
        // And ocultar resultado
        steps.ocultarResultado();
        // And mostrar botones True y False y Cheat activados
        steps.mostrarBotonesTrueYFalseYCheatActivados();
        // And mostrar boton Next desactivado
        steps.mostrarBotonNextDesactivado();

        tearDown();
    }
}
