package exercice2;

public class Temperature {
    /*
    Ecrire une classe qui permet de représenter une température.
    Cette classe stocke la valeur de la température en celsius.
    Elle proposera les fonctionnalités suivantes :
    •	S'ajouter une température
    •	Retourner la valeur de la température en °C, en °F,  en K
    •	Tester l'égalité de températures
    •	Comparer deux températures (la méthode retournera une nombre négatif si la température sur laquelle
    on appelle la méthode est inférieur à la température passée en paramètre, 0 si elles sont égales, une
    nombre positif sinon)
    */

    private double temperatureCelsius;
    private double temperatureFahrenheit;
    private double temperatureKelvin;

    // Constructeur par défaut
    public Temperature() {
        this.temperatureCelsius = 25.0; // Température idéale votée par la classe (pas unanimement)
    }

    // 4 méthodes ici
    // Méthode 1 : S'ajouter une température
    public void ajouterTemperature(double temperatureAAjouter){
        this.temperatureCelsius += temperatureAAjouter;
        // équivaut à
        //this.temperatureCelsius = this.temperatureCelsius + temperatureAAjouter;
    }

    // Méthode 2 : Retourner la valeur de la température en °C, en °F,  en K
    public double getTemperatureCelsius (){
        return this.temperatureCelsius;
    }

    public double getTemperatureFahrenheit (){
        // Formule récupérée en ligne : to convert Celsius to Fahrenheit,
        // multiply the Celsius temperature by 1.8 (or 9/5) and then add 32.
        temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;
        return temperatureFahrenheit;
    }

    public double getTemperatureKelvin(){
        // Formule fournie en TD: K=C+273,15
        temperatureKelvin = temperatureCelsius + 273.15;
        return temperatureKelvin;
    }

    // Méthode 3 : Tester l'égalité de températures
    public boolean testEgaliteTemperatures(double temperature1, double temperature2){
       // Forme plus étalée
       if(temperature1 == temperature2){
           return true;
       } else {
           return false;
       }

        // Forme plus compacte
       // return (temperature1 == temperature2);
    }

    /* Méthode 4:
        Comparer deux températures (
         - la méthode retournera un nombre négatif si la température sur laquelle
        on appelle la méthode est inférieur à la température passée en paramètre,
        - 0 si elles sont égales,
        - un nombre positif sinon)
     */
    public int compareDeuxTemperatures(double temperatureAComparer){
        // Petit rappel : Cette classe stocke la valeur de la température en celsius
       if(this.temperatureCelsius == temperatureAComparer){
           // Égalité
            return 0;
       } else if(this.temperatureCelsius < temperatureAComparer){
           // Inférieur
           return -1;
       } else {
           // Supérieur
           return 1;
       }
    }
}
